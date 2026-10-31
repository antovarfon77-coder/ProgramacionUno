package model;

public class Proveedor {
    private String proveedorNIT;
    private String nombreProveedor;
    private String telefonoContactoProveedor;
    private String correoProveedor;
    
    
    public Proveedor(String proveedorNIT, String nombreProveedor, String telefonoContactoProveedor,
            String correoProveedor) {
        this.proveedorNIT = proveedorNIT;
        this.nombreProveedor = nombreProveedor;
        this.telefonoContactoProveedor = telefonoContactoProveedor;
        this.correoProveedor = correoProveedor;
    }
    public String mostrarProveedor(){
        return "\n | NIT: "+proveedorNIT+
                "\n | Nombre: "+nombreProveedor+
                "\n | Telefono: "+telefonoContactoProveedor+
                "\n | Correo electronico: "+correoProveedor;
    }
    public String getProveedorNIT() {
        return proveedorNIT;
    }
    public void setProveedorNIT(String proveedorNIT) {
        this.proveedorNIT = proveedorNIT;
    }
    public String getNombreProveedor() {
        return nombreProveedor;
    }
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    public String getTelefonoContactoProveedor() {
        return telefonoContactoProveedor;
    }
    public void setTelefonoContactoProveedor(String telefonoContactoProveedor) {
        this.telefonoContactoProveedor = telefonoContactoProveedor;
    }
    public String getCorreoProveedor() {
        return correoProveedor;
    }
    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }
    
    
}
