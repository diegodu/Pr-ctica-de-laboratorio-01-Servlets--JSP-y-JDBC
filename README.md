# Pr-ctica-de-laboratorio-01-Servlets--JSP-y-JDBC

OBJETIVO ALCANZADO:

• Diseña y desarrolla modelos de software en diferentes niveles de abstracción y modelos de datos a
nivel transaccional y analítico con entornos de desarrollo actuales

ACTIVIDADES DESARROLLADAS

1. Crear un repositorio en GitHub con el nombre “Práctica de laboratorio 01: Servlets, JSP y
JDBC”

![image](https://user-images.githubusercontent.com/34308601/81628111-67f26280-93c5-11ea-98c8-d8fb6621244f.png)

2. Desarrollar una aplicación con tecnología JEE para gestionar una agenda telefónica en la web.
3. Realizar varios commits en la herramienta GitHub que demuestren el desarrollo de la aplicación

![image](https://user-images.githubusercontent.com/34308601/81628137-750f5180-93c5-11ea-95a4-61c0b18d17c7.png)

4. Generar el informe de la práctica con el desarrollo de cada uno de los puntos descritos
anteriormente

CREAR ARQUITECTURA MVC

![image](https://user-images.githubusercontent.com/34308601/81628155-822c4080-93c5-11ea-8a3e-65c5bbed6472.png)

PAQUETE DAO

Aquí se implemntan las clases para el modelo Dao

![image](https://user-images.githubusercontent.com/34308601/81628181-94a67a00-93c5-11ea-8ffc-c119e98e0910.png)

DaoFactory

Crear los métodos necesarios que se van a utilizar

![image](https://user-images.githubusercontent.com/34308601/81628202-9ec87880-93c5-11ea-8360-016dba85cd66.png)

GenericDao

Los métodos de los cuales se va a llamar desde los otros métodos Dao.

![image](https://user-images.githubusercontent.com/34308601/81628245-b99aed00-93c5-11ea-8701-cf36720e6c90.png)

JDBCDAOFactory

Los métodos crear tablas y los get de nuestras clases.

![image](https://user-images.githubusercontent.com/34308601/81628257-c3bceb80-93c5-11ea-8b49-5a56c3dd8324.png)

PersonaDao

Crear los métodos específicos para la clase

![image](https://user-images.githubusercontent.com/34308601/81628275-d1727100-93c5-11ea-8d2b-ccf1058cfd22.png)

TelefonoDao

Crear los métodos específicos para la clase

![image](https://user-images.githubusercontent.com/34308601/81628292-e0f1ba00-93c5-11ea-89f4-4a0f1b236cfd.png)

FLTROS

Se van a utilizar para controlar sesiones de la aplicación

![image](https://user-images.githubusercontent.com/34308601/81628302-ebac4f00-93c5-11ea-8328-b698839cd59a.png)

Agenda

Va a controlar la agenda para que no pueda ingresar si antes no esta iniciado sesión

![image](https://user-images.githubusercontent.com/34308601/81628315-f6ff7a80-93c5-11ea-9f50-1e026ebbfebd.png)

Inicio

Valida la pagina de inicio

![image](https://user-images.githubusercontent.com/34308601/81628341-0bdc0e00-93c6-11ea-916b-542ffa4f6d93.png)

Logeo

Valida si la sesión ya esta iniciada, que pueda acceder a su agenda

![image](https://user-images.githubusercontent.com/34308601/81628369-1dbdb100-93c6-11ea-9648-054fc560718c.png)

MODELO

Se crean dos clases con su constructor, getters y setters

![image](https://user-images.githubusercontent.com/34308601/81628324-fff04c00-93c5-11ea-9fe6-08b061869e2f.png)

MYSQL/JDBC

ContextJDBC

Conexión con la base de datos

![image](https://user-images.githubusercontent.com/34308601/81628386-2a420980-93c6-11ea-9b97-86adbe67cc67.png)

JDBCPersonaDAO

Se crean todos los métodos con la base de datos

![image](https://user-images.githubusercontent.com/34308601/81628403-33cb7180-93c6-11ea-96ab-bc2c5f1ccaab.png)

JDBCTelefonoDAO

Se crean todos los métodos con la base de datos

![image](https://user-images.githubusercontent.com/34308601/81628454-565d8a80-93c6-11ea-89a4-b2e9c2d12d29.png)

SERVLETS

Para la comunicación entre el controlador y la vista

![image](https://user-images.githubusercontent.com/34308601/81628415-3ded7000-93c6-11ea-8f80-56ecada17d40.png)

AgregarTelefono

Se puede agregar un teléfono al usuario

![image](https://user-images.githubusercontent.com/34308601/81628476-5fe6f280-93c6-11ea-841d-a9d5dceaa6e0.png)

Búsqueda

Se utiliza para buscar otra persona por su cedula o email

![image](https://user-images.githubusercontent.com/34308601/81628501-72612c00-93c6-11ea-87be-7a0965368e29.png

EditarTelefono

Se puede editar cualquier teléfono de un usuario

![image](https://user-images.githubusercontent.com/34308601/81628519-7f7e1b00-93c6-11ea-961c-3df218cb6f88.png)

De la misma forma, eliminar un teléfono

![image](https://user-images.githubusercontent.com/34308601/81628536-89a01980-93c6-11ea-9af8-a44a7e11b93e.png)

Login

![image](https://user-images.githubusercontent.com/34308601/81628549-93298180-93c6-11ea-9ef9-0b8abd14393d.png)

MIAgenda

![image](https://user-images.githubusercontent.com/34308601/81628564-9cb2e980-93c6-11ea-9e20-ca11bf1ff0a8.png)

Registro

![image](https://user-images.githubusercontent.com/34308601/81628582-a8061500-93c6-11ea-9a0b-a370ad12263c.png)

JSPs

![image](https://user-images.githubusercontent.com/34308601/81628608-bd7b3f00-93c6-11ea-9b62-4e0047004805.png)



