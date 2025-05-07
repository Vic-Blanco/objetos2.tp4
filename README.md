Ejercicio 1

Alguien, que no es Usted, implementó el siguiente programa. El mismo tiene mezclado diferentes funciones: código de UI (JFrame, JTextField, JButton, etc), código de base de datos (Connection, PreparedStatatement, etc) y código de modelo de dominio (Participante y sus reglas de validación). Esto es un ejemplo simple, pero en aplicaciones grandes diseñar de esta forma genera varios problemas: código complicado, cualquier cambio afecta a todo el sistema, nada se puede reutilizar, muy difícil de testear.
Se pide:
Refactorice el código para implementar diseño en capas (invirtiendo la dependencias hacia model). Comience de a poco y pruebe manualmente luego de cada cambio. 

Ejercicio 2

Escriba un programa que cargue un conjunto de empleados de un archivo de texto y envíe por email un saludo de feliz cumpleaños a quienes cumplan años hoy.

El archivo de empleados tiene la siguiente estructura: 
apellido, nombre, fecha de nacimiento, email
Young, Angus, 1982/10/08, angus@acdc.com 
Johnson, Brian, 1975/09/11, brian@acdc.com

Se requiere:
● Implemente utilizando diseño en capas (invirtiendo la dependencias hacia
model).
● Se deben incluir test de unidad del modelo (la cantidad que el alumno considere
necesario), verificar cobertura (superior a 60%).
● Para el envío de email utilizaremos el servicio provisto por MailTrap
(https://mailtrap.io/). 

Ejercicio 3 

El programa que se encuentra en la siguiente hoja está incompleto, falta implementar los métodos que están resaltados en amarillo. Pero además, tiene mezclado en una única clase y único paquete, cuestiones de UI, lógica de negocios y acceso a datos.
Se requiere:
● Modifique y termine de implementar utilizando diseño en capas (invirtiendo la dependencias hacia model).
● Implemente los métodos faltantes:
    ○ todosLosConcursos(): Recupera del archivo concursos.txt los concursos si
    su inscripción se encuentra abierta. Y los muestra en el Combo.
    ○ saveInscription(): Graba las personas que se inscriben en el archivo
    inscriptos.txt según el formato definido.
• Implemente los métodos pero ahora leyendo y escribiendo en una base de datos relacional. Diseñe Usted la/s tabla/s de concursos e inscriptos.

El archivo inscriptos.txt debe quedar así:
apellido, nombre, teléfono, email, idconcurso
Young, Angus, 4444-898789, angus@acdc.com, 1
Johnson, Brian, 7789-658987, brian@acdc.com, 2

El archivo concursos.txt tiene la siguiente estructura:
idconcurso, nombre, fechaInicioInscripcion, fechaFinInscripcion
1, concurso x, 2020/06/01, 2020/07/01 
