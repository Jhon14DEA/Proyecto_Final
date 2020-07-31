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
    
    
    private int numeroDeFactura;
    private int cantidadVendida;
    private boolean estado;
    private double subtotal;
    private double iva;
    private double total;
    private Cliente cliente;
    private Producto producto;
    
    /**
     * Constructor.
     * 
     * se instancion un constructor vacio.
     */
    public Factura() {
    }
    /**
     * En este constructor se instanció todos los atributos de la clase Factura
     * a excepción de los dos objetos: cliente y producto. 
     * 
     * @param numeroDeFactura.
     * @param cantidadVendida.
     * @param estado.
     * @param subtotal.
     * @param iva.
     * @param total.
     * @param cedula.
     * @param codigoProducto .
     */
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
    /**
     * En este constructor se instanció todos los atributos de la clase Factura 
     * incluiendo los objetos Producto y Cliente.
     * 
     * @param numeroDeFactura.
     * @param cantidadVendida.
     * @param estado.
     * @param subtotal.
     * @param iva.
     * @param total.
     * @param cliente.
     * @param producto. 
     */
    public Factura(int numeroDeFactura, int cantidadVendida, boolean estado, double subtotal, double iva, double total, Cliente cliente, Producto producto) {
        this.numeroDeFactura = numeroDeFactura;
        this.cantidadVendida = cantidadVendida;
        this.estado = estado;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.cliente = cliente;
        this.producto = producto;
    }
    
    
    
    /**
     * Getters y setters.
     * 
     * se instanciaron todos los getters y setters para los atributos de la clase 
     * factura.
     * @return int numeroDeFactura.
     */
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
    
    /**
     * HashCode y equals.
     * 
     * Se instanció el metodo hashcode y equals para darle un valor unico 
     * al numero de la factura. 
     * 
     * 
     */
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
