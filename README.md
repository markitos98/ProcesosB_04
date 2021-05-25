# ProcesosB_04


Base de datos:
--------------

Crear un esquema llamado cinedb :

CREATE SCHEMA `cinedb` ; 

CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON cinedb.* TO 'spq'@'localhost';


Limpiar el proyecto:
-------------------
mvn clean

Compilar el proyecto:
---------------------
mvn compile

Procesado de las clases de datos:
--------------------------------
mvn datanucleus:enhance


Crear las tablas en la BBDD:
-----------------------------
mvn datanucleus:schema-create

Ejecutar los testes
-------------------
mvn test

Ejecutar SOLO tests unitarios:
------------------------------
mvn test -DargLine="-Dcontiperf.active=false"

Informe de Cobertura Jacoco:
----------------------------
mvn jacoco:report

Introducir datos en la BBDD:
-----------------------------
mvn exec:java -Pdatos

Ejecutar test integracion:
--------------------------
mvn verify -Pintegration

-----------------------------------
Pasos para arrancar el programa ***
-----------------------------------


*Abrir un cmd*

1. En la ruta del proyecto llamar al rmi
-----------------------------------------

start rmiregistry -J-Djava.rmi.server.useCodebaseOnly=false

2. Una vez arrancado
---------------------
mvn exec:java -Pserver

*Abrir otro cmd*

3.En la ruta de el proyecto
----------------------------
mvn exec:java -Pcontroller




