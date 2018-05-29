
package io.elpoeta.democrud.repository;

import io.elpoeta.democrud.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author elPoeta
 */

/** Este es una interfaz de acceso a datos, que utiliza Spring Data para
 * implementar el repositorio.
 * Contiene varios métodos heredados, que permiten buscar Categorias por distintos
 * criterios, guardar una categoria, borrarla, etc.
 */


public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
    
}
