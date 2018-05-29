package io.elpoeta.democrud.service;

import io.elpoeta.democrud.domain.Producto;
import java.util.List;

/**
 *
 * @author elPoeta
 */

/** Esta es la interfaz (contrato) de un componente de la capa de lógica de negocio.
 * Contiene las operaciones que la capa de lógica de negocio expone para operar
 * con instancias de Producto.
 */


public interface ProductoService {

    Producto buscarPorId(Long id);

    List<Producto> buscarTodos();

    List<Producto> buscarPorNombre(String nombre);

    Producto crearProducto(Producto producto);

    Producto actualizarProducto(Long id, Producto producto);

    void eliminarPorId(Long id);

    List<Producto> buscarPorCategoria(Long id);

}
