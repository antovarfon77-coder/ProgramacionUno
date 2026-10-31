package logic;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.DetalleMovimiento;

public class MovimientosRealizados {
    private ArrayList<DetalleMovimiento> movimientosRealizados = new ArrayList<>();
    public void agregarDetalleMovimiento(DetalleMovimiento detalleMovimiento){
        movimientosRealizados.add(detalleMovimiento);
    }
    public void mostrarMovimientosRopa(){
        System.out.println("---Detalles realizados.---");
        StringBuilder totalDetallesRealizados = new StringBuilder();
        for (DetalleMovimiento detalle : movimientosRealizados) {
            totalDetallesRealizados.append(detalle.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null,totalDetallesRealizados);
    }
    public ArrayList<DetalleMovimiento> getMovimientosRealizados() {
        return movimientosRealizados;
    }
    public void setMovimientosRealizados(ArrayList<DetalleMovimiento> movimientosRealizados) {
        this.movimientosRealizados = movimientosRealizados;
    }
    
}
