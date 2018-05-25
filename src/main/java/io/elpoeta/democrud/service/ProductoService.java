package io.elpoeta.democrud.service;

import io.elpoeta.democrud.domain.Producto;
import java.util.List;

/**
 *
 * @author elPoeta
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
