/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.*;
import ec.edu.ups.modelo.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dutan2000
 */
public class VentanaListarFacturas extends javax.swing.JInternalFrame {

    private Factura factura;
    private Bodega bodega;
    private Producto producto;
    private Cliente cliente;

    private ControladorFactura controladorfactura;
    private ControladorBodega controladorBodega;
    private ControladorCliente controladorCliente;
    private ControladorProducto controladorProducto;

    /**
     * Creates new form VentanaListarFacturas
     */
    public VentanaListarFacturas(ControladorBodega controladorB, Bodega bodegaV, ControladorCliente controladorC, Cliente clienteV, ControladorFactura controladorF,
            Factura factura, ControladorProducto controladorP, Producto productoV) {
        initComponents();
        controladorBodega = controladorB;
        controladorCliente = controladorC;
        controladorProducto = controladorP;
        controladorfactura = controladorF;
    }

    /**
     * VistaDatosFacturaValida.
     * 
     * Este método actualiza la vista de la tabla para listar todas la facturas
     * que son validas. 
     */
    public void VistaDatosFacturaValida() {
        List<Factura> listaDefacturas = controladorfactura.listarFacturasActivas();

        DefaultTableModel modelo = (DefaultTableModel) tablaDatosFactura.getModel();
        modelo.setRowCount(0);
        tablaDatosFactura.setModel(modelo);
        Object[] fila = new Object[6];
        for (Factura factura : listaDefacturas) {
            fila[0] = factura.getNumeroDeFactura();
            fila[1] = factura.getCliente().getCedula();
            fila[2] = factura.getSubtotal();
            fila[3] = factura.getIva();
            fila[4] = factura.getTotal();
            fila[5] = factura.isEstado();
            modelo.addRow(fila);
        }
        tablaDatosFactura.setModel(modelo);
    }

    /**
     * VistaDatosFacturaAnuladas.
     * 
     * Este método actualiza la vista de la tabla para listar todas la facturas 
     * que no son validas.
     * 
     */
    public void VistaDatosFacturaAnuladas() {
        List<Factura> listaDefacturas = controladorfactura.listarFacturasAnuladas();

        DefaultTableModel modelo = (DefaultTableModel) tablaDatosFactura.getModel();
        modelo.setRowCount(0);
        tablaDatosFactura.setModel(modelo);
        Object[] fila = new Object[6];
        for (Factura factura : listaDefacturas) {
            fila[0] = factura.getNumeroDeFactura();
            fila[1] = factura.getCliente().getCedula();
            fila[2] = factura.getSubtotal();
            fila[3] = factura.getIva();
            fila[4] = factura.getTotal();
            fila[5] = factura.isEstado();
            modelo.addRow(fila);
        }
        tablaDatosFactura.setModel(modelo);
    }

    /**
     * cargarDetalleFactura.
     * 
     * Este método recibe en su parámetro un objeto de tipo entero. Este método 
     * actualiza la tabla de detalles y lista todos los detalles de una factura 
     * en especifica. 
     * 
     * @param factura 
     */
    public void cargarDetalleFactura(int factura) {
        List<Factura> facturas = controladorfactura.buscarDetalleFactura(factura);

        DefaultTableModel modelo = (DefaultTableModel) tablaDetalleFactura.getModel();
        modelo.setRowCount(0);
        tablaDetalleFactura.setModel(modelo);
        Object[] fila = new Object[4];
        for (Factura factura1 : facturas) {
            fila[0] = factura1.getNumeroDeFactura();
            fila[1] = factura1.getCantidadVendida();
            fila[2] = factura1.getProducto().getNombreDeProducto();
            fila[3] = factura1.getProducto().getBodega().getNombre();
            modelo.addRow(fila);
        }
        tablaDetalleFactura.setModel(modelo);
        
    }

