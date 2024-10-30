package servicios;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import interfaces.IDoctor;
import modelos.Doctor;

public class DoctorService implements IDoctor {

  private Map<Integer, Doctor> doctores = new HashMap<>();

  @Override
  public void agregarDoctor(Doctor doctor) {
    if(doctores.containsKey(doctor.getIdDoc())){
      System.out.println("El ID ya esta registrado.");
    } else {
      doctores.put(doctor.getIdDoc(), doctor);
      System.out.println("Doctor registrado exitosamente!");
    }
  }

  @Override
  public Doctor obteneDoctor(int id) {
    Doctor doctor = doctores.get(id);
    if (doctor == null) {
      System.out.println("El ID no esta registrado");
      return null;
    }

    return doctor;

  }

  @Override
  public Collection<Doctor> listarDoctores() {
    return doctores.values();

  }

  @Override
  public void actualizarDoctor(Doctor doctor) {
    if(doctores.containsKey(doctor.getIdDoc())){
      doctores.put(doctor.getIdDoc(), doctor);
      System.out.println("Doctor actualizado exitosamente!");
    } else {
      System.out.println("El ID no esta registrado.");
    }
  }

  @Override
  public void eliminarDoctor(int id) {
    if(doctores.containsKey(id)){
      doctores.remove(id);
      System.out.println("Doctor ELIMINADO exitosamente!");
    } else {
      System.out.println("El ID no esta registrado.");
    }
  }

}
