# SistemaPOO
Primera vez corriendo el programa:
El empleado no puede generar una venta si no existen productos en el inventario
previamente comprados a los proveedores por el encargado
Inicio de Programa:
Presupuesto inicial de la tienda: $10,000.00
Al correr el programa, este iniciara preguntando por tu número de usuario. Los usuarios
estarán previamente registrados
Lo que imprime el programa:
Inicio de sesión
Ingresa tu ID de personal o Encargado
Los usuarios correspondientes son:
Cuentas de personal:

*Trabajador 1 Juan Daniel Hernandez
	o ID: 1234
	o Contraseña: halo1429

*Trabajador 2 Victor De La Cruz
	o ID: 2345
	o Contraseña: hugo22

Cuenta de Encargado:
*Encargado Saul Torres De La O
	o ID: 3456
	o Contraseña: sdelao


Dependiendo del usuario con el que ingresemos se ejecutaran diferentes
acciones. Si el usuario introduce valores erróneos el programa mostrará una excepción
y se cerrara.Ingresando como Encargado:
Accediste correctamente en una cuenta de Encargado
Bienvenido “Nombre de Encargado” 
Se desplegara un menú con 5 opciones:
************************************************
1) Compra a proveedor
2) Aumentar presupuesto de la tienda
3) Mostar ventas
4) Configuración de Usuario
5) SALIR
************************************************
Opción 1 Compra a proveedor Menú Encargado
Se despliega un nuevo menú
Opción 1) Registrar compra a proveedor
Nos preguntará cuantos diferentes productos vamos a surtir y el código del producto en
específico que se va a surtir
El programa realizara una suma del precio de los productos. Este será restado del
presupuesto de la tienda. Si el presupuesto es suficiente se añadirán correctamente los
productos al inventario
Al realizar la siguiente acción se nos mostrará el presupuesto restante

Opción 2) Regresar
Regresa al menú de GerenteOpción 2 Aumentar Presupuesto de la tienda Menú Encargado
Cuando el presupuesto es insuficiente para realizar la compra al proveedor y
añadir productos al inventario, se le pide dinero al tesorero para realizar la compra
Este
manda
$100,000.00
que serán agregados al presupuesto de tienda.Permitiéndonos comprar más producto para el inventario.


Opción 3 Mostrar Ventas Menú Encargado
Nos mostrara los tickets de las ventas realizadas y nos regresara al menú de
encargado

Opción 4 Configuración de usuario Menú Encargado
En este apartado nos desplegara un menú preguntando si queremos editar algún
dato relacionado con el encargado
Nos preguntara que queremos editar si el nombre, contraseña, dirección, teléfono,
fecha de contratación, antigüedad, el departamento o si queremos regresar
Si editamos algo nos pedirá el nuevo valor y nos regresara al menú de editar
información

Opción 5 Salir Menú Encargado
Termina el programa
Ingresando como Trabajador:
Accediste correctamente en una cuenta de personal
Bienvenido “Nombre de Empleado” 
Posteriormente se desplegara un menú, dándonos 3 opciones:
************************************************
1) ventas
2) usuario
3) SALIR.
************************************************
Opción 1 Ventas Menú Personal
Dentro de este se nos mostrara nuevamente un menú. Teniendo como opciones.
Opción 1) Registrar venta
El programa nos pedirá cuantos productos se están comprando y el código de estos.
Nos informara que hay productos disponibles y nos dará el precio total.
* Si no se ha agregado productos como encargado en esta parte nos marcara un error
Se nos preguntara si se quiere hacer algún cambio en lo previamente escogido.
De ser así se tendrán que ingresar los productos por su código nuevamente. Solo nos
dejara cambiar los productos comprados no cuantos estamos comprando
Ingresamos la cantidad con la que pago el cliente
Se genera el TicketDigital de la compra con el siguiente formato
* Hora de la compra
* Fecha
* El código y precio de los productos comprados
* El numero de venta
* Cuanto de IVA se cobro
* El precio total
* La cantidad con la que pago el cliente
* El cambio de la compra
* El Mensaje “Gracias por su compra 

Al finalizar nos devolverá al menú de ventas por si se va a registrar otra ventaOpción 2) Regresar
El programa regresa al menú de personal
Si se registró una venta nos imprimirá el mensaje “Almacenando Venta...”
Opción 2 Usuario Menú personal
Opción 1) Editar Informacion
Nos preguntara que queremos editar si el nombre, contraseña, dirección, teléfono,
fecha de contratación, antigüedad, el departamento o si queremos regresar
Si editamos algo nos pedirá el nuevo valor y nos regresara al menú de editar
información
Opción 2) Ver información
Se desplegara la información del usuario con el siguiente formato:

- Nombre
- ID
- Direccióno calle y numero o colonia o ciudad o código postal
- Contacto del usuario
- Teléfono y Correo Electrónico
- Informacion su contratación o Fecha de contratación o Antigüedado Departamento o Sueldo

Opción 3) Regresar
Opción 3 SALIR Menú Personal
Termina el programa

-----------------------------
NOTA: Cambiar todas las rutas para que el codigo funcione.
El proyecto fue desarrollado para la materia de POO del profe Saul De la O
