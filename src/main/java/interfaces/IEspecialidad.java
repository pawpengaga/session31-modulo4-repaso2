package interfaces;

import modelos.Especialidad;
import java.util.Collection;

public interface IEspecialidad {

  public void agregarEspecialidad(Especialidad especialidad);
  public Especialidad obtenerEspecialidad(int id);
  public Collection<Especialidad> listarEspecialidades();
  public void actualizarEspecialidad(Especialidad especialidad);
  public void eliminarEspecialidad(int id);

}
