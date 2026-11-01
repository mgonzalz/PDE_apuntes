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

Los layouts son contenedores que permiten configurar/organizar componentes tales como textos, botones, etc. Se meten en un ConstrainsLayout, y está configurado según unos parámetros determinados. Por ej. Situar un botón según la pantalla principal y es adaptable.

Una vista es un elemento gráfico, como TextView, ButtonView, Widgets, ImageView. Elementos que sirven apra cosntruir el interfaz gráfico. Todos los componentes/vistas se declaran en el layout `.xml`. Se utiliza para eso la interfaz gráfica proporcionada por Android Studio y se añade automáticamente al código.

Hay atributos en las vistas, se pueden hacer de forma porgramática, pero se suelen hacer por la interfaz que deciamos antes.

