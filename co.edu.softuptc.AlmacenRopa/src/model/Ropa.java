package model;

public class Ropa {
    
    private String idPrenda;
    private String categoria;
    private String descripcion;
    private String talla;
    private double precioVentaSugerido;
    private int cantidad;
    private double costoAdquisicion;
    private String color;
    private String calidadRopa;
    
    public Ropa(String idPrenda, String categoria, String descripcion, String talla, double precioVentaSugerido, int cantidad, double costoAdquisicion, String color, String calidadRopa) {
        this.idPrenda = idPrenda;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.talla = talla;
        this.precioVentaSugerido = precioVentaSugerido;
        this.cantidad = cantidad;
        this.costoAdquisicion = costoAdquisicion;
        this.color = color;
        this.calidadRopa=calidadRopa;
    }
    
    //getters
    public String getIdPrenda() {
        return idPrenda;
    }


    public String getCategoria() {
        return categoria;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public String getTalla() {
        return talla;
    }


    public double getPrecioVentaSugerido() {
        return precioVentaSugerido;
    }


    public int getCantidad() {
        return cantidad;
    }


    public double getCostoAdquisicion() {
        return costoAdquisicion;
    }


    public String getColor() {
        return color;
    }

    //setters
        public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setTalla(String talla) {
        this.talla = talla;
    }


    public void setPrecioVentaSugerido(double precioVentaSugerido) {
        this.precioVentaSugerido = precioVentaSugerido;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public void setCostoAdquisicion(double costoAdquisicion) {
        this.costoAdquisicion = costoAdquisicion;
    }


    public void setColor(String color) {
        this.color = color;
    }
    
    public void setIdPrenda(String idPrenda) {
        this.idPrenda = idPrenda;
    }

    public String getCalidadRopa() {
        return calidadRopa;
    }

    public void setCalidadRopa(String calidadRopa) {
        this.calidadRopa = calidadRopa;
    }
    @Override 
    public String toString(){
        return "\n | ID: " + idPrenda + 
                "\n | Categoría: " + categoria + 
                "\n | Descripción: " + descripcion + 
                "\n | Talla: " + talla +
                "\n | Precio de Venta Sugerido: " + precioVentaSugerido + 
                "\n | Cantidad: " + cantidad +
                "\n | Costo de Adquisición: " + costoAdquisicion + 
                "\n | Color: " + color;
    }


}
