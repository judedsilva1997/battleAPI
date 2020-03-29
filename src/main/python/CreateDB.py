import mysql.connector
import os

mydb = mysql.connector.connect(
  host="localhost",
  user=os.getenv('python.datasource.username', "user"),
  passwd= os.getenv('python.datasource.password', "password")
)
print("Creating database")
cursor = mydb.cursor()
cursor.execute("CREATE database battles")
cursor.close()
mydb.commit()
mydb.close()
print("Success")
