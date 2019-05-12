# Salary-API :heavy_dollar_sign: [![Build Status][1]][2]
Personal project to learn Java and Spring Boot. Displays [open data from the City of Chicago](https://data.cityofchicago.org/Administration-Finance/Current-Employee-Names-Salaries-and-Position-Title/xzkq-xp2w). Data set with employee name, position title, department and salary. Data from May 2017.<br>
<img src="http://www.codecheese.com/wp-content/uploads/heroku-logo.png" height=95 align="right"><br>
Open [Salary-API on Heroku](https://salaryapi.herokuapp.com/). Warning: can be slow when dyno is sleeping.<br>

## Demo accounts
Username: admin<br> 
password: admin<br>
role: ADMIN<br>
[View SecurityConfiguration.java](./src/main/java/nl/eimertvink/configuration/SecurityConfiguration.java) for more details. In-memory auth, DB auth. could be enabled too.<br>

## Usage

Discover and try-out the available REST endpoints using [Swagger-UI](https://salaryapi.herokuapp.com/). Or use [Postman](https://www.getpostman.com/) to fabricate requests.

### Machine 2 Machine usage example

Using basic authentication. Optionally pipe output to jq for human-friendly output: `curl ... | jq '.'`.<br>

Get one employee (by id):
```bash
curl https://admin:admin@salaryapi.herokuapp.com/api/employees/4
```

Get a pageable, sizable and sortable  employee list:
```bash
curl https://admin:admin@salaryapi.herokuapp.com/api/employees/
```

Show all employees with name LIKE %John%:
```bash
curl https://admin:admin@salaryapi.herokuapp.com/api/employees/search/findByNameLikeIgnoreCase?name=%25john%25
```

Add an employee:
```bash
curl -X POST -H "Content-Type: application/json" --data '{ "name": "SMITH,  MARTHA W", "position": "LIBRARY ASSOCIATE", "department": "PUBLIC LIBRARY", "email": "martha.smit@cityofchicago.org", "salary": 24835.2 }' https://admin:admin@salaryapi.herokuapp.com/api/employees
```

## Technology :wrench:
Java; OpenJDK 11<br>
Spring Boot<br>
Spring Web<br>
Spring MVC<br>
Spring Dependency Injection<br>
Spring Data REST<br>
Swagger-UI 2<br>
SQLite3<br>
Liquibase<br>

## Development Setup
[localhost:8080](http://localhost:8484/swagger-ui.html)<br>
IntelliJ (with Lombok plugin)<br>
Postman<br>

## Cloud services :cloud:
[GitHub](https://github.com/Eimert/Salary-API) :octocat:<br>
[Travis-CI](https://www.travis-ci.org/Eimert/Salary-API)<br>
[Heroku](https://salaryapi.herokuapp.com).<br>
[uptimerobot.com](https://uptimerobot.com/) uptime monitoring; polling every 5 minutes.<br> 

## Data Set :open_file_folder:
![alt text](https://raw.githubusercontent.com/Eimert/Salary-API/master/src/main/resources/images/City-of-Chicago-Current-Employee-Names-Salaries-and-Position-Titles.png "City of Chicago")<br>
:link: [Data source](https://data.cityofchicago.org/Administration-Finance/Current-Employee-Names-Salaries-and-Position-Title/xzkq-xp2w).

## SQLite database :floppy_disk:

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
Database reset: `sqlite3 salaries.db < salaries.sql`<br>
Last insert: `sqlite3 salaries.db 'select max(id),* from salaries'`

## References :books:

[1]: https://travis-ci.org/Eimert/Salary-API.svg?branch=master
[2]: http://www.travis-ci.org/Eimert/Salary-API
[3]: API Authentication steps are described at [Baeldung](https://www.baeldung.com/securing-a-restful-web-service-with-spring-security#ch_3_7)<br>
[4]: Spring cloud deployment [docs](https://docs.spring.io/spring-boot/docs/current/reference/html/cloud-deployment.html)<br>