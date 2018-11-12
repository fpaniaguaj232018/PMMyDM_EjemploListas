package net.juanxxiii.pmmydm_ejemplolistas.model;

import java.util.ArrayList;

public class GestorVideojuegos {
    public static ArrayList<Videojuego> getVideojuegos(){
        ArrayList<Videojuego> alv = new ArrayList();
        for (int i=0;i<10;i++){
            alv.add(new Videojuego("COD","PS4", 10));
            alv.add(new Videojuego("FORNITE", "NINTENDO SWITCH", 30));
            alv.add(new Videojuego("CUP HEAD", "XBOX ONE", 80));
        }
        return alv;
    }
}
