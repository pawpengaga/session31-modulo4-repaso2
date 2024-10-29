package modelos;
import java.util.List;
import java.util.ArrayList;

public class Doctor {

  private int idDoc;
  private String nombre;
  private List<Especialidad> especialidades;

  public Doctor(int idDoc, String nombre) {
    this.idDoc = idDoc;
    this.nombre = nombre;
    this.especialidades = new ArrayList<>();
  }

  // Cada vez que tengamos un arreglo usamos esto
  public void agregarEspecialidad(Especialidad especialidad){
    especialidades.add(especialidad);
  }

  public int getIdDoc() {
    return this.idDoc;
  }

  public void setIdDoc(int idDoc) {
    this.idDoc = idDoc;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Especialidad> getEspecialidades() {
    return this.especialidades;
  }

  public void setEspecialidades(List<Especialidad> especialidades) {
    this.especialidades = especialidades;
  }

  @Override
  public String toString() {
    return "{" +
      " idDoc='" + getIdDoc() + "'" +
      ", nombre='" + getNombre() + "'" +
      ", especialidades='" + getEspecialidades() + "'" +
      " }";
  }



}
