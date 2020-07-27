/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
* @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class Factura {
    
    /**
     * private int numeroDeFactura; | 4 bytes 
     * private int cantidadVendida; | 4
     * bytes private boolean estado; | 1 byte 
     * private double subtotal; | 8 bytes
     * private double iva; | 8 bytes 
     * private double total; | 8 bytes 
     * private Cliente cliente (cedula)| 10 bytes + 2 bytes 
     * private Producto producto (codigo) | 10 bytes + 2 bytes
     *
     * total= 57 bytes
     * 
     * total detalleOrden = 4+4+10+2 =20 bytes
     * total factura = 4+1+8+8+8+10+2=41 bytes
     */
    
    private int numeroDeFactura;
    private int cantidadVendida;
    private boolean estado;
    private double subtotal;
    private double iva;
    private double total;
    private Cliente cliente;
    private Producto producto;
    
    //utilizamos solamente la cedula del cliente
    //utilizamos solo el codigo del producto y la bodega

    public Factura() {
    }

    public Factura(int numeroDeFactura, int cantidadVendida, boolean estado, double subtotal, double iva, double total, String cedula, String codigoProducto) {
        this.numeroDeFactura = numeroDeFactura;
        this.cantidadVendida = cantidadVendida;
        this.estado = estado;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.cliente.setCedula(cedula);
        this.producto.setCodigo(codigoProducto);
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        return "Factura{" + "numeroDeFactura=" + numeroDeFactura + ", cantidadVendida=" + cantidadVendida + ", estado=" + estado + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", cliente=" + cliente + ", producto=" + producto + '}';
    }

}
