
package io.elpoeta.democrud.service;

import io.elpoeta.democrud.domain.Categoria;
import java.util.List;

/**
 *
 * @author elPoeta
 */

/** Esta es la interfaz (contrato) de un componente de la capa de lógica de negocio.
 * Contiene las operaciones que la capa de lógica de negocio expone para operar
 * con instancias de Categoria.
 */


public interface CategoriaService {

 Categoria buscarPorId(Long id);

 List<Categoria> buscarTodas();
    
}
