package org.uv.bdncpractica01;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity(name="producto")
public class PojoProducto implements Serializable{
    @Id
    @Column(name= "idproducto")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name ="producto_idProducto_seq",
            sequenceName = "producto_idProducto_seq",
            initialValue=1,
            allocationSize=1)
    private long id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precioventa")
    private double precioVenta;
    @Column(name = "preciocompra")
    private double precioCompra;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }
    
}
