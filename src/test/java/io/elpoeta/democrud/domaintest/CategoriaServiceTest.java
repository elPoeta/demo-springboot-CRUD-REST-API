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


/**
 * Esta clase representa un test de componente. Los tests de componentes se
 * encargan de testear una clase en particular, y todas las dependencias que la
 * misma tiene.
 *
 * Este test comprueba el funcionamiento de la clase CategoriaRepository. Esta clase
 * utiliza Spring Data para acceder a la base de datos. El proyecto utiliza una
 * base de datos en memoria (HSQLDB) que Spring levanta y configura de manera
 * automática. Cuando se crea el contexto de Spring, se levanta esta base de
 * datos y se ejecuta el archivo schema.sql (buscar en  "Other Sources") que
 * crea las tablas CATEGORIA y PRODUCTO, y le inserta datos de prueba.
 *
 * Para ejecutar este test en NetBeans: click derecho > "Test File" (CTRL + F6)
 *
 * Podemos ver que esta clase tiene las siguientes anotaciones:
 *
 * @RunWith(SpringRunner.class): Le indica a JUnit que utilize el Runner de
 * Spring al momento de correr los test (necesario para levantar el contexto de
 * Spring).
 *
 * @SpringBootTest: Si utilizamos una aplicación con Spring Boot, nos da
 * diversas features de Spring Boot (ver Javadoc). Si en la clase
 * ApplicationConfig utilizamos la anotacion @SpringBootApplication, no hace
 * falta pasarle la clase como parámetro
 *
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