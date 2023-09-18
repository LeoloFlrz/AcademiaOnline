# AcademiaOnline

## Features

- Crear/Editar/Eliminar Cursos
- Actualizar Cursos
- Asignar Cursos a los Usuarios
- Crear/Editar/Eliminar Usuarios
  


## Clone and Installation

Clonar el Repositorio: Clona este repositorio en tu máquina local usando el siguiente comando:

git clone https://github.com/LeoloFlrz/AcademiaOnline.git

Install the project with npm

```bash

    Para el FrontEnd:

  cd "Carpetadelproyecto"
  npm install (Para las dependencias)
  npm run dev

    Para el BackEnd:
  
Base de Datos: Configura una base de datos MySQL en tu servidor local. Crea una base de datos llamada db_academy.

Configuración de la Base de Datos: Abre el archivo src/main/resources/application.properties y configura las propiedades de la base de datos de acuerdo a tu entorno:
---------------------------------------------------
spring.datasource.url=jdbc:mysql://localhost:3306/db_academy
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

-------------------------------------
Compilar y Ejecutar: Desde la línea de comandos, ve a la carpeta raíz del proyecto y ejecuta el siguiente comando para compilar y ejecutar la aplicación:

mvn spring-boot: run
Acceder a la Aplicación: Abre tu navegador web y accede a http://localhost:8080 para utilizar la aplicación.
```



## Tech Stack

**Client:** Vue, VueRouter, Tailwind CSS

**Server:** Java, SpringBoot
