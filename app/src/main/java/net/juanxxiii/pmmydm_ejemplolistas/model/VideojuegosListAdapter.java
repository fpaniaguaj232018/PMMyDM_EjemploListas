package net.juanxxiii.pmmydm_ejemplolistas.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.juanxxiii.pmmydm_ejemplolistas.R;

import java.util.ArrayList;

public class VideojuegosListAdapter extends ArrayAdapter<Videojuego> {
    ArrayList<Videojuego> alv;
    int idVistaElemento;
    public VideojuegosListAdapter(Context context, int resource, ArrayList<Videojuego> objects) {
        super(context, resource, objects);
        alv = objects;
        idVistaElemento = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater li = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(idVistaElemento, parent, false);
        }
        TextView tvTitulo = (TextView)convertView.findViewById(R.id.tvTitulo);
        TextView tvPlataforma = (TextView)convertView.findViewById(R.id.tvPlataforma);
        TextView tvPrecio = (TextView)convertView.findViewById(R.id.tvPrecio);
        tvTitulo.setText(alv.get(position).getTitulo());
        tvPlataforma.setText(alv.get(position).getPlataforma());
        tvPrecio.setText(String.valueOf(alv.get(position).getPrecio()));


        return convertView;
    }
}


















