package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import interfaces.IDoctor;
import modelos.Doctor;
import servicios.DoctorService;

public class DoctorServiceTest {

  private IDoctor docService;

  @BeforeEach
  public void setUp(){
    docService = new DoctorService();
  }

  @Test
  @DisplayName("Verifica agregar doctor")
  public void agregarDoctor(){
    Doctor doc = new Doctor(1, "Dr Popo");
    docService.agregarDoctor(doc);

    // Verificar el tamaño del arreglo
    assertEquals(1, docService.listarDoctores().size());

    // Assert
    assertEquals("Dr Popo", docService.obteneDoctor(1).getNombre());
  }

  @Test
  @DisplayName("Test busqueda de doctor")
  public void testBuscarDoctor(){
    Doctor doc = new Doctor(2, "Dr Jhon");
    docService.agregarDoctor(doc);

    // Este es el metodo que estamos probando
    Doctor buscado = docService.obteneDoctor(2);

    assertNotNull(buscado);
    assertEquals("Dr Jhon", buscado.getNombre());
  }

  @Test
  @DisplayName("Verifica actualizacion de doctor")
  public void testActualizaDoctor(){
    Doctor doc = new Doctor(3, "Dr Mario");
    docService.agregarDoctor(doc);

    Doctor actual = new Doctor(3, "Dr Matasanos");
    docService.actualizarDoctor(actual);

    assertEquals("Dr Matasanos", docService.obteneDoctor(3).getNombre());
  }

  @Test
  @DisplayName("Test eliminar un doctor")
  public void testEliminarDoctor(){
    Doctor doc = new Doctor(4, "Dr Chapatin");
    docService.agregarDoctor(doc);

    docService.eliminarDoctor(4);
    assertNull(docService.obteneDoctor(4));
  }

}
