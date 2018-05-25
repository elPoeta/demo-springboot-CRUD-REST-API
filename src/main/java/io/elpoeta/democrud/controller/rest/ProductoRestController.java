package io.elpoeta.democrud.controller.rest;

import io.elpoeta.democrud.domain.Producto;
import io.elpoeta.democrud.exception.ProductoNoEncontrado;
import io.elpoeta.democrud.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elPoeta
 */
@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {

    private ProductoService productoService;

    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/categoria/{id}")
    public List<Producto> productosPorCategoria(@PathVariable Long id) throws ProductoNoEncontrado {
        List<Producto> productos = id == 0 ? this.productoService.buscarTodos()
                : this.productoService.buscarPorCategoria(id);
        if (productos.isEmpty()) {
            throw new ProductoNoEncontrado("Producto no encontrado");
        }

        return productos;
    }

    @GetMapping("productos/{nombre}")
    public List<Producto> productosPorNombre(@PathVariable String nombre) throws ProductoNoEncontrado {
        List<Producto> productos = this.productoService.buscarPorNombre(nombre);
        if (productos.isEmpty()) {
            throw new ProductoNoEncontrado("Producto no encontrado");
        }

        return productos;
    }

    @GetMapping("/detalles/{id}")
    public Producto DetallesProductos(@PathVariable Long id) throws ProductoNoEncontrado {
        Producto producto = this.productoService.buscarPorId(id);
        if (producto == null) {
            throw new ProductoNoEncontrado("Producto no encontrado");
        }

        return producto;
    }

    @PostMapping("/crear")
    public Producto  crearProducto(@RequestBody Producto producto){
            return this.productoService.crearProducto(producto);            
    }

    @PutMapping("/actualizar/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
       return this.productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        this.productoService.eliminarPorId(id);

    }
}
