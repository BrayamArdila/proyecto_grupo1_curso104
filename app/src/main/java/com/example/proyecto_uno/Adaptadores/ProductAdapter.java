package com.example.proyecto_uno.Adaptadores;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.proyecto_uno.DB.DBFireBase;
import com.example.proyecto_uno.Entidades.Producto;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private DBFireBase dbFirebase;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public void createOrUpdateProduct(

            String id, String name, String description, String image, boolean edit
    ){
        dbFirebase=new DBFireBase();

        System.out.println(id);
        System.out.println(name);
        System.out.println(description);
        System.out.println(image);
        System.out.println(edit);

        Producto product= new Producto(id, name, description, image);
        if(edit){
            product.setId(id);
            dbFirebase.updateData(product);
        }else{
            dbFirebase.insertData(product);
        }
    }
    public ArrayList<Producto> getProducts(){
        ArrayList<Producto> lisProduct = new ArrayList();

        dbFirebase=new DBFireBase();
        dbFirebase.getData(this,lisProduct);
        return lisProduct;

    }

}

