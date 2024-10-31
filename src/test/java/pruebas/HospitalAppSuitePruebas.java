package pruebas;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
  EspecialidadServiceTest.class,
  DoctorServiceTest.class,
  PacienteServiceTest.class
})

public class HospitalAppSuitePruebas {

}
