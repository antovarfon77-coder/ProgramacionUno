package model;

public class Trabajador {
    private String idTrabajdor;
    private String nombreTrabajador;
    private String telefonoTrabajador;
    private String cargoTrabajador;
    private String turnoLaboral;
    
    public Trabajador(String idTrabajador, String nombreTrabajador,String telefonoTrabajador, String cargoTrabajador, String turnoLaboral) {
        this.idTrabajdor=idTrabajador;
        this.nombreTrabajador=nombreTrabajador;
        this.telefonoTrabajador=telefonoTrabajador;
        this.cargoTrabajador = cargoTrabajador;
        this.turnoLaboral = turnoLaboral;
        
    }
    
    public String getIdTrabajador() {
        return idTrabajdor;
    }
    public void setIdTrabajador(String idTrabajdor) {
        this.idTrabajdor = idTrabajdor;
    }
    public String getNombreTrabajador() {
        return nombreTrabajador;
    }
    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }
    public String getTurnoLaboral() {
        return turnoLaboral;
    }
    public void setTurnoLaboral(String turnoLaboral) {
        this.turnoLaboral = turnoLaboral;
    }
    
    public String mostrarTrabajador() {
        return "ID: " + idTrabajdor + 
                " | Nombre: " + nombreTrabajador + 
                " | Teléfono: " + telefonoTrabajador + 
                " | Cargo: " +cargoTrabajador + 
                " | Turno: " + turnoLaboral;
    }
    
}
