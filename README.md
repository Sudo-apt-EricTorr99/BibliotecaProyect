📚 Sistema de Biblioteca en Java
Este es un proyecto hecho en Java que simula el sistema de una biblioteca. Fue desarrollado como parte de mis prácticas de programación. El sistema permite gestionar libros y usuarios, hacer préstamos y devoluciones, y conectar todo con una base de datos en Access.

🧠 ¿Qué hace este programa?
El sistema permite:

📖 Gestionar libros:

Agregar libros (nombre, ID del autor, ID de la editorial, fecha de lanzamiento).

Eliminar libros por ID.

Ver todos los libros registrados.

👤 Gestionar usuarios:

Registrar nuevos usuarios (nombre, apellidos, edad, ocupación).

Se les asigna un ID único automáticamente.

Eliminar usuarios por su ID.

Ver todos los usuarios registrados.

📥 Préstamos y devoluciones:

Permite prestar libros a usuarios registrados.

Permite devolver libros.

Todo esto se guarda y gestiona usando una base de datos Access (.accdb).

⚙️ ¿Cómo ejecutar el proyecto?
Clona este repositorio en tu máquina:

bash
Copiar
Editar
git clone https://github.com/tu-usuario/tu-repositorio.git
Ábrelo con NetBeans.

Cambia la ruta de la base de datos Access.

Ve al paquete Conexiones.

Abre la clase Conexion.java.

Ahí vas a encontrar una línea con la ruta del archivo .accdb, cámbiala por la ubicación del archivo en tu computadora.

Ejemplo:

java
Copiar
Editar
String url = "jdbc:ucanaccess://C:/ruta/a/tu/archivo/BaseDatos.accdb";
Ejecuta el proyecto desde la clase Raiz.

Esa clase se encarga de iniciar todo el programa.

Abre la clase Raiz.java, y presiona Shift + F6 para ejecutarla directamente.

💻 Requisitos
Tener instalado Java (JDK)

Tener NetBeans

Driver UCanAccess para conectar Java con Access (ya está integrado en el proyecto, pero si tienes errores de conexión, revisa que esté bien configurado).

📌 Notas extra
El programa está pensado para uso local con base de datos en Access.

🚀 Autor
Hecho por Eric Uriel Rojas Torres y Miguel Angel Medina Aguilar, estudiantes de Ingeniería en Computación 
