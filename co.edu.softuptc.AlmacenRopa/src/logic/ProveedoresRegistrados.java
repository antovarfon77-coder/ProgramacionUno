package logic;
import java.util.ArrayList;

import model.*;
public class ProveedoresRegistrados {
    ArrayList<Proveedor> proveedoresRegistrados = new ArrayList<>();
    public void agregarProveedor(Proveedor proveedor) {
        proveedoresRegistrados.add(proveedor);
    }
    public ArrayList<Proveedor> getProveedoresRegistrados() {
        return proveedoresRegistrados;
    }
    public void setProveedoresRegistrados(ArrayList<Proveedor> proveedoresRegistrados) {
        this.proveedoresRegistrados = proveedoresRegistrados;
    }
    public Proveedor buscarProveedor(String auxIdProveedor){
        for (Proveedor p : proveedoresRegistrados) {
            if (p.getProveedorNIT().equals(auxIdProveedor)) {
                return p;
            }
        }
        return null;
    }
    public String mostrarProveedores() {
        if (proveedoresRegistrados.isEmpty()) { 
            return "No hay proveedores registrados.";
        }
        
        for (Proveedor p : proveedoresRegistrados) {
            p.mostrarProveedor();
        }
        return "--- LISTA DE PROVEEDORES ---\n";
    }
}
