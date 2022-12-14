package com.example.proyecto_uno.DB;

import static android.content.ContentValues.TAG;

import android.database.Cursor;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proyecto_uno.Adaptadores.ProductAdapter;
import com.example.proyecto_uno.Entidades.Producto;
import com.example.proyecto_uno.Services.services;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFireBase {

    private FirebaseFirestore db;
    private services services;

    public DBFireBase(){
        this.db = FirebaseFirestore.getInstance();
//        this.productService = new Producto();
    }

    public void insertData(Producto prod){
        // Create a new user with a first and last name
        Map<String, Object> product = new HashMap<>();
        product.put("id",prod.getId() );
        product.put("name",prod.getName_product() );
        product.put("description", prod.getDescription());
        product.put("image", prod.getImage());

        // Add a new document with a generated ID
        db.collection("products")
                .add(product)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
        //db.terminate();
    }

    public void getData(ProductAdapter productAdapter, ArrayList<Producto> list){
        db.collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Producto product = null;
                                if(!Boolean.valueOf(document.getData().get("deleted").toString())){
                                    product = new Producto(
                                            document.getData().get("id").toString(),
                                            document.getData().get("name").toString(),
                                            document.getData().get("description").toString(),
                                            document.getData().get("image").toString()
                                    );
                                    list.add(product);
                                }
                            }
                            productAdapter.notifyDataSetChanged();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void deleteData(String id){
        db.collection("products").whereEqualTo("id",id)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                documentSnapshot.getReference().delete();
                            }
                        }
                    }
                });
    }

    public void updateData(Producto producto){
        db.collection("products").whereEqualTo("id", producto.getId())
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                documentSnapshot.getReference().update(
                                        "name", producto.getName_product(),
                                        "description", producto.getDescription(),
                                        "image", producto.getImage()
                                );
                            }
                        }
                    }
                });
    }
}
