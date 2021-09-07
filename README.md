# Gerenciador de reuniao
## Santander bootcamp (DIO)

- Java (Gradle, Springboot, JPA Hibernate, Lombok)
	$ gradle bootRun
    
- Docker (Mysql container)

	$ docker run --rm -dit -e MYSQL_ROOT_PASSWORD=pass --name mysql 3306:3306 mysql:5.7

	$ docker exec -it mysql bash


Running Mysql outside of container:

	$ mysql -h127.0.0.1 -u root
	PASSWORD: pass
	mysql> create database gerenciador_Reuniao
	

- Angular Frontend 