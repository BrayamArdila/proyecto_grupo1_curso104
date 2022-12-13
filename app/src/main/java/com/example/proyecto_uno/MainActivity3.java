package com.example.proyecto_uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private Button botondeinformación;
    private TextView textoProductoTitle,textdedescripcion;
    private ImageView imagenproducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        botondeinformación = (Button) findViewById(R.id.botondeinformación);
        textoProductoTitle = (TextView) findViewById(R.id.textoProductoTitle);
        textdedescripcion = (TextView) findViewById(R.id.textdedescripcion);
        imagenproducto = (ImageView) findViewById(R.id.imagenproducto);

        Intent intentIn = getIntent();
        textoProductoTitle.setText(intentIn.getStringExtra("Title"));
        textdedescripcion.setText(intentIn.getStringExtra("descripcion"));

        int codeImage = intentIn.getIntExtra("codigodelaimagen", 0);

        imagenproducto.setImageResource(codeImage);

        botondeinformación.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}