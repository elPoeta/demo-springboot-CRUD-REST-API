
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
