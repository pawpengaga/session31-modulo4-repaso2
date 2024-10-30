package servicios;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import interfaces.IEspecialidad;
import modelos.Especialidad;

public class EspecialidadService implements IEspecialidad {

  private Map<Integer, Especialidad> especialidades = new HashMap<>();

  @Override
  public void agregarEspecialidad(Especialidad especialidad) {
    if(especialidades.containsKey(especialidad.getIdEspecialidad())){
      System.out.println("El ID ya esta registrado.");
    } else {
      especialidades.put(especialidad.getIdEspecialidad(), especialidad);
      System.out.println("Especialidad registrada exitosamente!");
    }
  }

  @Override
  public Especialidad obtenerEspecialidad(int id) {
    Especialidad especialidad = especialidades.get(id);
    if (especialidad == null) {
      System.out.println("El ID no esta registrado");
      return null;
    }

    return especialidad;

  }

  @Override
  public Collection<Especialidad> listarEspecialidades() {
    return especialidades.values();

  }

  @Override
  public void actualizarEspecialidad(Especialidad especialidad) {
    Especialidad nuevaEsp = especialidades.get(especialidad.getIdEspecialidad());
    if (nuevaEsp == null) {
      System.out.println("El ID no esta registrado");
    } else {
      especialidades.put(especialidad.getIdEspecialidad(), especialidad);
    }
  }

  @Override
  public void eliminarEspecialidad(int id) {
    if(especialidades.containsKey(id)){
      especialidades.remove(id);
      System.out.println("Especialidad ELIMINADA exitosamente!");
    } else {
      System.out.println("El ID no esta registrado.");
    }
  }

}
