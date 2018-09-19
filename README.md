README
________

1. create a local mysql database called 'entity_test'
2. load the file in the zip into this database 'entity_test_db.sql' which will give you the schema 
3. change the mysql username and password in entity-test's application.yml
4. cd into entity-test and run 'gradle bootRun'

Just hit http://localhost:8089/entity-test/entityTest/setUp , it will fail in less than 10 hits (typically 1 in 3)

JAVA 1.8.0_144
GRAILS 3.3.8
MYSQL ver 5.7.20