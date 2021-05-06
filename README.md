# ProcesosB_04
Compilar el proyecto:

mvn compile

Crear las tablas en la BBDD

mvn datanucleus:schema-create

Ejecutar los testes

mvn test

Introducir datos en la BBDD

mvn exec:java -Pcliente
