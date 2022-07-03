# tp-integrador-link
Indicaciones generales:
-No se encuentra subido a heroku, por lo que no es necesario configurar variables de entorno (se cargan desde application.properties)
-Cuando se crea la db, gracias al archivo InitData inicializo algunos objetos que seran persistidos, tales como Personas,Vendedores, Cliente. Como comentario de
este item, me gustaria desctacar que cada cliente posee un carrito de compra y este se vacia al confirmarlo, gestionando previo una orden con la informacion a 
descatar del mismo (items, descuentos, etc).



Generales API:
-Gracias a la implementacion de repositorios que responden a consultas api tambien del tipo PagingAndSortingRepository, se logra poder crear modificar y
eliminar los elementos del dominio, siendo esto un posible futuro refactor en cuestiones de seguridad.
-Para cuestiones particulares, se crearon algunos controllerComplements. Estos creo que son el mayor punto, ya que son una gran mayoria los que se utilizan en el front, por lo que desarrollare los mismos:
    vendedorComplement:
    -/vendedor/{vendedorID}/productos: Al realizar un post, enviando en el body un producto y como proveedor el id del proveedor del mismo, se crea un          producto, se le asocia al proveedor correspondiente y se le agrega a los productos del vendedor.
    loginComplement:
    -/login: enviando un parametros en el body un usuario y una contraseña, devuelve el id del rol que lo representa y un string que expresa que tipo de rol     es, para facilitar el front.
    ordenesComplement:
    -/orden//{cliente}: al enviar este post, el front confirma la finalizacion del proceso del carrito para gestionar la orden.
    carritoComplenet:
    -/carrito: al enviar un get, se devuelve el carrito que tiene el cliente.
    -/carrito/{cliente}/{metodoPago}: Post. ademas de verificar el cliente, le setea un medio de pago a su carrito.
    -/{cliente}/carritoDeCompras/descuentos/{id}: Post. Tiene como funcionalidad agregarle una promo a un carrito.
    -/{cliente}/carritoDeCompras/items/{producto}/{cantidad}: Enviando un post, se agrega un determinado item (producto, cantidad y precio del item) al             carrito del cliente.
    
Ejemplos API consumidos via postman, cabe aclarar que son meramente de exposicion, ya que puede que al iniciar la aplicacion no necesariamente
se tengan los mismos id (No es un instructuvo de request a realizar como iniciales):
-crear cliente, utilizando post:
http://localhost:8080/clientes con body:

{
        "nombre":"abby",
        "dni":"1"
}
-crear carrito, utilizando post:
http://localhost:8080/carritos con body:
{
    "cliente":"http://localhost:8080/clientes/7dc7a6d9-07da-4bdc-92df-eb03bf0669f6",
    "items":["http://localhost:8080/itemsOrdenes/10"],
    "medioPago":"EFECTIVO",
    "promociones":[]
}
-crear producto, utilziando post:
http://localhost:8080/vendedor/ed8c7b3f-673f-4663-aec8-240c08a9bdca/productos con body:
{
    "id_proveedor":2,
    "nombre":"heladeraA",
   "descripcion":"marca x",
   "precio":5.0,
   "stock":50,
   "foto":"https://m.media-amazon.com/images/I/71Ysqd7TTZL._AC_UX342_.jpg",
   "esPesos":true
} 
-crear item con post:
http://localhost:8080/itemsOrdenes con body:
{
    "cantidad":2,
    "producto":"http://localhost:8080/productos/3"
}



Ejecucion:
-Backend: Simplemente se debe correr el archivo java GestionAplication.java. Previo a esto se debe crear una bd llamada tp-integrador-db. El usuario utilzado,
como lo indica el archivo de propiedades, es root, no contando con contraseña alguna.
-Frontend: Debido al peso de las librerias que se descargan al configurar el proyecto angular, se encuentra en repositorio la carpeta src. Para ejecutarlo, se
debera crear un proyecto angular para luego remplazar la carpeta src por la publicada para luego utilizar el comando "ng serve".
