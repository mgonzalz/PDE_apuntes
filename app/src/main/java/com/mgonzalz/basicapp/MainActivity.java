package com.mgonzalz.basicapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Esta actividad es la que inicialmente se muestra. Viene por defecto.

    private TextView tvMensaje, tvResultado; // Clase en memoria para manipular el componente gráfico que asociamos abajo con findViewById.
    private Button btCambiarTexto, btSumar;
    private EditText editNumber1, editNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Aqui relacionamos la actividad con la vista
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvMensaje = findViewById(R.id.tvMensaje); // Buscar en el layout asociado a la actividad, ese identificador, y se asigna a la variable.
        btCambiarTexto = findViewById(R.id.btCambiarTexto);
        // btCambiarTexto.setOnClickListener(this::onBtCambiarTexto); // Asociar un oyente a un evento. De manera dinámica. Opción 1.
        btCambiarTexto.setOnClickListener( v-> onBtCambiarTexto(v)); // Asociar un oyente a un evento. De manera dinámica. Opción 2.
        tvResultado = findViewById(R.id.tvResultado);
        editNumber1 = findViewById(R.id.editNumber1);
        editNumber2 = findViewById(R.id.editNumber2);
        btSumar = findViewById(R.id.btSumar);
        btSumar.setOnClickListener(v -> onBtSumar(v)); // Asociar un oyente a un evento. De manera dinámica. Para la suma.
    }

    // Declaración de oyente, todos se declaran como un método que no devuelve nada y que recibe una View.
    public void onBtCambiarTexto(View v){
        tvMensaje.setText("Pulsaste el botón");
        // Toast no está asociado a ninguna actividad.
        // ApplicationContext sirve para acceder a los recursos de la aplicación. A diferencia de ActivityContext que solo sirve para la actividad.
        Toast.makeText(getApplicationContext(), "Pulsaste el botón", Toast.LENGTH_SHORT).show();
    }
    // Asociación de un oyente a un evento de forma ESTÁTICA: Esto ocurre a través del layout en interfaz gráfica en Attributes > On Click.
    // Ahi salen todas las funciones asociadas a la vista que devuelvan VOID.

    // Asociación dinámica, se asigna el oyente de forma programática, no está en el layout.

    // Forma estática:
    public void onBtSumar(View v) {
        int numberOne = Integer.parseInt(editNumber1.getText().toString()); // Devuelve el número entero a partir del texto que contiene el edittext.
        int numberTwo = Integer.parseInt(editNumber2.getText().toString());
        tvResultado.setText("El resultado es " + (numberOne + numberTwo));
    }
}