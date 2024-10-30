package servicios;

import java.io.FileWriter;
import java.io.IOException;

import excepciones.GenerarArchivoException;
import modelos.Doctor;
import modelos.Especialidad;
import modelos.Paciente;

public class HospitalExportService {

  // Se usa pacienteService porque este puede listar los pacientes
  public void exportarPacientes(PacienteService pacienteService) throws GenerarArchivoException, IOException {
    try(FileWriter writer = new FileWriter("pacientes.csv") ) {
      
      writer.append("Especialidad, Doctor, Paciente\n");

      for (Paciente paciente : pacienteService.listarPacientes()) {
        Doctor doctor = paciente.getDoctor();
        for (Especialidad especialidad : doctor.getEspecialidades()) {
          writer.append(especialidad.getNombre() + ", ")
          .append(doctor.getNombre() + ", ")
          .append(paciente.getNombre() + "\n");
        }
      }

      System.out.println("****************");
      System.out.println("ARCHIVO GENERADO");
      System.out.println("****************");

    } catch (Exception e) {
      throw new GenerarArchivoException("Error al generar archivo: " + e.getMessage());
    }
  }

}
