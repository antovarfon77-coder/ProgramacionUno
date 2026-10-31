package logic;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;

public class RopaEnEstante {

    private ArrayList<Ropa> estanteEstandar = new ArrayList<Ropa>();
    private ArrayList<Ropa> estanteEspecial = new ArrayList<Ropa>();
    public void agregarRopa(Ropa ropa) {
        if (ropa.getCalidadRopa().equalsIgnoreCase("estandar")) {
            estanteEstandar.add(ropa);
        }
        if(ropa.getCalidadRopa().equalsIgnoreCase("especial")){
            estanteEspecial.add(ropa);
        }
    }
    public Ropa buscarRopa(String id) {
        for (Ropa ropa : estanteEstandar) {
            if (ropa.getIdPrenda().equals(id)) {
                return ropa;
            }
        }
        return null;
    }
    public void mostrarRopa() {
        System.out.println("----Lista de ropa----\n");
        StringBuilder sbEstandar = new StringBuilder();
        StringBuilder sbEspecial = new StringBuilder();
        if (estanteEspecial.isEmpty() && estanteEstandar.isEmpty()) {
            JOptionPane.showMessageDialog(null,"No hay ropa registrada.");
        } 
        if (sbEspecial.equals(null)) {
            sbEspecial.append("No hay ropa en el estante para ropa especial");
        }
        if (sbEstandar.equals(null)) {
            sbEstandar.append("No hay ropa en el estante para ropa estandar");
        }
        
        for (Ropa ropa : estanteEstandar) {
            sbEstandar.append(ropa.toString()).append("\n");
        }
        for(Ropa rop: estanteEspecial){
            sbEspecial.append(rop.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, "\nEstante Estandar: "+sbEstandar+"\n Estante Especial: "+sbEspecial);
    }

    public ArrayList<Ropa> getEstanteEstandar() {
        return estanteEstandar;
    }

    public void setEstanteEstandar(ArrayList<Ropa> estanteEstandar) {
        this.estanteEstandar = estanteEstandar;
    }

    public ArrayList<Ropa> getEstanteEspecial() {
        return estanteEspecial;
    }

    public void setEstanteEspecial(ArrayList<Ropa> estanteEspecial) {
        this.estanteEspecial = estanteEspecial;
    }
}