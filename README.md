# Salary-API

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
SQLite db<br>
Spring REST API (future)<br>

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
.quit
```