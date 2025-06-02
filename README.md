📚 Sistema de Biblioteca en Java

Este es un proyecto hecho en Java que simula el sistema de una biblioteca. Fue desarrollado como parte de nuestro proyecto de programación II. El sistema permite gestionar libros y usuarios, hacer préstamos y devoluciones, y conectar todo con una base de datos en Access (.accdb).

🔗 Repositorio del proyecto:
👉 https://github.com/Sudo-apt-EricTorr99/BibliotecaProyect.git

🧠 ¿Qué hace este programa?
El sistema permite:

📖 Gestionar libros:
Agregar libros (nombre del libro, ID del autor, ID de la editorial, fecha de lanzamiento).

Eliminar libros por ID.

Ver todos los libros registrados en la base de datos.

👤 Gestionar usuarios:
Registrar nuevos usuarios (nombre, apellidos, edad, ocupación).

El sistema les asigna un ID único automáticamente.

Eliminar usuarios por su ID.

Ver todos los usuarios registrados.

📥 Préstamos y devoluciones:
Permite prestar libros a los usuarios registrados.

Permite devolver libros prestados.

Todo esto está conectado a una base de datos hecha en Microsoft Access (.accdb) y manejada desde Java usando el driver UCanAccess.

⚙️ ¿Cómo ejecutar el proyecto?
Clona este repositorio en tu máquina:
git clone https://github.com/Sudo-apt-EricTorr99/BibliotecaProyect.git
Ábrelo con NetBeans.

Cambia la ruta de la base de datos Access:

Ve al paquete Conexiones.

Abre la clase Conexion.java.

Busca la línea donde se establece la conexión con la base de datos:

String url = "jdbc:ucanaccess://C:/ruta/a/tu/archivo/BaseDatos.accdb";
Cámbiala por la ruta donde tengas guardado tu archivo .accdb en tu computadora.

Ejecuta la clase Raiz:

Esta clase es la que arranca todo el sistema.

Asegúrate de tener abierta la clase Raiz.java y presiona Shift + F6 para ejecutar el programa desde ahí.

💻 Requisitos
Tener instalado Java (JDK) 24.

Tener instalado NetBeans 26.

Tener configurado el driver UCanAccess (ya está incluido en el proyecto, pero si llega a fallar la conexión, asegúrate de que esté bien agregado a las librerías del proyecto).

📌 Notas extra
La base de datos Access se puede editar desde Microsoft Access si quieres hacer pruebas directas.

El código está comentado para facilitar su entendimiento y modificación.

🚀 Autores
Hecho por:

Eric Uriel Rojas Torres

Miguel Ángel Medina Aguilar

Estudiantes de Ingeniería en Computación 💻
