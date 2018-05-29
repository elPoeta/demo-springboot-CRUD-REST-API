
package io.elpoeta.democrud.repository;


import io.elpoeta.democrud.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author elPoeta
 */

/** Este es una interfaz de acceso a datos, que utiliza Spring Data para
 * implementar el repositorio.
 * Contiene varios métodos heredados, que permiten buscar Productos por distintos
 * criterios, guardar un producto, borrarlo, etc.
 */


public interface ProductoRepository extends CrudRepository<Producto, Long>{
    
    @Query("select p from Producto p where p.categoria.id = ?1")
    List<Producto> findByCategoria(Long id);
    
    List<Producto> findByNombreContainsIgnoreCase(String nombre);
}
