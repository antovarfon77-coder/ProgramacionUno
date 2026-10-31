package logic;
import java.util.ArrayList;

import model.*;
public class TrabajadoresRegistrados {
    
    private ArrayList<Trabajador> trabajadoresRegistrados = new ArrayList<>();
    // Método para agregar un trabajador a la base de datos
    public void agregarTrabajador(Trabajador trabajador) {
        trabajadoresRegistrados.add(trabajador);
    }
    public ArrayList<Trabajador> getTrabajadoresRegistrados() {
        return trabajadoresRegistrados;
    }
    public void setTrabajadoresRegistrados(ArrayList<Trabajador> trabajadoresRegistrados) {
        this.trabajadoresRegistrados = trabajadoresRegistrados;
    }
    public Trabajador buscarTrabajador(String auxIdTrabajador){
        for (Trabajador t : trabajadoresRegistrados) {
            if (t.getIdTrabajador().equals(auxIdTrabajador)) {
                return t;
            }
        }
        return null;
    }
    public String mostrarTrabajadores() {
        if (trabajadoresRegistrados.isEmpty()) { 
            return "No hay trabajadores registrados.";
        }
        
        for (Trabajador t : trabajadoresRegistrados) {
            t.mostrarTrabajador();
        }
        return "--- LISTA DE TRABAJADORES ---\n";
    }
}
