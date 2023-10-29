# Resolucion del certamen II - Taller de Nuevas Tecnologias
**Se requiere una app que permita guardar los movimientos bancarios utilizando SharedPreferences, fecha de entrega: 30 oct, 21:00 via classroom.**

✅ Realizado.
‼️ Pendiente.
❌ Error.

## Especificaciones
- ✅ Crear clase cuenta con los atributos: rut,nombres, apellidos, saldo numSecreto.
- ✅ Constructor con y sin parametros.
- ✅ Getter y Setter.
- ✅ 4 Customers: Todos los customers devuelven *true* si realizaron la operacion con exito o throw new Exception() indicando el o los erroes asociados.
- ✅ **Girar:** Recibe como parametro el monto a girar, verifica que el monto sea positivo y saldo de la cuenta sea mayor o igual para realizar el giro, actualizando el saldo.
- ✅ **Depositar:** Recibe como parametro el monto a depositar, verifica que el monto sea positivo, actualizando el saldo.
- ‼️ **Pagar:** Recibe rut, numSecreto, monto a transferir, verifica que el rut sea el mismo de la cuenta, numSecreto sea correcto, monto a girar sea positivo y que alcance el saldo para hacer el pago y actualizar el saldo.
- ✅ **Validar:** Verifica que existan los datos correctos de los atributos de la clase.

Los datos solicitados seran obligatorios, debiendo mostrar los mensajes correspondientes utilizando los *setErrors()* en los *EditText* correspondientes y *Toast* y/o ventana emergente indicando que hay error.
Manejo de excepcion, tanto a nivel de clases como a nivel de vista.
Cada vez que abras la cuenta, debe rescatar el saldo actualizado.

## Actividad Principal para capturar datos de la cuenta
- ✅ Al crear objeto cuenta mediante un boton(todos los datos son obligatorios), el numero secreto debe ser capturado tipo password numerico, un campo para reescribir el numero secreto y validar que ambas claves sean iguales (minimo de 6 digitos)
- ‼️ Guardar los datos de inicio de sesion usando *SharedPreferences*.
- ‼️ Si los datos de entrada fueron guardados previamente, se recuperan y se muestran en los *EditText*.
- ‼️ Al validar, crear los archivos *SharedPreferences* para guardar la informacion inicial, luego crear objeto y enviarlo como parametro a la actividad de operaciones.

## Actividad Operaciones
- ✅ Recibe el objeto desde la actividad principal y le da la bienvenida mostrando el nombre y el saldo actualizado de la cuenta.
- ✅ Muestra ademas botones para girar, depositar y pagar.
- ‼️ Se guardara cada operacion utilizando *SharedPreferences* para poder obtener el historial.
- ✅ Cada boton traspasara el objeto cuenta a la actividad que le corresponda.

### Actividad Girar
Recibe el objeto, solicita el monto a girar y mediante un boton verifica que se pueda realizar la operacion invocando el metodo girar, guarda el nuevo giro utilizando *SharedPreferences* (permitira ver el historial), posteriormente se devuelve a la actividad Operaciones.
1. ✅ Boton validar giro.
2. ‼️ Boton ver historial de giros: al presionar se mostrara el historial correspondiente (utiliza ListView).
3. ✅ Boton regresar a operaciones

### Actividad Depositar
Recibe el objeto, solicita el monto a depositar y mediante un boton verifica que se pueda realizar la operacion invocando el metodo depositar, guarda el nuevo deposito utilizando *SharedPreferences* (permitira ver el historial), posteriormente se devuelve a la actividad Operaciones.
1. ✅ Boton validar deposito
2. ‼️ Boton ver historial de depositos: al presionar se mostrara el historial correspondiente (utiliza ListView).
3. ✅ Boton regresar a operaciones.

### Actividad Pagar
Recibe el objeto, solicita el monto a transferir, rut de la cuenta y el numero secreto de la cuenta para validar el pago. Mediante un boton verifica que se pueda realizar la operacion invocando el metodo pagar, guarda el nuevo deposito utilizando *SharedPreferences* (permitira ver el historial), posteriormente se devuelve a la actividad Operaciones.
1. ✅ Boton validar pago.
2. ‼️ Boton ver historial de pagos: al presionar se mostrara el historial correspondiente (utiliza ListView).
3. ✅ Boton regresar a operaciones.