    /**
     * limpiar.
     * 
     * Este método ayuda a limpiar todos los contenidos dentro de las cajas de 
     * texto y limpia todos los datos dentro de la tabla de detalles. 
     * 
     */
    public void limpiar() {
        txtCedula.setText("");
        txtnNombre.setText("");
        txtApellido.setText("");
        txtLocal.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");

        DefaultTableModel modelo = (DefaultTableModel) tablaDetalleFactura.getModel();
        modelo.setRowCount(0);
        tablaDetalleFactura.setModel(modelo);
        Object[] fila = new Object[4];
            fila[0] = "";
            fila[1] = "";
            fila[2] = "";
            fila[3] = "";
            modelo.addRow(fila);
        tablaDetalleFactura.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatosFactura = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalleFactura = new javax.swing.JTable();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblLocal = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtnNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtLocal = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        botonListarAnuladas = new javax.swing.JButton();
        botonListarValidas = new javax.swing.JButton();
        botonClear = new javax.swing.JButton();
        botonAnular = new javax.swing.JButton();
        botonVerDetalles = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        tablaDatosFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Factura #", "Cedula", "Sub-Total", "IVA", "Total", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatosFactura);

        tablaDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Factura #", "Cantidad ", "Producto", "Bodega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaDetalleFactura);

        lblCedula.setText("Cedula:");

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        lblLocal.setText("Local:");

        lblDireccion.setText("Direccion:");

        lblTelefono.setText("Telefono:");

        txtnNombre.setEditable(false);

        txtApellido.setEditable(false);

        txtCedula.setEditable(false);

        txtLocal.setEditable(false);

        txtDireccion.setEditable(false);

        txtTelefono.setEditable(false);

        botonListarAnuladas.setText("Listar Anuladas");
        botonListarAnuladas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarAnuladasActionPerformed(evt);
            }
        });

        botonListarValidas.setText("Listar Validas");
        botonListarValidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarValidasActionPerformed(evt);
            }
        });

        botonClear.setText("Clear");
        botonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClearActionPerformed(evt);
            }
        });

        botonAnular.setText("Anular");
        botonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnularActionPerformed(evt);
            }
        });

        botonVerDetalles.setText("Ver");
        botonVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(botonListarAnuladas)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCedula)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDireccion)
                                    .addComponent(lblTelefono))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLocal)
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonListarValidas)
                                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonClear)
                            .addComponent(botonAnular)
                            .addComponent(botonVerDetalles))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(botonAnular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonVerDetalles)
                        .addGap(16, 16, 16)
                        .addComponent(botonClear))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonListarAnuladas)
                    .addComponent(botonListarValidas))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(lblLocal)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombre)
                        .addComponent(lblDireccion)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtnNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblApellido)
                        .addComponent(lblTelefono)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * botonListarAnuladasActionPerformed.
     * 
     * Este evento permite que al presionar el botón listar Anuladas cargue el
     * método de VistaDatosFacturaAnuladas() la cual actualizara la tabla 
     * listando todas las facturas anuladas.
     * 
     * @param evt 
     */
    private void botonListarAnuladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarAnuladasActionPerformed
        VistaDatosFacturaAnuladas();

    }//GEN-LAST:event_botonListarAnuladasActionPerformed

    /**
     * botonListarValidasActionPerformed.
     * 
     * Este evento permite que al presionar el botón listar Validas cargue el
     * método de VistaDatosFacturaValida() la cual actualizara la tabla 
     * listando todas las facturas validas.
     * @param evt 
     */
    private void botonListarValidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarValidasActionPerformed
        VistaDatosFacturaValida();

    }//GEN-LAST:event_botonListarValidasActionPerformed

    /**
     * botonAnularActionPerformed.
     * 
     * Este evento permite que al presionar el botón anular se cargue los datos 
     * de la factura seleccionada en la tabla y anule los datos dentro de esa 
     * factura. 
     * 
     * @param evt 
     */
    private void botonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnularActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "Desea Anular esta Factura?");

        if (respuesta == JOptionPane.YES_OPTION) {
            int filaSelecionada = tablaDatosFactura.getSelectedRow();
            int numeroDeFactura = Integer.parseInt(tablaDatosFactura.getValueAt(filaSelecionada, 0).toString());
            controladorfactura.AnularFacturas(numeroDeFactura);
            VistaDatosFacturaValida();
        }
    }//GEN-LAST:event_botonAnularActionPerformed

    /**
     * botonVerDetallesActionPerformed.
     * 
     * Este evento permite que al seleccionar el botón “ver” se cargue los 
     * detalles de esa factura en los campos de texto y en la tabla de detalles.
     * 
     * @param evt 
     */
    private void botonVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerDetallesActionPerformed
        int filaSelecionada = tablaDatosFactura.getSelectedRow();
        int numeroDeFactura = Integer.parseInt(tablaDatosFactura.getValueAt(filaSelecionada, 0).toString());
        String cedula = tablaDatosFactura.getValueAt(filaSelecionada, 1).toString();
        cliente = controladorCliente.buscarCliente(cedula);
        txtCedula.setText(cliente.getCedula().trim());
        txtnNombre.setText(cliente.getNombre().trim());
        txtApellido.setText(cliente.getApellido().trim());
        txtLocal.setText(cliente.getNombreDelLocal().trim());
        txtDireccion.setText(cliente.getDireccion().trim());
        txtTelefono.setText(cliente.getTelefono().trim());

        cargarDetalleFactura(numeroDeFactura);

    }//GEN-LAST:event_botonVerDetallesActionPerformed

    /**
     * botonClearActionPerformed.
     * 
     * Este evento lo que permite es limpiar los campos de texto y la tabla de 
     * detalles. 
     * 
     * @param evt 
     */
    private void botonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClearActionPerformed
        limpiar();
    }//GEN-LAST:event_botonClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnular;
    private javax.swing.JButton botonClear;
    private javax.swing.JButton botonListarAnuladas;
    private javax.swing.JButton botonListarValidas;
    private javax.swing.JButton botonVerDetalles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tablaDatosFactura;
    private javax.swing.JTable tablaDetalleFactura;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtnNombre;
    // End of variables declaration//GEN-END:variables
}
