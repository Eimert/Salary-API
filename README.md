# Salary-API
[![Build Status][1]][2]<br>
Personal project to learn Java and Spring Boot. Displays open data of the City of Chicago. Dataset with Employee Names, Salaries and Position Title. Data from May 2017.<br>


## Setup
- `git clone` this repo. 
- Import the project into your favourite IDE. 
- Build and run the project. 

Spring will launch the web app and starts listening on port 8484. Visit [localhost:8484](http://localhost:8484) to open the app :). 

## Technology
Java 8<br>
Spring Boot<br>
Spring Dependency Injection<br>
SQLite<br>
Spring Web<br>
Spring Data JPA<br>
Swagger UI 2 (future)<br>

## Data source
[data source](https://data.cityofchicago.org/Administration-Finance/Current-Employee-Names-Salaries-and-Position-Title/xzkq-xp2w)<br>

## SQLite db

```
eimert@EIM salary-api $ sqlite3 salaries.db
SQLite version 3.11.0 2016-02-15 17:29:24
Enter ".help" for usage hints.
sqlite> .table
salaries
sqlite> select * from salaries LIMIT 1;
Name|Position Title|Department|Employee Annual Salary
sqlite> PRAGMA table_info (salaries);
0           name                    0                       0
1           position                0                       0
2           department              0                       0
3           salary                  0                       0
sqlite> select rowid,* from salaries limit 0,3;
rowid       name             position          department   salary
----------  ---------------  ----------------  -----------  ----------
1           AARON,  ELVIA J  WATER RATE TAKER  WATER MGMNT  88968.0
2           AARON,  JEFFERY  POLICE OFFICER    POLICE       80778.0
3           AARON,  KARINA   POLICE OFFICER    POLICE       80778.0

.quit
```
db restore: `sqlite3 salaries.db < salaries.sql`<br>
last added record: `sqlite3 salaries.db 'select max(id),* from salaries'`

[1]: https://travis-ci.org/Eimert/Salary-API.svg?branch=master
[2]: http://www.travis-ci.org/Eimert/Salary-API