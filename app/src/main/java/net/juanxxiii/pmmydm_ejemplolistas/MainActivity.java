package net.juanxxiii.pmmydm_ejemplolistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import net.juanxxiii.pmmydm_ejemplolistas.model.GestorVideojuegos;
import net.juanxxiii.pmmydm_ejemplolistas.model.Videojuego;
import net.juanxxiii.pmmydm_ejemplolistas.model.VideojuegosListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Videojuego> alv = GestorVideojuegos.getVideojuegos();
        VideojuegosListAdapter vjla = new VideojuegosListAdapter(this, R.layout.row_videojuego, alv);
        ListView lv = (ListView)findViewById(R.id.lvListVideojuegos);
        lv.setAdapter(vjla);

    }
}














