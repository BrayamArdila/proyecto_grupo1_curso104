package com.example.proyecto_uno;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_uno.Adaptadores.ProductAdapter;
import com.example.proyecto_uno.DB.DBFireBase;
import com.example.proyecto_uno.Entidades.Producto;
import com.example.proyecto_uno.Services.services;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class ProductForm extends AppCompatActivity {
    private services productService;
    private DBFireBase dbFirebase;
    private Button btnFormProduct;
    private EditText editNameFormProduct, editDescriptionFormProduct, editPriceFormProduct, editIdFormProduct;
    private ImageView imgFormProduct;
    private ProductAdapter productAdapter;
    ActivityResultLauncher<String> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_form);

        btnFormProduct = (Button) findViewById(R.id.btnFormProduct);
        editNameFormProduct = (EditText) findViewById(R.id.editNameFormProduct);
        editDescriptionFormProduct = (EditText) findViewById(R.id.editDescriptionFormProduct);
        editPriceFormProduct = (EditText) findViewById(R.id.editPriceFormProduct);
        imgFormProduct = (ImageView) findViewById(R.id.imgFormProduct);

        Intent intentIN = getIntent();
        Boolean edit = intentIN.getBooleanExtra("edit", false);

        if(edit){
            btnFormProduct.setText("Actualizar");
            editNameFormProduct.setText(intentIN.getStringExtra("name"));
            editDescriptionFormProduct.setText(intentIN.getStringExtra("description"));
            editPriceFormProduct.setText(String.valueOf(intentIN.getIntExtra("price", 0)));
        }


        byte[] img = "".getBytes(StandardCharsets.UTF_8);
        try {
            productService = new services();
            dbFirebase = new DBFireBase();
        }catch (Exception e){
            Log.e("DB", e.toString());
        }

        content = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(result);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            imgFormProduct.setImageBitmap(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        imgFormProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content.launch("image/*");
            }
        });

        btnFormProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    productAdapter= new ProductAdapter();

                    productAdapter.createOrUpdateProduct(

                            UUID.randomUUID().toString(),
                            editNameFormProduct.getText().toString(),
                            editDescriptionFormProduct.getText().toString(),
                            "",
                            edit

                    );

                }catch (Exception e){
                    Log.e("DB Insert", e.toString());
                }


                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    public void clean(){
        editNameFormProduct.setText("");
        editDescriptionFormProduct.setText("");
        editPriceFormProduct.setText("");
        imgFormProduct.setImageResource(R.drawable.carform);
    }
}