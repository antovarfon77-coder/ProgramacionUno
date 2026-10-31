package model;

public class DetalleMovimiento {
    private Bodega bodega;
    private Ropa ropa;
    private TipoMovimiento tipoMovimiento;
    private int cantidad;
    private double costoUnitario;
    
    
    public DetalleMovimiento(Bodega bodega, Ropa ropa,TipoMovimiento tipoMovimiento,int cantidad, double costoUnitario) {
        this.bodega = bodega;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.ropa = ropa;
        this.tipoMovimiento = tipoMovimiento;
    }

    public double calcularSubtotal() {
        return this.cantidad * this.costoUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Ropa getRopa() {
        return ropa;
    }
    public void setRopa(Ropa ropa) {
        this.ropa = ropa;
    }
    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    @Override 
    public String toString() {
        return "  | DetalleMovimiento{" +
                " | cantidad=" + cantidad +
                " | costoUnitario=" + costoUnitario +
                " | ropa=" + ropa.getIdPrenda();
    }

    
    
    
}