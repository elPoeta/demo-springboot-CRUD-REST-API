
package io.elpoeta.democrud.service;

import io.elpoeta.democrud.domain.Categoria;
import java.util.List;

/**
 *
 * @author elPoeta
 */
public interface CategoriaService {

 Categoria buscarPorId(Long id);

 List<Categoria> buscarTodas();
    
}
