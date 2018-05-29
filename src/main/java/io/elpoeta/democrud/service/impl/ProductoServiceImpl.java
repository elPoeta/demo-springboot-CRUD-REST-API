package io.elpoeta.democrud.service.impl;

import io.elpoeta.democrud.domain.Producto;
import io.elpoeta.democrud.repository.ProductoRepository;
import io.elpoeta.democrud.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author elPoeta
 */

/**
 * Esta es la clase de negocio que expone operaciones relacionadas con el objeto
 * de dominio Producto.
 *
 * La anotación @Service es de Spring, y le indica a Spring que esta clase
 * deberá ser tratada como clase de servicios. Spring registrará esta clase para
 * ser inyectada en donde sea necesario.
 *
 * La anotación @Transactional indica que todos los métodos de esta clase
 * deberán ser transaccionales (necesario para JPA).
 *
 * El constructor de esta clase recibe su dependencia obligatoria. Esto le
 * indica a Spring que para constuir una instancia de esta clase deberá primero
 * conseguir una instancia de su dependencia.
 *
 */


@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto buscarPorId(Long id) {
        return this.productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> buscarTodos() {
        List<Producto> productos = new ArrayList();
        this.productoRepository.findAll().forEach(productos::add);
        return productos;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return this.productoRepository.save(producto);
    }

    @Override
    public void eliminarPorId(Long id) {
        this.productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> buscarPorCategoria(Long id) {
        return this.productoRepository.findByCategoria(id);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return this.productoRepository.findByNombreContainsIgnoreCase(nombre);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        return this.productoRepository.save(producto);
    }

}
