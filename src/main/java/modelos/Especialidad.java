package modelos;

public class Especialidad {

  private int idEspecialidad;
  private String nombre;

  public Especialidad(int idEspecialidad, String nombre) {
    this.idEspecialidad = idEspecialidad;
    this.nombre = nombre;
  }

  public int getIdEspecialidad() {
    return this.idEspecialidad;
  }

  public void setIdEspecialidad(int idEspecialidad) {
    this.idEspecialidad = idEspecialidad;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "{" +
      " idEspecialidad='" + getIdEspecialidad() + "'" +
      ", nombre='" + getNombre() + "'" +
      " }";
  }


}
