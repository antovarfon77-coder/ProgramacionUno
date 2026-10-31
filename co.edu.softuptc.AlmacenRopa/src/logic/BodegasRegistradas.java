package logic;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;
public class BodegasRegistradas {
    
    private ArrayList<Bodega> bodegasRegistradas = new ArrayList<>();
    Bodega ElLaguito = new Bodega("2353", "El Laguito", "Sogamoso", "320445698", 50);
    Bodega LaCandelaria = new Bodega("2354", "La Candelaria", "Tunja", "320445699", 100);
    Bodega LaEsperanza = new Bodega("2355", "La Esperanza", "Tunja", "320445700", 75);
    // Método para agregar un cliente a la base de datos
    public void agregarBodega(Bodega bodega) {
        bodegasRegistradas.add(ElLaguito);
        bodegasRegistradas.add(LaCandelaria);
        bodegasRegistradas.add(LaEsperanza);
        bodegasRegistradas.add(bodega);
    }
    public Bodega buscarBodega(String auxIdBodega){
        for (Bodega c : bodegasRegistradas) {
            if (c.getIdBodega().equals(auxIdBodega)) {
                return c;
            }
        }
        return null;
    }
    public String mostrarBodegas() {
        String registroBodegas=".";
        if (bodegasRegistradas.isEmpty()) { 
            return JOptionPane.showInputDialog(null,"No hay bodegas registradas.",JOptionPane.ERROR_MESSAGE);
        }
        
        for (Bodega b : bodegasRegistradas) {
            registroBodegas+=b.mostrarBodega();
        }
        return JOptionPane.showInputDialog(null,"--- LISTA DE BODEGAS ---\n"+registroBodegas);
    }
}
