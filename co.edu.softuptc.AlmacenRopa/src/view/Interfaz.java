package view;
import javax.swing.*;
import controller.*;

public class Interfaz {
    // Objetos
    private Control control = new Control();
    //Variables
    private String seleccionPrincipal;
    private String subOpcion, proveedorNIT, nombreProveedor, telefonoContacto, correoProveedor, cantidad, costoAdquisicion;
    private String[] opcionesMenuUno = {"1. Gestionar registro proveedores.",
        "2. Gestionar registro de bodega",
        "3. Gestionar trabajadores.",
        "4. Realizar movimiento de ropa.",
        "5. Mostrar informacion inventario.",
        "0. Salir"};
    private String[] opcionesMostrarInformacion = {"1.Mostrar en bodegas."};
    public void MenuPrincipal() {

        do {
            opcionesMenuUno();
            if (seleccionPrincipal==null) {
                seleccionPrincipal="0.Salir";
            }
        switch (seleccionPrincipal) {
            case "1. Gestionar registro proveedores.":
                // Lógica para gestionar registro de proveedores
                registrarProveedor();
                break;
            case "2. Gestionar registro de bodega":
                // Lógica para gestionar registro de bodega
                registrarBodega();
                break;
            case "3. Gestionar trabajadores.":
                registrarTrabajador();
                break;
            case "4. Realizar movimiento de ropa.":
                realizarMovimiento();
                break;
            case "5. Mostrar informacion inventario.":
                opcionSubMenu();
                if (subOpcion==null) {
                    opcionesMenuUno();
                }
                switch (subOpcion) {
                    case "1. Mostrar ropa en bodegas":
                        mostrarRopa();
                }
                break;
        }
        } while (seleccionPrincipal!="0. Salir");
    }
    public void opcionesMenuUno(){
        seleccionPrincipal = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion: ", "Bienvenido al sistema de gestión de inventario.", JOptionPane.QUESTION_MESSAGE, null, opcionesMenuUno,opcionesMenuUno[0]);
    }
    public void opcionSubMenu(){
        subOpcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion: ", "Mostrar informacion inventario.", JOptionPane.QUESTION_MESSAGE, null, opcionesMostrarInformacion,opcionesMostrarInformacion[0]);
    }
    //Mostrar ropa en bodegas
    public void mostrarRopa(){
        control.mostrarRopa();
    }
    public void registrarProveedor() {
        proveedorNIT = JOptionPane.showInputDialog(null,"Nit del provedor: ","REGISTRO PROVEEDOR",JOptionPane.QUESTION_MESSAGE);   
        nombreProveedor = JOptionPane.showInputDialog(null, "Nombre del provedor: ","REGISTRO PROVEEDOR",JOptionPane.QUESTION_MESSAGE);
        telefonoContacto = JOptionPane.showInputDialog(null, "Telefono de contacto del provedor: ","REGISTRO PROVEEDOR",JOptionPane.QUESTION_MESSAGE);   
        correoProveedor = JOptionPane.showInputDialog(null, "Correo electronico del provedor: ","REGISTRO PROVEEDOR",JOptionPane.QUESTION_MESSAGE);   
        control.agregarProveedor(proveedorNIT, nombreProveedor, telefonoContacto, correoProveedor);
    }
    public void registrarBodega() {
        String idBodega = JOptionPane.showInputDialog(null, "Numero de identificacion de bodega: ","REGISTRO BODEGA",JOptionPane.QUESTION_MESSAGE);
        String nombreBodega = JOptionPane.showInputDialog(null, "Nombre de bodega: ","REGISTRO BODEGA",JOptionPane.QUESTION_MESSAGE); 
        String direccionBodega = JOptionPane.showInputDialog(null, "Dirrecion de bodega: ","REGISTRO BODEGA",JOptionPane.QUESTION_MESSAGE);
        String telefonoBodega = JOptionPane.showInputDialog(null, "Telefono de contacto de bodega: ","REGISTRO BODEGA",JOptionPane.QUESTION_MESSAGE);
        String almacenamientoMaximo = JOptionPane.showInputDialog(null, "Almacenamiento maximo de bodega: ","REGISTRO BODEGA",JOptionPane.QUESTION_MESSAGE);   
        control.agregarBodega(idBodega, nombreBodega, direccionBodega, telefonoBodega, almacenamientoMaximo);
    }
    public void registrarTrabajador() {
        String idTrabajador = JOptionPane.showInputDialog(null, "Numero de identifiacion del trabajador: ","REGISTRO TRABAJADOR",JOptionPane.QUESTION_MESSAGE);   
        String nombreTrabajador = JOptionPane.showInputDialog(null, "Nombre de trabajador: ","REGISTRO TRABAJADOR",JOptionPane.QUESTION_MESSAGE);   
        String telefonoTrabajador = JOptionPane.showInputDialog(null, "Telefono de contacto de trabajador: ","REGISTRO TRABAJADOR",JOptionPane.QUESTION_MESSAGE);   
        String cargoTrabajador = JOptionPane.showInputDialog(null, "Cargo del trabajador: ","REGISTRO TRABAJADOR",JOptionPane.QUESTION_MESSAGE);   
        String turnoLaboral = JOptionPane.showInputDialog(null, "Turno laboral del trabajador: ","REGISTRO TRABAJADOR",JOptionPane.QUESTION_MESSAGE);   
        control.agregarTrabajador(idTrabajador, nombreTrabajador, telefonoTrabajador, cargoTrabajador, turnoLaboral);
    }
    public void registrarRopa() {
        String idPrenda = JOptionPane.showInputDialog(null, "Numero de identificacion ropa: ","MOVIMIENTO ROPA",JOptionPane.QUESTION_MESSAGE); 
        String categoria = JOptionPane.showInputDialog(null, "Categoria [Dama/Caballero/Niño]: ","MOVIMIENTO ROPA",JOptionPane.QUESTION_MESSAGE); 
        String descripcion = JOptionPane.showInputDialog(null, "Descripcion: ","MOVIMIENTO ROPA",JOptionPane.QUESTION_MESSAGE); 
        String talla = JOptionPane.showInputDialog(null, "Talla : ","MOVIMIENTO ROPA",JOptionPane.QUESTION_MESSAGE); 
        String precioVentaSugerido = JOptionPane.showInputDialog(null, "Precio de venta sugerido: ","MOVIMIENTO ROPA",JOptionPane.QUESTION_MESSAGE); 
        cantidad = JOptionPane.showInputDialog(null, "Cantidad ropa: ","MOVIMIENTO ROPA",JOptionPane.QUESTION_MESSAGE); 
        costoAdquisicion = JOptionPane.showInputDialog(null, "Costo adquision ropa: ","MOVIMIENTO ROPA",JOptionPane.QUESTION_MESSAGE); 
        String color = JOptionPane.showInputDialog(null, "Color y/o colores: ","MOVIMIENTO ROPA",JOptionPane.QUESTION_MESSAGE); 
        String calidadRopa = JOptionPane.showInputDialog(null,"Estandar=Ropa que no nesecita estrictamente de cuidado riguroso de temperatura o lugar de reposo para su correcta presentacion al usuario" +
                                                        "\nEspecial=Ropa que nesecita estrictamente de cuidado riguroso de temperatura o lugar de reposo para su correcta presentacion al usuario","MOVIMIENTO ROPA",JOptionPane.QUESTION_MESSAGE);
        control.agregarRopa(idPrenda, categoria, descripcion, talla, precioVentaSugerido, cantidad, costoAdquisicion, color, calidadRopa);
    }
    public void realizarMovimiento(){
        String idBodega = JOptionPane.showInputDialog(null, "Id bodega: ","REALIZAR MOVIMIENTO",JOptionPane.QUESTION_MESSAGE);
        String tipoMovimiento = JOptionPane.showInputDialog(null, "Tipo de movimiento[Entrada/Salida]: ","REALIZAR MOVIMIENTO",JOptionPane.QUESTION_MESSAGE);
        if (tipoMovimiento.equalsIgnoreCase("Entrada")) {
            registrarRopa();
        } else if(tipoMovimiento.equalsIgnoreCase("Salida")){
            String idRopa = JOptionPane.showInputDialog(null, "Id ropa: ","REALIZAR MOVIMIENTO",JOptionPane.QUESTION_MESSAGE);
            String cantidad = JOptionPane.showInputDialog(null, "Cantidad ropa: ","REALIZAR MOVIMIENTO",JOptionPane.QUESTION_MESSAGE);
            String costoUnitario = JOptionPane.showInputDialog(null, "Costo unitario: ","REALIZAR MOVIMIENTO",JOptionPane.QUESTION_MESSAGE);
            control.agregarDetalleMovimiento(idBodega, idRopa, tipoMovimiento, cantidad, costoUnitario);
        }
        control.agregarDetalleMovimiento(idBodega, tipoMovimiento, cantidad, costoAdquisicion, tipoMovimiento);

}
}