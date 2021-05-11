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

Arrancar cliente

mvn exec:java -Pclient

Ejecutar test integracion

mvn verify -Pintegration
