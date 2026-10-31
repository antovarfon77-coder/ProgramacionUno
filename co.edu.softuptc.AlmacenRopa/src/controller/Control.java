package controller;
import model.*;

import javax.swing.JOptionPane;

import logic.*;

public class Control {
    BodegasRegistradas bodegaRegistro = new BodegasRegistradas();
    TrabajadoresRegistrados trabajadoresRegistro = new TrabajadoresRegistrados();
    RopaEnEstante ropaRegistro = new RopaEnEstante();
    ProveedoresRegistrados proveedorRegistro = new ProveedoresRegistrados();
    MovimientosRealizados movimientosRealizados = new MovimientosRealizados();
    boolean huboExeception=false;
    //Exceptions
    public boolean salidaRopa(String idRopa, String cantidad){
        try {
            if (buscarRopa(idRopa).getCantidad() < Integer.parseInt(cantidad)) {
                throw new ExceptionSalidaEntradaRopa("");
            
        }
        } catch (ExceptionSalidaEntradaRopa e) {
            huboExeception=true;
        }
        if (huboExeception) {
            return false;
        }
        return true;
    }
    public boolean entradaRopa(String idBodega, String cantidad){
        //capacidad para la entrada
        try {
            if (calcularOcupacionActual(buscarBodega(idBodega)) + Integer.parseInt(cantidad) > buscarBodega(idBodega).getAlmacenamientoMaximo()) {
                throw new ExceptionSalidaEntradaRopa("No se puede realizar esta operacion");
        }
        } catch (ExceptionSalidaEntradaRopa e) {
            e.getMessage();
            huboExeception=true;
        }
        if (huboExeception) {
            return false;
        }
        return true;
        
    }
    public boolean objetoRepetido(String id){
        try {
            if (buscarProveedor(id).getProveedorNIT().equals(id)) {
                throw new ExeceptionObjExistente("Ya existe un proveedor con ese NIT.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            huboExeception=true;
        }
        try {
            if (buscarTrabajador(id).getIdTrabajador().equals(id)) {
                throw new ExeceptionObjExistente("Ya existe un trabajador con ese id.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            huboExeception=true;
        }
        try {
            if (buscarBodega(id).getIdBodega().equals(id)) {
                throw new ExeceptionObjExistente("Ya existe bodega con ese id.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            huboExeception=true;
        }
        if (huboExeception) {
            return false;
        }
        return true;
    }
    public boolean validarCadenaNumeros(String numero){
        try {
            for(int i=0;i<numero.length();i++){
                char caracter = numero.charAt(i);
                if (!Character.isDigit(caracter)) {
                    throw new ExceptionCadenaIncorreta("La cadena contiene caracteres diferentes a numeros.");
                }
            }
        } catch (ExceptionCadenaIncorreta e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            huboExeception=true;
        }
        if (huboExeception) {
            return false;
        }
        return true;
    }
    public boolean validarCadenaLetras(String cadena){
        try{
            for(int i=0; i<cadena.length();i++){
            char caracter = cadena.charAt(i);
            if (!Character.isLetter(caracter)) {
                throw new ExceptionCadenaIncorreta("La cadena contiene caracteres diferentes a las letras.Deben de ser letras");
            }
        }
        } catch(ExceptionCadenaIncorreta e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            huboExeception=true;
        }
        if (huboExeception) {
            return false;
        }
        return true;
    }
    public boolean numeroInvalido(String numero){
        try {
            if (Integer.parseInt(numero) < 0) {
                throw new ExceptionNumeroInvalido("El almacenamiento máximo no puede ser negativo.");
            }
        } catch (ExceptionNumeroInvalido e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            huboExeception=true;
        }
        if (huboExeception) {
            return false;
        }
        return true;
    }
    public boolean atributoVacio(String primitivo){
        try {
            if (primitivo.trim().isEmpty()) {
            throw new ExceptionCadenaIncorreta("No puede pueden atributos vacios.");
        }
        } catch (ExceptionCadenaIncorreta e) {
            e.getMessage();
            huboExeception=true;
        }
        if (huboExeception) {
            return false;
        }
        return true;
    }
    //Agegar elementos(Bodegas, trabajadores, proveedores) a la lista de registros
    public boolean agregarBodega(String idBodega, String nombreBodega, String direccionBodega, String telefonoBodega, String almacenamientoMaximo) {
        //Vacios
        if (!atributoVacio(idBodega) || !atributoVacio(nombreBodega) || !atributoVacio(direccionBodega) || !atributoVacio(telefonoBodega) || !atributoVacio(almacenamientoMaximo)) {
            JOptionPane.showMessageDialog(null, "¡Ninguno de los atributos puede estar vacio!");
        } else {
            //Repeticion bodegas
            objetoRepetido(idBodega);
            //Num almacenamiento
            numeroInvalido(almacenamientoMaximo);
        }
        
        if (!huboExeception) {
            return false;
        }
        //Registro bodega
        Bodega bodega = new Bodega(idBodega, nombreBodega, direccionBodega, telefonoBodega, Integer.parseInt(almacenamientoMaximo));
        bodegaRegistro.agregarBodega(bodega);
        JOptionPane.showMessageDialog(null,"Bodega agregada correctamente.");
        return true;
    }
    public boolean agregarTrabajador(String idTrabajador, String nombreTrabajador, String telefonoTrabajador, String cargoTrabajador, String turnoLaboral) {
        //Vacios
        if (!atributoVacio(idTrabajador) || !atributoVacio(nombreTrabajador) || !atributoVacio(telefonoTrabajador) || !atributoVacio(cargoTrabajador) || !atributoVacio(turnoLaboral)) {
            JOptionPane.showMessageDialog(null, "¡Ninguno de los atributos puede estra vacio!");
        } else {
            //Repeticion
            objetoRepetido(idTrabajador);
            //textos
            validarCadenaLetras(nombreTrabajador);
        }
        
        if (!huboExeception) {
            return false;
        }
        //Agregar
        Trabajador trabajador = new Trabajador(idTrabajador, nombreTrabajador, telefonoTrabajador, cargoTrabajador, turnoLaboral);
        trabajadoresRegistro.agregarTrabajador(trabajador);
        JOptionPane.showMessageDialog(null,"Trabajador agregado correctamente.");
        return true;
    }
    public boolean agregarProveedor(String proveedorNIT, String nombreProveedor, String telefonoContacto, String correoProveedor) {
        
        //Vacios
        if (!atributoVacio(proveedorNIT) || !atributoVacio(nombreProveedor) || !atributoVacio(telefonoContacto) || !atributoVacio(correoProveedor)) {
            JOptionPane.showMessageDialog(null, "Ninguno de los atributos puede estar vacio.");
        } else if(atributoVacio(proveedorNIT)){
            //Repeticion
            objetoRepetido(proveedorNIT);
            //cadena incorreta
            numeroInvalido(proveedorNIT);
        }
        
        
        //validacion
        if (huboExeception) {
            return false;
        }
        //Agregar
        Proveedor proveedor = new Proveedor(proveedorNIT, nombreProveedor, telefonoContacto, correoProveedor);
        proveedorRegistro.agregarProveedor(proveedor);
        JOptionPane.showMessageDialog(null,"Proveedor agregado correctamente.");
        return true;
    }
    public boolean agregarRopa(String idPrenda, String categoria, String descripcion, String talla,
        String precioVentaSugerido, String cantidad, String costoAdquisicion, String color,String calidadRopa) {
        //Vacios
        if (!atributoVacio(idPrenda) || !atributoVacio(categoria) || !atributoVacio(descripcion) || !atributoVacio(talla) || !atributoVacio(calidadRopa)) {
            JOptionPane.showMessageDialog(null, "Ninguno de los atributos puede estar vacio.");
        } else {
            //Precios
            if (!numeroInvalido(precioVentaSugerido) || !numeroInvalido(cantidad)) {
                JOptionPane.showMessageDialog(null, "El precio sugerido ni la cantidad de ropa ingresas puede ser negativo");
            }
        }
        if (huboExeception) {
            return false;
        }
        //Agregar
        Ropa auxRopa = new Ropa(idPrenda, categoria, descripcion, talla, Double.parseDouble(precioVentaSugerido), Integer.parseInt(cantidad), Double.parseDouble(costoAdquisicion), color, calidadRopa);
        ropaRegistro.agregarRopa(auxRopa);
        JOptionPane.showMessageDialog(null,"Ropa agregada correctamente.");
        return true;
    }

    public boolean agregarDetalleMovimiento(String idBodega,String idRopa,String tipoMovimiento, String cantidad, String costoMovimiento) {
        //Vacios
        if (!atributoVacio(idBodega) || !atributoVacio(idRopa) || !atributoVacio(tipoMovimiento) || !atributoVacio(cantidad) || !atributoVacio(costoMovimiento)) {
            JOptionPane.showMessageDialog(null, "Ninguno de los atributos puede estar vacio.");
        } else {
            //Cantidades correctas
            if (!numeroInvalido(costoMovimiento) || !numeroInvalido(cantidad)) {
                JOptionPane.showMessageDialog(null,"La cantidad debe ser mayor a 0 y el costo no puede ser negativo.");
            }
            //capaciadad de la salida
        
            if (tipoMovimiento.equalsIgnoreCase("Entrada")) {
                if (!entradaRopa(idBodega, cantidad)) {
                    JOptionPane.showMessageDialog(null,"Esta entrada supera la capacidad de la bodega " + buscarBodega(idBodega).getNombre() +
                        " (" + calcularOcupacionActual(buscarBodega(idBodega)) + "/" + buscarBodega(idBodega).getAlmacenamientoMaximo() + ")."); 
            } else if(tipoMovimiento.equalsIgnoreCase("Salida")){
                if (!salidaRopa(idRopa, cantidad)) {
                    JOptionPane.showMessageDialog(null,"No hay suficiente stock de " + buscarRopa(idRopa).getIdPrenda() +
                        " para esta salida. Disponible: " + buscarRopa(idRopa).getCantidad());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Solo se pueden realizar movimientos de salida o entrada.");
            }
            }
        }
        //agregar detalle
        
        //Nuevas cantidades
        if (tipoMovimiento.equalsIgnoreCase("Entrada")) {
            buscarRopa(idRopa).setCantidad(buscarRopa(idRopa).getCantidad() +  Integer.parseInt(cantidad));
        } else if (tipoMovimiento.equalsIgnoreCase("Salida")) {
            buscarRopa(idRopa).setCantidad(buscarRopa(idRopa).getCantidad() - Integer.parseInt(cantidad));
        }
        if (!huboExeception) {
            return false;
        }
        //Mostrar informacion
        JOptionPane.showInputDialog(null, "Detalle agregado: " + cantidad + " de " + buscarRopa(idRopa).getIdPrenda() +
                " (" + tipoMovimiento + "). Stock actual: " + buscarRopa(idRopa).getCantidad());
        if (tipoMovimiento.equalsIgnoreCase("Entrada")) {
            DetalleMovimiento auxDetalleMovimientoEntrada = new DetalleMovimiento(buscarBodega(idBodega), buscarRopa(idRopa), TipoMovimiento.ENTRADA, Integer.parseInt(cantidad), Double.parseDouble(costoMovimiento));
            movimientosRealizados.agregarDetalleMovimiento(auxDetalleMovimientoEntrada);
        } else if(tipoMovimiento.equalsIgnoreCase("Salida")){
            DetalleMovimiento auxDetalleMovimientoSalida = new DetalleMovimiento(buscarBodega(idBodega), buscarRopa(idRopa), TipoMovimiento.SALIDA, Integer.parseInt(cantidad), Double.parseDouble(costoMovimiento));
            movimientosRealizados.agregarDetalleMovimiento(auxDetalleMovimientoSalida);
        }
        return true;
    }
    //Validar ocupacion de la bodega
    private int calcularOcupacionActual(Bodega bodega) {
        int auxOcupacion = 0;
        for (DetalleMovimiento auxMovimiento : movimientosRealizados.getMovimientosRealizados()) {
            if (auxMovimiento.getBodega() != null && auxMovimiento.getBodega().getIdBodega().equals(bodega.getIdBodega())) {
                    if (auxMovimiento.getTipoMovimiento().equals(TipoMovimiento.ENTRADA)) {
                        auxOcupacion += auxMovimiento.getCantidad();
                    } else if (auxMovimiento.getTipoMovimiento().equals(TipoMovimiento.SALIDA)) {
                        auxOcupacion -= auxMovimiento.getCantidad();
                    }
            }
        }
        return auxOcupacion;
    }

    //Buscar elementos por ID o NIT
    public Bodega buscarBodega(String auxIdBodega){
        return bodegaRegistro.buscarBodega(auxIdBodega);
    }
    public Ropa buscarRopa (String auxIdArticulo){
        return ropaRegistro.buscarRopa(auxIdArticulo);
    }
    public Proveedor buscarProveedor(String auxEmpresaNIT){
        return proveedorRegistro.buscarProveedor(auxEmpresaNIT);
    }
    public Trabajador buscarTrabajador(String auxIdTrabajador){
        return trabajadoresRegistro.buscarTrabajador(auxIdTrabajador);
    }
    //Mostrar elementos
    public void mostrarBodegas() {
        bodegaRegistro.mostrarBodegas(); 
    }
    public void mostrarRopa() {
        ropaRegistro.mostrarRopa(); 
    }
    public void mostrarMovimientos() {
        movimientosRealizados.mostrarMovimientosRopa();
    }
}
