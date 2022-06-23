# La Paleta.
Proyecto escolar creado con JAVA y MARIADB como base de datos.

## Pasos para ejecutar.
1. Agregar a la carpeta "Libraries" el conector a la base de datos 
   (mysql-connector...).
2. Ejecutar el archivo SCRIPT.SQL para crear la base de datos.
3. Ejecutar el archivo Login.java dentro de la carpeta "views".
4. Disfrute del proyecto!!!

## ¿Qué puede hacer?
Iniciar sesión y realizar el CRUD básico de productos. Es decir agregar, buscar, 
editar y eliminar. Donde la búsqueda es realizada con base el nombre, alias, clave 
y categoría del producto.

### ¿Cómo inicio sesión?
Solo ingrese el usuario y contraseña. El usuario es "saakve" y la contraseña
"1234". 

### ¿Cómo buco un producto?
Para ello cuenta con 2 barras de búsqueda.

La primera realiza la búsqueda con base al texto ingresado y arroja productos cuyos 
nombres, alias o clave coincide con el texto ingresado.

La segunda forma se realiza con base a la categoria seleccionada en la lista 
desplegable. Es decir arroja productos donde su categoria es igual a la elegida. 

### ¿Cómo agrego un producto?
Seleccione el icono de más que se encuentra en la esquina inferior izquierda.

### ¿Cómo elimino y edito?
Seleccione cualquier fila de la tabla donde se encuentre el producto que desea
editar o eliminar. De ahí se mostrará una ventana emergente donde podrá cambiar
los datos del producto seleccionado. O eliminar dicho producto.