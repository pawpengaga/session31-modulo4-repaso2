package interfaces;

// import java.util.List;
import java.util.Collection;
import modelos.Paciente;

public interface IPaciente {

  public void agregarPaciente(Paciente paciente);
  public Paciente buscarPaciente(int id);
  public Collection<Paciente> listarPacientes(); //!!
  public void actualizarPaciente(Paciente paciente);
  public void eliminarPaciente(int id);

}
