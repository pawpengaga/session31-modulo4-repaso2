package servicios;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import interfaces.IPaciente;
import modelos.Paciente;

public class PacienteService implements IPaciente {

  private Map<Integer, Paciente> pacientes = new HashMap<>();

  @Override
  public void agregarPaciente(Paciente paciente) {
    // En este caso vamos a evitar parar el programa
    if(pacientes.containsKey(paciente.getIdPac())){
      System.out.println("El ID ya esta registrado.");
    } else {
      pacientes.put(paciente.getIdPac(), paciente);
      System.out.println("Paciente registrado exitosamente!");
    }
  }

  @Override
  public Paciente buscarPaciente(int id) {

    Paciente paciente = pacientes.get(id);

    if (paciente == null) {
      System.out.println("El ID no esta registrado");
      return null;
    }

    return paciente;

  }

  @Override
  public Collection<Paciente> listarPacientes() {
    return pacientes.values();
  }

  @Override
  public void actualizarPaciente(Paciente paciente) {
    // Condicion inversa que al crear
    if(pacientes.containsKey(paciente.getIdPac())){
      pacientes.put(paciente.getIdPac(), paciente);
      System.out.println("Paciente actualizado exitosamente!");
    } else {
      System.out.println("El ID no esta registrado.");
    }
  }

  @Override
  public void eliminarPaciente(int id) {
    if(pacientes.containsKey(id)){
      pacientes.remove(id);
      System.out.println("Paciente ELIMINADO exitosamente!");
    } else {
      System.out.println("El ID no esta registrado.");
    }
  }

}
