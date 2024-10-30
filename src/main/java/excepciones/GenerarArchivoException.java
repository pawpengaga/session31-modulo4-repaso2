package excepciones;

import java.io.IOException;

public class GenerarArchivoException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  public GenerarArchivoException(String message){
    super(message);
  }


}
