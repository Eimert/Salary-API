# Salary-API :heavy_dollar_sign: 
[![Build Status][1]][2] 
[![Heroku][3]][4]
<br>
Personal project to learn Java and Spring Boot. Displays [open data from the City of Chicago](https://data.cityofchicago.org/Administration-Finance/Current-Employee-Names-Salaries-and-Position-Title/xzkq-xp2w). Data set from May 2017 with:
- employee name,
- position,
- department,
- and salary.

Open [Salary-API on Heroku](https://salaryapi.herokuapp.com/). Warning: the site could be slow or offline when free dyno hours have elapsed.<br>

## Swagger-UI API endpoint discovery

Discover and try-out the available REST endpoints using [Swagger-UI](https://salaryapi.herokuapp.com/). Alternatively use [Postman](https://www.getpostman.com/) to send requests.

### Curl usage example

Optionally pipe output to jq for human-friendly output: `curl ... | jq '.'`.<br>

Get a pageable employee list:
```bash
curl -X GET https://salaryapi.herokuapp.com/api/salaries
curl -X GET http://localhost:8080/api/salaries
```

## Technology :wrench:
Java 11<br>
Spring<br>
Spring Boot<br>
Spring Web<br>
Spring JPA<br>
Spring Data REST<br>
Swagger-UI (OpenAPI v3)<br>
~~SQLite3~~<br>
H2<br>
Liquibase<br>
Hibernate<br>

## Development Setup
[localhost:8080](http://localhost:8080/)<br>
[h2-console](http://localhost:8080/h2-console/)<br>
IntelliJ (with Lombok plugin)<br>
Postman<br>

## Cloud services :cloud:
[GitHub](https://github.com/Eimert/Salary-API) :octocat:<br>
[Travis-CI](https://www.travis-ci.org/Eimert/Salary-API)<br>
[Heroku](https://salaryapi.herokuapp.com)<br>
[uptimerobot.com](https://uptimerobot.com/) uptime monitoring; polling every 5 minutes.<br> 

## Data Set :open_file_folder:
![alt text](https://raw.githubusercontent.com/Eimert/Salary-API/master/src/main/resources/images/City-of-Chicago-Current-Employee-Names-Salaries-and-Position-Titles.png "City of Chicago")<br>
:link: [Data source](https://data.cityofchicago.org/Administration-Finance/Current-Employee-Names-Salaries-and-Position-Title/xzkq-xp2w).

## References :books:
- API Authentication steps are described at [Baeldung](https://www.baeldung.com/securing-a-restful-web-service-with-spring-security#ch_3_7)<br>
- Spring cloud deployment [docs](https://docs.spring.io/spring-boot/docs/current/reference/html/cloud-deployment.html)<br>

[1]: https://travis-ci.org/Eimert/Salary-API.svg?branch=master
[2]: https://www.travis-ci.org/Eimert/Salary-API
[3]: https://heroku-badge.herokuapp.com/?app=salary-api
[4]: https://salaryapi.herokuapp.com/
