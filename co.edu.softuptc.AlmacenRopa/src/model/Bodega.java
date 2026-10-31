package model;

public class Bodega {
  private String idBodega;
  private String nombre;
  private String ubicacion;
  private String telefonoBodega;
  private int almacenamientoMaximo;
  
  public Bodega(String idBodega, String nombre, String ubicacion,String telefonoBodega, int almacenamientoMaximo) {
    this.idBodega = idBodega;
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.telefonoBodega = telefonoBodega;
    this.almacenamientoMaximo = almacenamientoMaximo;
  }

  public String getIdBodega() {
    return idBodega;
  }
  public void setIdBodega(String idBodega) {
    this.idBodega = idBodega;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getUbicacion() {
    return ubicacion;
  }
  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }
  public int getAlmacenamientoMaximo() {
    return almacenamientoMaximo;
  }
  public void setAlmacenamientoMaximo(int almacenamientoMaximo) {
    this.almacenamientoMaximo = almacenamientoMaximo;
  }

  public String mostrarBodega() {
    return " | ID: " + idBodega + 
            " | Nombre: " + nombre + 
            " | Telefono contacto: "+telefonoBodega+
            " | Ubicación: " + ubicacion + 
            " | Almacenamiento Máximo: " + almacenamientoMaximo;
  }
    
}
