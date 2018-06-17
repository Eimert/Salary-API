# Salary-API :heavy_dollar_sign:
[![Build Status][1]][2]<br>
Personal project to learn Java and Spring Boot. Displays open data of the City of Chicago. Data set with employee name, position title, department and salary. Data from May 2017.<br>
<img src="http://www.codecheese.com/wp-content/uploads/heroku-logo.png" height=95 align="right"><br>
Open [Salary-API on Heroku](https://salaryapi.herokuapp.com/). Warning: can be slow when dyno is sleeping.<br>

## Demo accounts
Username: john  password: sonmez    role: user<br>
Username: admin password: admin     role: admin<br>
Discover other methods using [Postman](https://www.getpostman.com/).<br>

## Technology :wrench:
Java 8<br>
Spring Boot<br>
Spring Web<br>
Spring MVC<br>
Spring Dependency Injection<br>
Spring Data REST<br>
Swagger UI 2 (future)<br>
Angular (future)<br>
SQLite<br>

## Data Set :open_file_folder:
![alt text](https://raw.githubusercontent.com/Eimert/Salary-API/master/src/main/resources/images/City-of-Chicago-Current-Employee-Names-Salaries-and-Position-Titles.png "City of Chicago")<br>
:link: [Data source](https://data.cityofchicago.org/Administration-Finance/Current-Employee-Names-Salaries-and-Position-Title/xzkq-xp2w).

## SQLite

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
sqlite> select id,* from salaries limit 0,3;
id          name             position          department   salary
----------  ---------------  ----------------  -----------  ----------
1           AARON,  ELVIA J  WATER RATE TAKER  WATER MGMNT  88968.0
2           AARON,  JEFFERY  POLICE OFFICER    POLICE       80778.0
3           AARON,  KARINA   POLICE OFFICER    POLICE       80778.0

.quit
```
Database restore: `sqlite3 salaries.db < salaries.sql`<br>
Last insert: `sqlite3 salaries.db 'select max(id),* from salaries'`

[1]: https://travis-ci.org/Eimert/Salary-API.svg?branch=master
[2]: http://www.travis-ci.org/Eimert/Salary-API