
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
        System.out.println(categorias);
        return categorias;
    }
    
}
