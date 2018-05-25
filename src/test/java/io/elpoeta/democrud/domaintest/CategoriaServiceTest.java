package io.elpoeta.democrud.domaintest;

import io.elpoeta.democrud.DemoSpringbootCrudApplication;
import io.elpoeta.democrud.domain.Categoria;
import io.elpoeta.democrud.service.CategoriaService;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author elPoeta
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoSpringbootCrudApplication.class)
public class CategoriaServiceTest {
    @Autowired
    private CategoriaService categoriaService;
    
    @Test
    public void busacarPorId_conIdExistente_retornaCategoriaConEseId(){
        Long id = 1L;
        
        Categoria categoria = categoriaService.buscarPorId(id);
        
        assertThat(categoria).isNotNull();
        assertThat(categoria.getId()).isEqualTo(id);
     
    }
    
    @Test
    public void busacarPorId_conIdInexistente_retornaNull(){
        Long id = 93L;
        
        Categoria categoria = categoriaService.buscarPorId(id);
       
        assertThat(categoria).isNull();
    }
    
    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void buscarPorId_conIdNull_lanzaExcepcion() {
        categoriaService.buscarPorId(null);
        fail("Debería haberse lanzado una excepción.");
    }
    
    @Test
    public void buscarTodas_retornaColeccionDeCategorias(){
        List<Categoria> categorias = categoriaService.buscarTodas();
        assertThat(categorias).isNotEmpty();
    }
}    