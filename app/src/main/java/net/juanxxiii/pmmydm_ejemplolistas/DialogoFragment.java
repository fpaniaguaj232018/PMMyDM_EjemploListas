package net.juanxxiii.pmmydm_ejemplolistas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.widget.Toast;

public class DialogoFragment extends android.app.DialogFragment {
    int id;
    public void setId(int id){
        this.id = id;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alb = new AlertDialog.Builder(getActivity());
        alb.setTitle("PMMyDM");
        alb.setMessage("¿Deseas aprobar?");
        alb.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((MainActivity)getActivity()).aprobarAsignatura();
            }
        });
        alb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "NO", Toast.LENGTH_SHORT).show();
            }
        });
        alb.setNeutralButton("No lo sé", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "JAJAJAJA", Toast.LENGTH_SHORT).show();
            }
        });
        Dialog d = alb.create();
        return d;
    }
}

