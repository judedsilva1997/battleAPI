# BattleAPI
An Spring Boot API to fetch GoT battles.

# Requirements

 1. Python >= v3.6
 2. Java >= v1.8
 3. MySQL server

# Build

 1. Clone the repository
 2. Setup a MySQL server
 3. Navigate to `src/main/python`
 4. Install the necessary python packages: `pip install -r requirements.txt`
 5. Set up db environment variables for python file:

>python.datasource.username=<username>

>python.datasource.password=<password>

 6. Run the CreateDB script
>   python CreateDB.py
 7. Build boot app `gradlew bootJar`
 8. Set db environment variables for Boot app:

>spring.datasource.username=user

>spring.datasource.password=password

 10. Execute the jar file
 11. Run the dataLoader script:

> python DataLoader.py
> 
> 
> 

## API End Points

|Endpoint | Method  | Usage|
|--|--|--|
| `/battleapi/battle/{id}` |GET  |Get the battle for a given battle `'id' `
|`/battleapi/list`| GET|List all regions and locations|
| `/battleapi/count`| GET | Count of all the battles| 


## Specific Error Codes

|Error Code| Meaning |
|--|--|
|`404`|Battle/ Endpint not found
