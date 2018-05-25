
package io.elpoeta.democrud.repository;


import io.elpoeta.democrud.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author elPoeta
 */
public interface ProductoRepository extends CrudRepository<Producto, Long>{
    
    @Query("select p from Producto p where p.categoria.id = ?1")
    List<Producto> findByCategoria(Long id);
    
    List<Producto> findByNombreContainsIgnoreCase(String nombre);
}
