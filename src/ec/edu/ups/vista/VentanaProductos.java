/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorBodega;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.modelo.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class VentanaProductos extends javax.swing.JInternalFrame {

    private ControladorProducto controladorProducto;
    private ControladorBodega controladorBodega;

    private Producto producto;
    private Bodega bodega;
    //
    private Locale localizacion;
    private ResourceBundle recurso;
    //
    private String alerta05;
    private String alerta06;
    private String alerta07;
    private String alerta08;
    private String alerta09;
    private String alerta010;
    private String alerta011;

    /**
     * Creates new form VentanaProductos
     */
    public VentanaProductos(ControladorProducto controladorP, ControladorBodega controladorB) {
        initComponents();

        controladorProducto = controladorP;
        controladorBodega = controladorB;
        desActivarBotones();
        alerta05 = "Error";
        alerta06 = "Por favor, Llene todos los campos";
        alerta07 = "Por favor, Llene todos los campos";
        alerta08 = "Desea eliminar este telefono?";
        alerta09 = "No se ha encontrado el producto";
        alerta010 = "se encuentra vacio el campo";
        alerta011 = "--SELECCIONE UNA BODEGA--";
    }

    public Locale getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Locale localizacion) {
        this.localizacion = localizacion;
    }

    public ResourceBundle getRecurso() {
        return recurso;
    }

    public void setRecurso(ResourceBundle recurso) {
        this.recurso = recurso;
    }

    public void cambiarIdioma(String idioma, String localizacion) {
        lblGestionProductos.setText(recurso.getString("tlGestionProductos"));
        lblCodigo.setText(recurso.getString("codigo"));
        lblNombreProducto.setText(recurso.getString("nombreProducto"));
        lblStock.setText(recurso.getString("stock"));
        lblCosto.setText(recurso.getString("costo"));
        lblBodega.setText(recurso.getString("bodega"));
        lblIngreseCodigo.setText(recurso.getString("ingreseCodigoProducto"));
        btnBuscar.setText(recurso.getString("buscar"));
        btnNuevoProducto.setText(recurso.getString("nuevo"));
        btnActualizarP.setText(recurso.getString("actualizar"));
        btnEliminarP.setText(recurso.getString("eliminar"));
        btnCancelar.setText(recurso.getString("cancelar"));
        //tabla
        TableColumnModel modelo = tablaDatos.getColumnModel();
        modelo.getColumn(0).setHeaderValue(recurso.getString("codigo"));
        modelo.getColumn(1).setHeaderValue(recurso.getString("nombre"));
        modelo.getColumn(2).setHeaderValue(recurso.getString("PVP"));
        modelo.getColumn(3).setHeaderValue(recurso.getString("stock"));
        modelo.getColumn(4).setHeaderValue(recurso.getString("bodega"));
        //joptaionpane
        alerta05 = recurso.getString("alerta05");
        alerta06 = recurso.getString("alerta01");
        alerta07 = recurso.getString("alerta01");
        alerta08 = recurso.getString("alerta08");
        alerta09 = recurso.getString("alerta09");
        alerta010 = recurso.getString("alerta010");
        alerta011 = recurso.getString("alerta011");

    }

    public void limpiar() {
        txtCodigo.setText("");
        txtNombreP.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        cmbxBodega.setSelectedIndex(0);
    }

    public void actualizarVista() {
        List<Producto> listaDeProductos = controladorProducto.verProductosGeneral();

        DefaultTableModel modelo = (DefaultTableModel) tablaDatos.getModel();
        modelo.setRowCount(0);
        tablaDatos.setModel(modelo);
        Object[] fila = new Object[5];
        for (Producto listaDeProducto : listaDeProductos) {
            fila[0] = listaDeProducto.getCodigo();
            fila[1] = listaDeProducto.getNombreDeProducto();
            fila[2] = listaDeProducto.getPrecioDeProdcuto();
            fila[3] = listaDeProducto.getCantidad();
            fila[4] = listaDeProducto.getBodega().getNombre();
            modelo.addRow(fila);
        }
        tablaDatos.setModel(modelo);
    }

    public void ActivarBotones() {
        btnActualizarP.setEnabled(true);
        btnEliminarP.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnBuscar.setEnabled(true);
        txtBuscar.setEditable(true);
    }

    public void desActivarBotones() {
        btnActualizarP.setEnabled(false);
        btnEliminarP.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnBuscar.setEnabled(false);
        txtBuscar.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        lblBodega = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombreP = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        btnNuevoProducto = new javax.swing.JButton();
        btnActualizarP = new javax.swing.JButton();
        btnEliminarP = new javax.swing.JButton();
        lblStock = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblGestionProductos = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblIngreseCodigo = new javax.swing.JLabel();
        cmbxBodega = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Gestion de productos");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        lblCodigo.setText("Codigo:");

        lblNombreProducto.setText("Nombre Producto");

        lblCosto.setText("Costo:");

        lblBodega.setText("Bodega:");

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecio.setText("0.00");
        txtPrecio.setToolTipText("");

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "P.V.P", "Stock", "Bodega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        btnNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/window_new.png"))); // NOI18N
        btnNuevoProducto.setText("Nuevo");
        btnNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProductoActionPerformed(evt);
            }
        });

        btnActualizarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agt_update_misc.png"))); // NOI18N
        btnActualizarP.setText("Actualizar");
        btnActualizarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPActionPerformed(evt);
            }
        });

        btnEliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnEliminarP.setText("Eliminar");
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });

        lblStock.setText("stock:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/toolbar_find (1).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblGestionProductos.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblGestionProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionProductos.setText("Gestion de Productos");

        lblIngreseCodigo.setText("Ingrese codigo del producto:");

        cmbxBodega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECCIONE UNA BODEGA--" }));
        cmbxBodega.setMaximumSize(new java.awt.Dimension(221, 221));
        cmbxBodega.setMinimumSize(new java.awt.Dimension(221, 27));
        cmbxBodega.setPreferredSize(new java.awt.Dimension(221, 27));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblIngreseCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblGestionProductos)
                        .addGap(164, 164, 164))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreProducto)
                            .addComponent(lblCodigo)
                            .addComponent(lblStock))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreP)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblBodega))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lblCosto)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbxBodega, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevoProducto)
                                .addGap(24, 24, 24)
                                .addComponent(btnActualizarP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(153, 153, 153))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGestionProductos)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(lblCosto)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreProducto)
                    .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBodega)
                    .addComponent(cmbxBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStock)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIngreseCodigo))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminarP)
                        .addComponent(btnActualizarP, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProductoActionPerformed

        if (!txtCodigo.getText().equals("") && !txtNombreP.getText().equals("") && !txtPrecio.getText().equals("")
                && !txtCantidad.getText().equals("") && cmbxBodega.getSelectedIndex() != 0) {
            String codigo = txtCodigo.getText();
            String nombreP = txtNombreP.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            String bodega = cmbxBodega.getSelectedItem() + "";
            controladorProducto.crearNuevoProducto(codigo, nombreP, precio, cantidad, bodega);
            actualizarVista();
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, alerta06, alerta05, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNuevoProductoActionPerformed

    private void btnActualizarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPActionPerformed
        if (!txtCodigo.getText().equals("") && !txtNombreP.getText().equals("") && !txtPrecio.getText().equals("")
                && !txtCantidad.getText().equals("") && cmbxBodega.getSelectedIndex() != 0) {
            String codigo = txtCodigo.getText();
            String nombreP = txtNombreP.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            String bodega = cmbxBodega.getSelectedItem().toString();
            /*System.out.println(codigo);
            System.out.println(nombreP);
            System.out.println(precio);
            System.out.println(cantidad);
            System.out.println(bodega);*/
            controladorProducto.actualizarProducto(codigo, nombreP, precio, cantidad, bodega);
            actualizarVista();
            desActivarBotones();
            btnNuevoProducto.setEnabled(true);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, alerta07, alerta05, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnActualizarPActionPerformed

    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        ActivarBotones();
        btnNuevoProducto.setEnabled(false);
        int filaSelecionada = tablaDatos.getSelectedRow();

        if (filaSelecionada >= 0) {
            String codigo = tablaDatos.getValueAt(filaSelecionada, 0).toString();
            String nombre = tablaDatos.getValueAt(filaSelecionada, 1).toString();
            String precio = tablaDatos.getValueAt(filaSelecionada, 2).toString();
            String cantidad = tablaDatos.getValueAt(filaSelecionada, 3).toString();
            String bodega = tablaDatos.getValueAt(filaSelecionada, 4).toString();

            txtCodigo.setText(codigo);
            txtNombreP.setText(nombre);
            txtCantidad.setText(cantidad);
            txtPrecio.setText(precio);
            List<Bodega> bodegas = controladorBodega.listarBodegas();
            int i = 1;
            for (Bodega bodega1 : bodegas) {
                if (bodega1.getNombre().equals(bodega)) {
                    break;
                }
                i++;
            }
            cmbxBodega.setSelectedIndex(i);
        }

    }//GEN-LAST:event_tablaDatosMouseClicked

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, alerta08);

        if (respuesta == JOptionPane.YES_OPTION) {
            String codigo = txtCodigo.getText();
            controladorProducto.eliminarProducto(codigo);
            actualizarVista();
            limpiar();
            desActivarBotones();
            btnNuevoProducto.setEnabled(true);
        }
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!txtBuscar.getText().equals("")) {
            String buscar = txtBuscar.getText();
            int filas = tablaDatos.getRowCount();
            boolean encontrado = true;

            for (int i = 0; i < filas; i++) {
                String codigo = tablaDatos.getValueAt(i, 0).toString().trim();
                if (buscar.equals(codigo)) {
                    encontrado = false;
                    tablaDatos.setRowSelectionInterval(i, i);
                    break;
                }

            }
            if (encontrado) {
                JOptionPane.showMessageDialog(null, alerta09, alerta05, JOptionPane.ERROR_MESSAGE);

            }
            txtBuscar.setText("");
        } else {
            JOptionPane.showMessageDialog(null, alerta010, alerta05, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        desActivarBotones();
        btnNuevoProducto.setEnabled(true);
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        //actualizarCmbx();
    }//GEN-LAST:event_formFocusGained

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        actualizarCmbx();
        actualizarVista();
        desActivarBotones();
        limpiar();

    }//GEN-LAST:event_formPropertyChange
    public void actualizarCmbx() {
        cmbxBodega.removeAllItems();

        cmbxBodega.addItem(alerta011);
        if (controladorBodega.listarBodegas() == null) {
        } else {
            List<Bodega> bodegas = controladorBodega.listarBodegas();
            for (Bodega bodega1 : bodegas) {
                cmbxBodega.addItem(bodega1.getNombre());
            }
        }

        cmbxBodega.setSelectedIndex(0);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarP;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JComboBox<String> cmbxBodega;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBodega;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblGestionProductos;
    private javax.swing.JLabel lblIngreseCodigo;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblStock;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombreP;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
