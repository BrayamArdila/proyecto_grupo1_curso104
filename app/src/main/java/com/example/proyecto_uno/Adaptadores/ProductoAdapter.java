//package com.example.proyecto_uno.Adaptadores;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.proyecto_uno.Entidades.Producto;
//import com.example.proyecto_uno.R;
//
//import java.util.ArrayList;
//
//public class ProductoAdapter extends BaseAdapter {
//
//    private Context context;
//    private ArrayList<Producto> arrayProductos;
//
//
//    public ProductoAdapter(Context context, ArrayList<Producto> arrayProductos) {
//        this.context = context;
//        this.arrayProductos = arrayProductos;
//    }
//
//    public ArrayList<Producto> getArrayProductos() {
//        return arrayProductos;
//    }
//
//    public void setArrayProductos(ArrayList<Producto> arrayProductos) {
//        this.arrayProductos = arrayProductos;
//    }
//
//    @Override
//    public int getCount() {
//        return arrayProduct.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return arrayProductos.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int position, View convertView,
//                        ViewGroup viewGroup) {
//
//        View view = convertView;
//        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
//       // view = layoutInflater.inflate(R.layout.producto_template, root:null);
//
//        Producto producto = arrayProductos.get(position);
//
//        ImageView imgProductTemplate = (ImageView) view.findViewById(R.id.imgProductTemplate);
//        TextView textNameTemplate = (TextView) view.findViewById(R.id.textNameTemplate);
//        TextView testDescriptionTemplate = (TextView) view.findViewById(R.id.testDescriptionTemplate);

//        imgProductoTemplate.setImageResource(producto.getImage());
//        textNameTemplate.setText(producto.getName());
//        testDescriptionTemplate.setText(producto.getDescription());


//        return view;
//    }
//}
