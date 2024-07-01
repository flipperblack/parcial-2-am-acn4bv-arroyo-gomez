package com.example.grupofacil;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vinculo vistas
        Button addButton = findViewById(R.id.addButton);
        ScrollView scrollView = findViewById(R.id.scrollView);
        final LinearLayout linearLayout = findViewById(R.id.linearLayout);

        //Agregar un botón nuevo al presionar el botón "Agregar botón"
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un nuevo botón
                Button newButton = new Button(getApplicationContext());

                // Configurar el texto y la fuente del botón
                newButton.setText("Grupo nuevo");
                Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.poppins);
                newButton.setTypeface(typeface);

                // Configurar el tamaño y el color de fondo del botón
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, // Ancho MATCH_PARENT
                        LinearLayout.LayoutParams.WRAP_CONTENT); // Alto WRAP_CONTENT
                newButton.setBackgroundResource(R.drawable.button_background); // Fondo del botón

                // Configurar el margen inferior del botón
                layoutParams.setMargins(0, 0, 5, 16); // Margen inferior de 16dp

                // Aplicar los parámetros de diseño al botón
                newButton.setLayoutParams(layoutParams);
                newButton.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);


                // Agregar el nuevo botón al LinearLayout dentro del ScrollView
                linearLayout.addView(newButton);

                // Scroll hacia abajo para mostrar el nuevo botón
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }

}