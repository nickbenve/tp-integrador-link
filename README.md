# tp-integrador-link
Indicaciones generales:
-No se encuentra subido a heroku, por lo que no es necesario configurar variables de entorno (se cargan desde application.properties)
-Cuando se crea la db, gracias al archivo InitData inicializo algunos objetos que seran persistidos, tales como Personas,Vendedores, Cliente. Como comentario de
este item, me gustaria desctacar que cada cliente posee un carrito de compra y este se vacia al confirmarlo, gestionando previo una orden con la informacion a 
descatar del mismo (items, descuentos, etc).



Generales API:
-Gracias a la implementacion de repositorios que responden a consultas api tambien del tipo PagingAndSortingRepository, se logra poder crear modificar y
eliminar los elementos del dominio, siendo esto un posible futuro refactor en cuestiones de seguridad.
-Para cuestiones particulares, se crearon algunos controllerComplements. Estos creo que son el mayor punto, ya que son una gran mayoria los que se utilizan en 
el front, por lo que desarrollare los mismos.
    vendedorComplement:
    -/vendedor/{vendedorID}/productos: verificando que exista el id del vendedor, esta url devuelve los productos que dispone un vendedor.
    -



Ejecucion:
-Backend: Simplemente se debe correr el archivo java GestionAplication.java. Previo a esto se debe crear una bd llamada tp-integrador-db. El usuario utilzado,
como lo indica el archivo de propiedades, es root, no contando con contraseña alguna.
-Frontend: Debido al peso de las librerias que se descargan al configurar el proyecto angular, se encuentra en repositorio la carpeta src. Para ejecutarlo, se
debera crear un proyecto angular para luego remplazar la carpeta src por la publicada para luego utilizar el comando "ng serve".
