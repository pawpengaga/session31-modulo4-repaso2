package vista;

import java.io.IOException;
import java.util.Scanner;
import java.util.Collection;

import excepciones.GenerarArchivoException;
import interfaces.IDoctor;
import interfaces.IEspecialidad;
import modelos.Doctor;
import modelos.Especialidad;
import modelos.Paciente;
import servicios.DoctorService;
import servicios.EspecialidadService;
import servicios.HospitalExportService;
import servicios.PacienteService;

public class HospitalApp {
  public static void main(String[] args) throws GenerarArchivoException, IOException {

    // Hacemos inyeccion de dependencias eeeeeeeeeeeeeeeeeee
    PacienteService pacienteService = new PacienteService();
    // Nomenclatura muy purista
    // IPaciente pacienteService = new PacienteServiceImpl();
    IDoctor doctorService = new DoctorService();
    IEspecialidad especialidadService = new EspecialidadService();

    HospitalExportService export = new HospitalExportService();

    Scanner myscan = new Scanner(System.in);
    boolean salir = false;

    System.out.println("---------------------------------------------------\n");

    do {
      System.out.println("1. Agregar Paciente");
      System.out.println("2. Agregar Doctor");
      System.out.println("3. Agregar Especialidad");
      System.out.println("4. Exportar pacientes");

      System.out.println();

      System.out.println("Ingrese una opcion");
      int opcion = myscan.nextInt();

      switch (opcion){
        case 1:
          System.out.println("Ingrese ID paciente");
          int id = myscan.nextInt();
          myscan.nextLine();
          
          System.out.println("Ingrese nombre del paciente");
          String nombre = myscan.nextLine();

          System.out.println("Id del doctor");
          listarServicios(doctorService.listarDoctores());;
          int idDoc = myscan.nextInt();
          myscan.nextLine();

          Doctor asignado = doctorService.obteneDoctor(idDoc);
          Paciente nuevo = new Paciente(id, nombre, asignado);
          pacienteService.agregarPaciente(nuevo);

          break;

        case 2:
          System.out.println("Ingrese ID doctor");
          int idDocDos = myscan.nextInt();
          System.out.println("Nombre doctor");
          myscan.nextLine();
          String nombreDocDos = myscan.nextLine();

          System.out.println("Ingrese el ID de la especialidad");
          listarServicios(especialidadService.listarEspecialidades()); // Es generico ahora eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
          int idEspe = myscan.nextInt();
          myscan.nextLine();

          Especialidad especc = especialidadService.obtenerEspecialidad(idEspe);

          Doctor nuevoDoc = new Doctor(idDocDos, nombreDocDos);
          nuevoDoc.agregarEspecialidad(especc);
          doctorService.agregarDoctor(nuevoDoc);

          break;

        case 3:
          System.out.println("Ingrese ID especialidad");
          int idEspec = myscan.nextInt();
          myscan.nextLine();

          System.out.println("Nombre especialidad");
          String nomEsp = myscan.nextLine();

          Especialidad esp = new Especialidad(idEspec, nomEsp);
          especialidadService.agregarEspecialidad(esp);

          break;

        case 4:
          export.exportarPacientes(pacienteService);
          break;

        case 5:
          System.out.println("Saliendo...");
          salir = true;
          break;
        
        default:
          System.out.println("Opcion no valida!!!");
      }

    } while (!salir);

    myscan.close();

  }

  /**
   * Listado para todo tipo de Collection entrantes eeeeeeeeeeeeeeeeeeeee
   * @param <T> Generico para las clases dentro de modelo
   * @param servicio_in Coleccion generica
   * 
   */
  public static <T> void listarServicios(Collection<T> servicio_in){
    servicio_in.forEach(System.out::println);
  }
}
