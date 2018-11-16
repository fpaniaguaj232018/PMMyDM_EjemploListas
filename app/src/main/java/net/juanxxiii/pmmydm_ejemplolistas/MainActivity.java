package net.juanxxiii.pmmydm_ejemplolistas;

import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.juanxxiii.pmmydm_ejemplolistas.model.GestorVideojuegos;
import net.juanxxiii.pmmydm_ejemplolistas.model.Videojuego;
import net.juanxxiii.pmmydm_ejemplolistas.model.VideojuegosListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Videojuego> alv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alv = GestorVideojuegos.getVideojuegos();
        VideojuegosListAdapter vjla = new VideojuegosListAdapter(this, R.layout.row_videojuego, alv);
        ListView lv = (ListView)findViewById(R.id.lvListVideojuegos);
        lv.setAdapter(vjla);
        notificaCarga();

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nombre = alv.get(i).getTitulo();
                Toast.makeText(MainActivity.this, nombre, Toast.LENGTH_SHORT).show();

                DialogoFragment df = new DialogoFragment();
                df.show(getFragmentManager(), "ElNombreDaIgual");
                return true;
            }
        });






    }
    private void notificaCarga(){
        //Construcción de la notificación
        Notification.Builder nb = new Notification.Builder(this);
        nb.setSmallIcon(R.drawable.ic_launcher_background);
        nb.setContentTitle("AVISO");
        nb.setContentText("La lista se ha cargado");
        nb.setAutoCancel(true);
        Notification notificacion = nb.build();
        //Lanzamiento de la notificación
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1, notificacion);

    }

    public void aprobarAsignatura(){
        Toast.makeText(this, "ASIGNATURA APROBADA", Toast.LENGTH_SHORT).show();
    }
}














