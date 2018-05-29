
package io.elpoeta.democrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author elPoeta
 */

/**
 * Este objeto de dominio utiliza anotaciones para relacionar la clase y sus
 * atributos con una tabla. JPA (a través de Hibernate) utiliza estas anotaciones
 * para acceder a la base de datos e interactuar con objetos de esta clase.
 */

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }  
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" + "Id=" + Id + ", nombre=" + nombre + '}';
    }
    
    
}
