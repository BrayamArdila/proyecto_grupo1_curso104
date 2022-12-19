package com.example.proyecto_uno.Services;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.proyecto_uno.Entidades.Producto;
import com.example.proyecto_uno.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class services {
    public ArrayList<Producto> cursorToArray(Cursor cursor){
        ArrayList<Producto> list = new ArrayList<Producto>();
        if(cursor.getCount() == 0){
            return list;
        }else{
            while (cursor.moveToNext()){
//                Producto product = new Producto(
//                        cursor.getBlob(4),
//                        cursor.getString(1),
//                        cursor.getString(2),
//                        Integer.parseInt(cursor.getString(3))
//                );
//                list.add(product);
            }
        }
        return list;
    }

    public byte[] imageViewToByte(ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}
