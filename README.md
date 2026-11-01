# PDE_apuntes
Inicio de proyecto:
- Crear un proyecto: Empty View Activity
- Poner lenguaje Java
- Cambiar el pack a `<nombre>.<app>`

Cuando el proyecto se inicie, lo primero que debemos de hacer es Set Up JDK con Android Studio.

![new-project-init.png](imgs/new-project-init.png)

La vista por defecto de carpetas es la de Android. Sin embargo para ver el sistema de archivo, abrir vista de Project:

Android separa el entorno gráfico del código: `MainActivity.java` código de una actividad, definimos actividad como una vista que se muestra en nuestra aplicación (podemos decir que es una pantalla); `activity_main.xml` como visualización, se le conoce como el layout. Al lanzar el proyecto como Empty Views Activity, automáticamente se genera una actividad main, el XML dicho anteriormente.

- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/java/com/mgonzalz/basicapp/MainActivity.java`