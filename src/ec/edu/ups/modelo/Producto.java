/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 *
 * @author Dutan2000
 */
public class Producto {
    private String codigo;
    private String nombreDeProducto;
    private double precioDeProdcuto;
    private int cantidad;
    private Bodega bodega;
    

    public Producto() {
    }

    public Producto(String codigo, String nombreDeProducto, double precioDeProdcuto, int cantidad) {
        this.codigo = codigo;
        this.nombreDeProducto = nombreDeProducto;
        this.precioDeProdcuto = precioDeProdcuto;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreDeProducto() {
        return nombreDeProducto;
    }

    public void setNombreDeProducto(String nombreDeProducto) {
        this.nombreDeProducto = nombreDeProducto;
    }

    public double getPrecioDeProdcuto() {
        return precioDeProdcuto;
    }

    public void setPrecioDeProdcuto(double precioDeProdcuto) {
        this.precioDeProdcuto = precioDeProdcuto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombreDeProducto=" + nombreDeProducto + ", precioDeProdcuto=" + precioDeProdcuto + '}';
    }
    
    
}
