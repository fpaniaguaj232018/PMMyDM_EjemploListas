package net.juanxxiii.pmmydm_ejemplolistas.model;

import java.util.ArrayList;

public class GestorVideojuegos {
    public static ArrayList<Videojuego> getVideojuegos(String plataforma){
        ArrayList<Videojuego> alv = new ArrayList();
        for (int i=0;i<10;i++){
            alv.add(new Videojuego("JUEGO 0" + i,"PS4", 10));
            alv.add(new Videojuego("FORNITE" + i, "NINTENDO SWITCH", 30));
            alv.add(new Videojuego("CUP HEAD" + i, "XBOX ONE", 80));
            alv.add(new Videojuego("JUEGO 1" + i,"PS4", 10));
            alv.add(new Videojuego("JUEGO 2" + i, "NINTENDO SWITCH", 30));
            alv.add(new Videojuego("JUEGO 3" + i, "XBOX ONE", 80));
            alv.add(new Videojuego("JUEGO 4" + i,"PS4", 10));
            alv.add(new Videojuego("JUEGO 5" + i, "NINTENDO SWITCH", 30));
            alv.add(new Videojuego("JUEGO 6" + i, "XBOX ONE", 80));
            alv.add(new Videojuego("JUEGO 7" + i,"PS4", 10));
            alv.add(new Videojuego("JUEGO 7" + i, "NINTENDO SWITCH", 30));
            alv.add(new Videojuego("JUEGO 8" + i, "XBOX ONE", 80));
        }
        if (plataforma==null) return alv;

        ArrayList<Videojuego> alvFiltrado = new ArrayList();
        for (Videojuego v : alv) {
            if (v.getPlataforma().equals(plataforma)){
                alvFiltrado.add(v);
            }
        }
        return alvFiltrado;
    }
}
