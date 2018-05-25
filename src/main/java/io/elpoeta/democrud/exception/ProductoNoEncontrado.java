
package io.elpoeta.democrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author elPoeta
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductoNoEncontrado extends Exception{

    public ProductoNoEncontrado(String message) {
        super(message);
    }  
}
