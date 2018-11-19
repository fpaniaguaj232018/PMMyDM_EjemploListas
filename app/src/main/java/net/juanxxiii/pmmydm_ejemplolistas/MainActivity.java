package net.juanxxiii.pmmydm_ejemplolistas;

import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.hardware.camera2.TotalCaptureResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuconsulta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.idPS4:
                cargarVideojuegosEnLista("PS4");
                Toast.makeText(this, "PS4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.idXBOX:
                cargarVideojuegosEnLista("XBOX ONE");
                Toast.makeText(this, "XBOX", Toast.LENGTH_SHORT).show();
                break;
            case R.id.idSwitch:
                Toast.makeText(this, "SWITCH", Toast.LENGTH_SHORT).show();
                cargarVideojuegosEnLista("NINTENDO SWITCH");
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarVideojuegosEnLista(null);

    }

    private void cargarVideojuegosEnLista(String plataforma) {
        alv = GestorVideojuegos.getVideojuegos(plataforma);

        VideojuegosListAdapter vjla = new VideojuegosListAdapter(this, R.layout.row_videojuego, alv);
        ListView lv = (ListView)findViewById(R.id.lvListVideojuegos);
        lv.setAdapter(vjla);
        notificaCarga();

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return solicitarAprobacionAsignatura(i);
            }
        });
    }

    private boolean solicitarAprobacionAsignatura(int i) {
        String nombre = alv.get(i).getTitulo();
        Toast.makeText(MainActivity.this, nombre, Toast.LENGTH_SHORT).show();

        DialogoFragment df = new DialogoFragment();
        df.show(getFragmentManager(), "ElNombreDaIgual");
        return true;
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














