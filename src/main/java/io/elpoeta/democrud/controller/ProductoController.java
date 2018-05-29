
package io.elpoeta.democrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author elPoeta
 */


/**
 * Este es un controlador de presentación (que se define anotándolo con
 * @Controller). Se encarga de atender peticiones HTTP y devolver una vista para
 * que muestre HTML al cliente.
 *
 * La anotación @RequestMapping en un método indica que ese método se invoca
 * cuando se recibe una petición HTTP con esa dirección. El método en cuestión
 * devuelve un Sring, que representa la vista (página HTML).
 */


@Controller
public class ProductoController {
    
    @RequestMapping("/productos")
    public String productos(){
        return "producto";
    }
    
    
}
