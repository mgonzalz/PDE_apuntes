# PDE - Apuntes de Android Studio

## Clase 1. Introducción a Android Studio

### 1. Creación del proyecto

Para crear un proyecto en Android Studio:

1. Seleccionar **Empty Views Activity**.
2. Elegir **Java** como lenguaje.
3. Configurar el nombre del proyecto y el *Package name* (`com.nombre.app`).
4. Configurar el **JDK** compatible con el proyecto si Android Studio lo solicita.

![Creación del proyecto](imgs/new-project-init.png)

### 2. Estructura del proyecto

Android Studio muestra por defecto la vista **Android**, que agrupa los archivos según su función. Para visualizar la estructura real de carpetas, seleccionamos la vista **Project**.

Android separa principalmente el código de la interfaz gráfica:

- **`MainActivity.java`**: contiene la lógica de la actividad. Una *Activity* representa un componente que normalmente gestiona una pantalla de la aplicación.
- **`activity_main.xml`**: define la interfaz gráfica de esa pantalla, conocida como *layout*.

Al crear un proyecto con *Empty Views Activity*, Android Studio genera ambos archivos automáticamente.

Rutas habituales:

```text
app/src/main/
├── java/com/mgonzalz/basicapp/MainActivity.java
└── res/layout/activity_main.xml
```

Para relacionar la actividad con su layout utilizamos:

```java
setContentView(R.layout.activity_main);
```

### 3. Layouts, vistas y atributos

Un **layout** es un contenedor que organiza los elementos gráficos de una pantalla.

Las **vistas (Views)** son los componentes de la interfaz, por ejemplo:

- `TextView`: muestra texto.
- `Button`: botón interactivo.
- `EditText`: permite introducir texto.
- `ImageView`: muestra imágenes.

Cada vista tiene **atributos** que definen sus propiedades, como el tamaño, el texto o la posición. Se pueden configurar desde el XML, mediante el editor visual o programáticamente desde Java.

#### ConstraintLayout

`ConstraintLayout` permite posicionar componentes mediante restricciones respecto a otros elementos o al contenedor principal (`parent`).

Las restricciones principales son:

| Restricción | Posición |
|---|---|
| `Top` | Arriba |
| `Bottom` | Abajo |
| `Start` | Izquierda (habitualmente) |
| `End` | Derecha (habitualmente) |

Para generar automáticamente las restricciones desde el editor visual podemos utilizar **Infer Constraints**.

![Infer Constraints](imgs/infer-constrains.png)

### 4. Gestión de eventos

Los eventos permiten ejecutar acciones cuando el usuario interactúa con una vista, por ejemplo, al pulsar un botón.

Existen dos formas de asociar eventos:

**Asociación estática:** se declara directamente en el XML mediante `android:onClick`.

```xml
android:onClick="onBtCambiarTexto"
```

**Asociación dinámica:** se configura desde Java mediante un listener.

```java
btCambiarTexto.setOnClickListener(v -> onBtCambiarTexto(v));
```

En ambos casos podemos utilizar el mismo método:

```java
public void onBtCambiarTexto(View v) {
    Toast.makeText(this, "Pulsaste el botón", Toast.LENGTH_SHORT).show();
}
```

`Toast` muestra un mensaje temporal en pantalla. El `Context` proporciona acceso al entorno de Android y `.show()` muestra el mensaje.

**Diferencia principal:** la asociación estática se declara en el XML, mientras que la dinámica se establece desde Java durante la ejecución, ofreciendo mayor flexibilidad.


## Clase 2. Actividades e Intents

### 1. Actividades y ciclo de vida

Las **Activities** son componentes de Android que podemos entender como las pantallas de nuestra aplicación.

Cada actividad tiene un **ciclo de vida**, compuesto por distintos métodos que Android ejecuta según su estado.

Uno de los principales es `onCreate()`, que se ejecuta al crear la actividad y permite inicializar sus componentes y configurar la interfaz gráfica.

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}
```

### 2. Creación de una nueva Activity

Para crear una actividad desde Android Studio, seleccionamos el paquete correspondiente y seguimos la ruta:

**New → Activity → Empty Views Activity**

Android Studio generará automáticamente la clase Java y su layout XML asociado.

![Crear nueva Activity](imgs/create-project.png)

Para organizar mejor el proyecto, podemos crear las actividades dentro de un paquete específico, por ejemplo, `activities`.

![Configuración de la Activity](imgs/create-project-details.png)

### 3. Intents

Los **Intents** son objetos que permiten solicitar operaciones a otros componentes de Android.

Se utilizan, por ejemplo, para:

- Iniciar una nueva actividad.
- Iniciar un servicio.
- Enviar un *broadcast*.

Existen dos tipos principales:

**Intent explícito:** especificamos directamente el componente que queremos iniciar. Por ejemplo, abrir otra pantalla al pulsar un botón.

```java
Intent intent = new Intent(this, SecondActivity.class);
startActivity(intent);
```

**Intent implícito:** indicamos la acción que queremos realizar, pero no especificamos qué aplicación debe ejecutarla. Android busca las aplicaciones compatibles y resuelve cuál utilizar.

Por ejemplo, abrir una página web:

```java
Intent intent = new Intent(
    Intent.ACTION_VIEW,
    Uri.parse("https://www.google.com")
);
startActivity(intent);
```

**Diferencia principal:** en los Intents explícitos indicamos el componente de destino, mientras que en los implícitos indicamos la acción y Android determina qué aplicación puede realizarla.