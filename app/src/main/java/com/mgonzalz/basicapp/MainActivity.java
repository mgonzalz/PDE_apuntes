package com.mgonzalz.basicapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Esta actividad es la que inicialmente se muestra. Viene por defecto.

    private TextView tvMensaje; // Clase en memoria para manipular el componente gráfico que asociamos abajo con findViewById.

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
    }

    // Declaración de oyente, todos se declaran como un método que no devuelve nada y que recibe una View.
    public void onBtCambiarTexto(View v){
        tvMensaje.setText("Pulsaste el botón");
    }
    // Asociación de un oyente a un evento de forma ESTÁTICA: Esto ocurre a través del layout en interfaz gráfica en Attributes > On Click.
    // Ahi salen todas las funciones asociadas a la vista que devuelvan VOID.
}