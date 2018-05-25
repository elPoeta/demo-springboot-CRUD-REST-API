
package io.elpoeta.democrud.domaintest;

import io.elpoeta.democrud.DemoSpringbootCrudApplication;
import io.elpoeta.democrud.domain.Producto;
import io.elpoeta.democrud.service.CategoriaService;
import io.elpoeta.democrud.service.ProductoService;
import java.math.BigDecimal;
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
public class ProductoServiceTest {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;  
    
    @Test
    public void buscarPorId_conIdExistente_retornaProductoConEseId(){
        Long id = 1L;
    
        Producto producto = productoService.buscarPorId(id);
        
        assertThat(producto).isNotNull();
        assertThat(producto.getId()).isEqualTo(id);
    }
    
    @Test
    public void buscarPorId_conIdExistente_retornaNull(){
        Long id = 945L;
        
        Producto producto = productoService.buscarPorId(id);
        
        assertThat(producto).isNull();  
    }
    
    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void buscarPorId_conIdNull_lanzaExcepcion() {
        productoService.buscarPorId(null);
        fail("Debería haberse lanzado una excepción.");
    }
    
    @Test
    public void buscarTodos_retornaColeccion(){
        List<Producto> productos = productoService.buscarTodos();
        
        assertThat(productos).isNotEmpty();
    }
    
    @Test
    public void buscarPorCategoria_retornaColecionConEsaCategoria(){
        Long id= 1L;
        List<Producto> productos = productoService.buscarPorCategoria(id);
        assertThat(productos).isNotEmpty();
    }
    
    @Test
    public void buscarPorCategoria_retornaColecionVacia(){
        Long id= 7L;
        List<Producto> productos = productoService.buscarPorCategoria(id);
        assertThat(productos).isEmpty();
    }
    
    @Test
    public void crearProducto_retornaGuardaProductoEnBD(){
              
        Producto p = new Producto();
        p.setNombre("Perl DMPR925SP/C 714");
        p.setCategoria(categoriaService.buscarPorId(3L));
        p.setPrecio(new BigDecimal(1319.58));
        p.setModelo("DMPR925SP/C 714");
        p.setDescripcion("Batería 5 cpos, Decade Maple, Edicion Especial, redo 14x5,5, Slate Galaxy Flake (714)");
        p.setStock(4);
        p.setUrlImagen("/img/guitar1.png");
        
        productoService.crearProducto(p);
        
         Producto producto = productoService.buscarPorId(10L);
        
        assertThat(producto).isNotNull();
        assertThat(producto.getId()).isEqualTo(10L);
        
    }
    @Test
    public void modificarProducto_retornaProductoModificado(){
         Producto producto = productoService.buscarPorId(10L);
         producto.setNombre("MODIFICADO");
         productoService.actualizarProducto(10L,producto);
         producto = productoService.buscarPorId(10L);
         System.out.println(producto.getNombre());
         assertThat(producto.getNombre()).isEqualTo("MODIFICADO");
    }
    
    @Test
    public void eliminarPorId_retornaProductoEliminadoDeBD(){
        Long id = 10L;
        
        productoService.eliminarPorId(id);
        
       Producto producto = productoService.buscarPorId(id);
       
       assertThat(producto).isNull();
    }
}
