package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import interfaces.IPaciente;
import modelos.Doctor;
import modelos.Paciente;
import servicios.PacienteService;

@DisplayName("Test de clase de servicio de pacientes")
public class PacienteServiceTest {

  private IPaciente pacService;
  private Doctor doctor;

  @BeforeEach
  @DisplayName("Hacer setup de doctor y servicio de pacientes siempre")
  public void setUp(){
    pacService = new PacienteService();
    doctor = new Doctor(1, "Dr Mario");
  }

  @Test
  @DisplayName("Verifica agregar paciente")
  public void testAgregarPaciente(){
    Paciente paciente = new Paciente(1, "Rhea", doctor);
    pacService.agregarPaciente(paciente);

    assertEquals(1, pacService.listarPacientes().size());
    assertEquals("Rhea", pacService.buscarPaciente(1).getNombre());
  }

  @Test
  @DisplayName("Test busca paciente")
  public void testBuscaPaciente(){
    Paciente paciente = new Paciente(2, "Lucca", doctor);
    pacService.agregarPaciente(paciente);

    Paciente encontrado = pacService.buscarPaciente(2);

    // Si lo encuentra, encontrado no sera nulo!!
    assertNotNull(encontrado);
    // Hay que verificar que el que encontro sea el que corresponde
    assertEquals("Lucca", encontrado.getNombre());
  }

  @Test
  @DisplayName("Test de eliminar un paciente")
  public void testEliminarPaciente(){
    Paciente paciente = new Paciente(3, "Eileen", doctor);
    pacService.agregarPaciente(paciente);

    pacService.eliminarPaciente(3);

    // El paciente fue eliminado, no deberia estar ahi...
    assertNull(pacService.buscarPaciente(3));
  }

  @Test
  @DisplayName("Actualiza")
  public void testActualizarPaciente(){
    Paciente paciente = new Paciente(3, "Eileen", doctor);
    pacService.agregarPaciente(paciente);

    Paciente actualizado = new Paciente(3, "Charot", doctor);
    pacService.actualizarPaciente(actualizado);

    assertEquals("Charot", pacService.buscarPaciente(3).getNombre());
  }

}
