package interfaces;

import java.util.Collection;
import modelos.Doctor;

public interface IDoctor {

  public void agregarDoctor(Doctor doctor);
  public Doctor obteneDoctor(int id);
  public Collection<Doctor> listarDoctores();
  public void actualizarDoctor(Doctor doctor);
  public void eliminarDoctor(int id);

}
