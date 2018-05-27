
package io.elpoeta.democrud.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

/**
 *
 * @author elPoeta
 */

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String modelo;
    private BigDecimal precio;
    private int stock;
    private String descripcion;
    private String urlImagen;
    @ManyToOne
    private Categoria categoria;
    @Transient
    private BigDecimal precioPesos;

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
        this.setPrecioPesos();
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecioPesos() {
        return precioPesos;
    }

    @PostLoad
    private void setPrecioPesos() {
        this.precioPesos = this.precio.multiply(new BigDecimal(25.3))
                               .setScale(2, BigDecimal.ROUND_FLOOR);
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", modelo=" + modelo + ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + ", urlImagen=" + urlImagen + ", categoria=" + categoria + ", precioPesos=" + precioPesos + '}';
    }

   
    
}
