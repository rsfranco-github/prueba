# Prueba Raul Franco
Prueba de lider tecnico a continuacion se explica el uso de la app.

La aplicacion se contruyo con framework java sprintboot version 2.6.5

La estructura del proyecto esta sobre IDE IntellIJ

La coleccion de postman se puede importar del siguiente link:

https://www.getpostman.com/collections/0414ac33e1612e3499a7

Alli podran encontrar los metodos con sus test case.

La aplicacion consta de 3 metodos en total. 1 metodo GET y 2 Metodos POST.

Para ejecutar la pruebas desde la coleccion de postman se debera ejecutar en el siguiente orden los metodos:

Metodo GET getEnvironment : De alli tomaremos el campo del response llamado 'environment' el cual sera la entrada para los siguientes metodos poder identificar a cual ambiente aplicara la ajecucion.

Metodo POST addCommand: con el valor del 'environment' y un valor para el campo 'number' se podra ir llenando una pila de numeros para luego poder aplicar la ajecucion de una operacion

Metodo POST runCalculator: ultimo metodo el cual tendra pre-condiciones para su ejecucion, se le debera enviar el 'environment' y un valor para el campo 'operator' para saber que operacion se ejecuta a los 2 ultimos numeros ingresados

 Los ejemplos de ejecucion por medio de CURL bajo ambiente linux son:

curl -H 'Content-Type: application/json' -X GET http://localhost:8080/api/v1/calculator/getEnvironment

curl -H 'Content-Type: application/json' -X POST -d '{"operator":"ADD","environment":"1648592638036-38ccd45a-b557-401f-bcb7-bc767227ea92"}' http://localhost:8080/api/v1/calculator/addCommand

curl -H 'Content-Type: application/json' -X POST -d '{"number":"2","environment":"1648592638036-38ccd45a-b557-401f-bcb7-bc767227ea92"}' http://localhost:8080/api/v1/calculator/runCalculator
