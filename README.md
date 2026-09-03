### Trabajo en parejas Evaluativo
Trabajo de clases en parejas evaluativo, presentado por: Juan Sebastian, albeiro

### Seguridad (De parte de Juan Sebastian)
La API esta protegida utilizando Spring Security con autenticacion basica.
Para utilizar cualquier Endpoint, se debe enviar las siguientes credenciales

*Usuario : admin
*Contrasena : admin123

### Consultas personalizadas (Tambien por juan Sebastian)
Se agregaron 2 nuevos Endpoint utilizando Spring Data JPA para poder buscar específicamente algunos productos.

**Busqueda por Categoria**
*Metodo: "Get"
*Ruta: "/api/products/category/{category}"
*Descripcion: "Esta retorna una lista de prodductos que pertenecen exactamente a la categoria especificada."

**Busqueda por Nombre**
*Metodo: "Get"
*Ruta: "/api/products/search?name={Texto}"
*Descripcion: "Esta retorna una lista de productos que contengan el texto que se especifica."
