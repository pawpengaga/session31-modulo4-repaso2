package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import interfaces.IEspecialidad;
import modelos.Especialidad;
import servicios.EspecialidadService;

@DisplayName("Verifica las especialidades")
public class EspecialidadServiceTest {

  private IEspecialidad espService;

  @BeforeEach
  public void setUp(){
    espService = new EspecialidadService();
  }

  @Test
  @DisplayName("Test agrega especialidad")
  public void testAgregarEspecialidad(){
    // Creamos la especialidad
    Especialidad esp = new Especialidad(1, "Cardiologia");
    // Agregamos la especialidad al hashMap de especialidades
    espService.agregarEspecialidad(esp);

    assertEquals(1, espService.listarEspecialidades().size());
    assertEquals("Cardiologia", espService.obtenerEspecialidad(1).getNombre());


  }

  @Test
  @DisplayName("Test busca especialidad")
  public void testBuscaEspecialidad(){
    Especialidad esp = new Especialidad(2, "Pediatria");
    espService.agregarEspecialidad(esp);

    // Se prueba la busqueda
    Especialidad buscado = espService.obtenerEspecialidad(2);

    // Si es nulo significa que no encontro nada
    assertNotNull(buscado);

    // Ok, encontraste algo, que encontraste
    assertEquals("Pediatria", buscado.getNombre());
    assertEquals("Pediatria", espService.obtenerEspecialidad(2).getNombre());


  }

  


}
