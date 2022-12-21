package com.example.proyecto_uno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Button botonproducto1, botonproducto2, botonproducto3;
    private TextView textoproducto1, textoproducto2, textoproducto3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        botonproducto1= (Button) findViewById(R.id.botonproducto1);
        botonproducto2= (Button) findViewById(R.id.botonproducto2);
        botonproducto3= (Button) findViewById(R.id.botonproducto3);

        textoproducto1= (TextView) findViewById(R.id.textoproducto1);
        textoproducto2= (TextView) findViewById(R.id.textoproducto2);
        textoproducto3= (TextView) findViewById(R.id.textoproducto3);

        botonproducto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("Title", textoproducto1.getText().toString());
                intent.putExtra("descripcion", "El Ford A (1927-1931) es un automóvil que fue producido y distribuido por el fabricante estadounidense Ford.Este modelo fue el segundo gran éxito de la marca tras su predecesor, el Ford T.Llegando a producirse 4 320 446 unidades de este modelo. PRECIO: 458.000.245 PESOS ");
                intent.putExtra("codigodelaimagen", R.drawable.carro1);
                startActivity(intent);
            }
        });

        botonproducto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("Title", textoproducto2.getText().toString());
                intent.putExtra("descripcion", "En 1934 el La Salle es un auto totalmente nuevo, que cuesta cerca de 1,000 dólares menos que el Cadillac mas barato. Las carrocerías eran hechas por Fleetwood y estaban inspiradas por el estilo “Art Deco”, muy de moda en los años treinta.PRECIO: 567.000.245 PESOS ");
                intent.putExtra("codigodelaimagen", R.drawable.carro2);
                startActivity(intent);
            }
        });
        botonproducto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("Title", textoproducto3.getText().toString());
                intent.putExtra("descripcion", "Este Rolls Royce 20-25 con carrocerías Sport Sedán de 1933 y Open Tourer descapotable de 1930 representaban el lujo y la distinción en los años treinta.PRECIO: 678.777.890 PESOS");
                intent.putExtra("codigodelaimagen", R.drawable.carro3);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionAdd:
                Intent intent = new Intent(getApplicationContext(), ProductForm.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }
}