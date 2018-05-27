
package io.elpoeta.democrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author elPoeta
 */

@Controller
public class ProductoController {
    
    @RequestMapping("/productos")
    public String productos(){
        return "producto";
    }
    
    
}
