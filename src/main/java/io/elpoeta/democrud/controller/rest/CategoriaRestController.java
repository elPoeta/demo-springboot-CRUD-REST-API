
package io.elpoeta.democrud.controller.rest;

import io.elpoeta.democrud.domain.Categoria;
import io.elpoeta.democrud.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elPoeta
 */


/**
 * Este es un controlador de presentación (que se define anotándolo con @RestController),
 * que devuelve JSON al cliente.
 * Estos controladores se utilizan para retornar datos en algún formato que sea
 * fácil de consumir por otro programa (a diferencia de un @Controller de vista,
 * que retorna HTML para que sea visualizado por un ser humano).
 *
 * La anotación @RequestMapping en un método indica que ese método se invoca
 * cuando se recibe una petición HTTP con esa dirección. El método en cuestión
 * devuelve un objeto, que será transformado al formato JSON y retornado al
 * invocante.
 */


@RestController
@RequestMapping("/api/categoria")
public class CategoriaRestController {
    private CategoriaService categoriaService;
    
    @Autowired
    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    @GetMapping("/categorias")
    public List<Categoria> categorias(){
        List<Categoria> categorias = this.categoriaService.buscarTodas();
        return categorias;
    }
    
}
