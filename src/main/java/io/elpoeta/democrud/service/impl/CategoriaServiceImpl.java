
package io.elpoeta.democrud.service.impl;

import io.elpoeta.democrud.domain.Categoria;
import io.elpoeta.democrud.repository.CategoriaRepository;
import io.elpoeta.democrud.service.CategoriaService;
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
 * de dominio Categoria.
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
public class CategoriaServiceImpl implements CategoriaService{
    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
    @Override
    public Categoria buscarPorId(Long id) {
       return  this.categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categoria> buscarTodas() {
        List<Categoria> categorias = new ArrayList();
        this.categoriaRepository.findAll().forEach(categorias::add);
        return categorias;
    }
    
}
