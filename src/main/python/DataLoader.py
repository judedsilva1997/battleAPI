import pandas as pd
import mysql.connector
import urllib.parse
import os


mydb = mysql.connector.connect(
  host="localhost",
  user=os.getenv('python.datasource.username', "user"),
  passwd= os.getenv('python.datasource.password', "password"),
  database="battles"
)
cursor = mydb.cursor()
cursor.execute("INSERT INTO Side (SideType) values('ATTACKER')")
cursor.execute("INSERT INTO Side (SideType) values('DEFENDER')")

FILE_LOC = "../resources/battles.csv"

all_data = pd.read_csv(FILE_LOC)


all_data = all_data.fillna("null")


def parse(val):
    return urllib.parse.quote_plus(val)

def load_warriors(df,cursor):
    print("Loading warriors")
    names = set(df.attacker_king.unique())
    names.update(df.defender_king.unique())
    for x in df.attacker_commander.unique():
        names.update(x.split(", "))
    for x in df.defender_commander.unique():
        names.update(x.split(", "))
    if 'null' in names:
        names.remove('null')
    for name in names:
        name = parse(name)
        cursor.execute("Insert Into Warrior (WarriorName) values ('%s')"% name)
    return list(names)


def load_clans(df,cursor):
    print("Loading clans")
    clans = set()
    for x in ['attacker','defender']:
        for i in range(1,5):
            clans.update(df['%s_%s'%(x,str(i))].unique())
    if 'null' in clans:
        clans.remove('null')
    for clan in clans:
        clan = parse(clan)
        cursor.execute("Insert Into Clan (ClanName) values ('%s')"% clan)
    return list(clans)

def load_regions(df,cursor):
    print("Loading regions")
    regions = set(df.region.unique())
##    if 'null' in regions:
##        regions.remove('null')
    for region in regions:
        region = parse(region)
        cursor.execute("Insert Into Region (RegionName) values ('%s')"% region)
    return list(regions)

def load_battletype(df,cursor):
    print("Loading battletypes")
    battletypes = set(df.battle_type.unique())
    if 'null' in battletypes:
        battletypes.remove('null')
    for battletype in battletypes:
        battletype = parse(battletype)
        cursor.execute("Insert Into BattleType (battletype) values ('%s')"% battletype)
    return list(battletypes)

def load_locations(df, cursor, regions):
    print("Loading locations")
    df.drop_duplicates()
    locations=[]
    for index, row in df.iterrows():
        loc = [row['location'],row['region']]
        locations.append(loc)
        name = parse(loc[0])
        regionId = regions.index(loc[1])+1
        if name == 'null':
            name = None
        cursor.execute("Insert Into Location (RegionId,LocationName) values (%s,%s)",(regionId,name))
    return locations
    
def returnNone(_):
    if type(_) == str:
        return parse(_) if _!='null' else None    
    return _ if _!='null' else None
    
def returnNoneCache(x,y):
    return (x.index(y)+1) if y!='null' else None
def load_commanders_clans(row,cache,index):
    params = []
    params.append(index+1)
    for i in range(1,5):
        params = []
        params.append(index+1)
        params.append(returnNoneCache(cache['clans'],row['attacker_%s'%str(i)]))
        params.append(1)
        if(params[1]!= None):
            cursor.execute("Insert Into SideClans (BattleId,ClanId,SideId) values (%s,%s,%s)",tuple(params))
        params[1] = returnNoneCache(cache['clans'],row['defender_%s'%str(i)])
        params[2] = 2
        if(params[1]!= None):
            cursor.execute("Insert Into SideClans (BattleId,ClanId,SideId) values (%s,%s,%s)",tuple(params))
    
    for x in row['attacker_commander'].split(', '):
        params = []
        params.append(index+1)
        params.append(returnNoneCache(cache['warriors'],x))
        params.append(1)
        if(params[1]!= None):
            cursor.execute("Insert Into Commanders (BattleId,WarriorId,SideId) values (%s,%s,%s)",tuple(params))
    for x in row['defender_commander'].split(', '):
        params = []
        params.append(index+1)
        params.append(returnNoneCache(cache['warriors'],x))
        params.append(2)
        if(params[1]!= None):
            cursor.execute("Insert Into Commanders (BattleId,WarriorId,SideId) values (%s,%s,%s)",tuple(params))
        
    

def load_battles(df,cache):
    print("Loading rest of the table")
    for index, row in df.iterrows():
        params =[]
        params.append(returnNoneCache(cache['battletypes'],row['battle_type']))
        params.append(returnNone(row['year']))
        params.append(returnNone(row['name']))
        params.append(returnNoneCache(cache['warriors'],row['attacker_king']))
        params.append(returnNoneCache(cache['warriors'],row['defender_king']))
        params.append(returnNone(row['attacker_size']))
        params.append(returnNone(row['defender_size']))
        params.append(True if returnNone(row['attacker_outcome'])=='win' else False if returnNone(row['attacker_outcome'])=='loss' else None)
        params.append(returnNone(row['major_death']))
        params.append(returnNone(row['major_capture']))
        params.append(returnNoneCache(cache['locations'],[row['location'],row['region']]))
        params.append(returnNone(row['note']))
        params.append(returnNone(row['summer']))
        cursor.execute("Insert Into Battle (BattleTypeId,BattleYear,BattleName,AttackerKingId,DefenderKingId,AttackerSize,DefenderSize,AttackerWin,MajorDeath,MajorCapture,LocationId,Note,Summer) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)",tuple(params))
        load_commanders_clans(row,cache,index)

try:
    
##    warriors = load_warriors(all_data,cursor)
##    clans = load_clans(all_data,cursor)
##    regions = load_regions(all_data,cursor)
##    battletypes = load_battletype(all_data,cursor)
##    locations = load_locations(all_data[['location','region']],cursor,regions)


    cache = {
            'warriors' : load_warriors(all_data,cursor),
            'clans' : load_clans(all_data,cursor),
            'regions': load_regions(all_data,cursor),
            'battletypes':load_battletype(all_data,cursor)}
    
    cache['locations'] = load_locations(all_data[['location','region']],cursor,cache['regions'])
    load_battles(all_data,cache)
        
    print("Success.... Data being committed")
    cursor.close()
    mydb.commit()
    mydb.close()

except Exception as e:
    print("Error.... Rolling Back Data :(")
    cursor.close()
    mydb.rollback()
    mydb.close()
    traceback.print_exc()
    print(e)

