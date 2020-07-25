/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 * @author Sebastian Uyaguri
 * @author Denys Dutan
 * @author John Fárez
 * @Santiago Cabrera
 */
public class Factura {

    private int numeroDeFactura;
    private int cantidadVendida;
    private Cliente cliente;
    private Producto producto;
    private Bodega bodega;

    public Factura(int numeroDeFactura, int cantidadVendida) {
        this.numeroDeFactura = numeroDeFactura;
        this.cantidadVendida = cantidadVendida;
    }

    public int getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(int numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        hash = 41 * hash + this.numeroDeFactura;
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
        final Factura other = (Factura) obj;
        if (this.numeroDeFactura != other.numeroDeFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + "numeroDeFactura=" + numeroDeFactura + ", cantidadVendida=" + cantidadVendida + ", cliente=" + cliente + ", producto=" + producto + ", bodega=" + bodega + '}';
    }

}
