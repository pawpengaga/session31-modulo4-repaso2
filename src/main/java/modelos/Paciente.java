package modelos;

public class Paciente {

  // El orden es modelo > interfaz > todo lo demas

  private int idPac;
  private String nombre;
  private Doctor doctor;

  public Paciente(int idPac, String nombre, Doctor doctor) {
    super();
    this.idPac = idPac;
    this.nombre = nombre;
    this.doctor = doctor;
  }

  public int getIdPac() {
    return this.idPac;
  }

  public void setIdPac(int idPac) {
    this.idPac = idPac;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Doctor getDoctor() {
    return this.doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  @Override
  public String toString() {
    return "{" +
      " idPac='" + getIdPac() + "'" +
      ", nombre='" + getNombre() + "'" +
      ", doctor='" + getDoctor() + "'" +
      " }";
  }
  
}
