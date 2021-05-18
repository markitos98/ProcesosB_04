# ProcesosB_04
Compilar el proyecto:

mvn compile

Crear las tablas en la BBDD

mvn datanucleus:schema-create

Ejecutar los testes

mvn test

Ejecutar SOLO tests unitarios

mvn test -DargLine="-Dcontiperf.active=false"

Informe de Cobertura Jacoco

mvn jacoco:report

Introducir datos en la BBDD

mvn exec:java -Pdatos

Ejecutar test integracion

mvn verify -Pintegration

Pasos para arrancar el programa ***

Abrir un cmd
1. En la ruta del proyecto llamar al rmi -> start rmiregistry -J-Djava.rmi.server.useCodebaseOnly=false

2. Una vez arrancado -> mvn exec:java -Pserver

Abrir otro cmd

3 En la ruta de el proyecto -> mvn exec:java -Pcontroller




