/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.modelo.Cliente;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class VentanaCliente extends javax.swing.JInternalFrame {

    private String alertaBusqueda;
    private String alertano;
    private String alertaLlene;
    private String alertaActu;
    private String alertaNoAc;
    private String alertaCed;
    private String alertaEl;
    private String alertaNoEli;
    private String alertanoRegistrado;
    
    ControladorCliente controladorCliente;
    DefaultTableModel modelo;
    private ResourceBundle recurso;
    private Locale localizacion;
    
    

    
    /**
     * Creates new form VentanaCliente
     */
    
    
    public VentanaCliente(ControladorCliente controladorCliente) {
        initComponents();

        this.controladorCliente = controladorCliente;
        
        
        alertaBusqueda =  "LLene el campo de busqueda";
        alertano = "Cliente no registrado";
        alertaLlene = "Llene todos los campos";
        alertaActu = "Se a actualizado con exito";
        alertaNoAc = "No se a actualizado con exito";
        alertaCed = "ingrese la cedula";
        alertaEl = "Se a eliminado con exito";
        alertaNoEli = "No se a eliminado";
        alertanoRegistrado = "No se registraron datos";
        
        
        botones();
        editables();
    }

    public JLabel getGestionClientes() {
        return lblGestionClientes;
    }

    public JLabel getCedula() {
        return lblCedula;
    }

    public JButton getBotonBuscar() {
        return btnBuscar;
    }

    public JLabel getInformacion() {
        return lblInformacion;
    }

    public JLabel getCedulaa() {
        return lblCedulaa;
    }

    public JLabel getNombre() {
        return lblNombre;
    }

    public JLabel getApellido() {
        return lblApellido;
    }

    public JLabel getNombreLocal() {
        return lblNombreLocal;
    }

    public JLabel getTelefono() {
        return lblTelefono;
    }

    public JLabel getDireccion() {
        return lblDireccion;
    }

    public JButton getBotonActualizar() {
        return btnActualizarCliente;
    }

    public JButton getBotonCancelar() {
        return btnCancelarCliente;
    }

    public JButton getBotonEliminar() {
        return btnEliminarCliente;
    }

    public JButton getListar() {
        return btnListarClientes;
    }

    public JButton getLimpiar() {
        return btnLimpiar;
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

        // Inter.... para la tabla de datos

        TableColumnModel modelo = tblCliente.getColumnModel(); 
        modelo.getColumn(0).setHeaderValue(recurso.getString("Cedula"));
        modelo.getColumn(1).setHeaderValue(recurso.getString("Nombre"));
        modelo.getColumn(2).setHeaderValue(recurso.getString("Apellido"));
        modelo.getColumn(3).setHeaderValue(recurso.getString("NombreLocal"));
        modelo.getColumn(4).setHeaderValue(recurso.getString("Telefono"));
        modelo.getColumn(5).setHeaderValue(recurso.getString("Direccion"));
     //  alerta029 = recurso.getString("alerta029");
     
        alertaBusqueda =  recurso.getString("alertaBusqueda");
        alertano = recurso.getString("alertano");
        alertaLlene = recurso.getString("alertaLlene");
        alertaActu = recurso.getString("alertaActu");
        alertaNoAc = recurso.getString("alertaNoAc");
        alertaCed =recurso.getString("alertaCed");
        alertaEl = recurso.getString("alertaEl");
        alertaNoEli = recurso.getString("alertaNoEli");
        alertanoRegistrado = recurso.getString("alertanoRegistrado");
        

    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        txtBuscarCliente = new javax.swing.JTextField();
        lblInformacion = new javax.swing.JLabel();
        txtCedulaCliente = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellidoCliente = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccionCliente = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnCancelarCliente = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnListarClientes = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        txtTelefonoCliente = new javax.swing.JFormattedTextField();
        lblGestionClientes = new javax.swing.JLabel();
        lblNombreLocal = new javax.swing.JLabel();
        txtNombreLocalCliente = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        lblCedulaa = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Gestion de clientes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        lblCedula.setText("Cedula:");

        lblInformacion.setText("Informacion del cliente");

        txtCedulaCliente.setText(" ");

        lblNombre.setText("Nombre");

        lblApellido.setText("Apellido");

        lblDireccion.setText("Direccion");

        lblTelefono.setText("Telefono");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Nombre Local", "Telefono", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        btnCancelarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/no (1).png"))); // NOI18N
        btnCancelarCliente.setText("Cancelar");
        btnCancelarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarClienteActionPerformed(evt);
            }
        });

        btnActualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agt_update_misc.png"))); // NOI18N
        btnActualizarCliente.setText("Actualizar");
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/toolbar_find (1).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnListarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/list.png"))); // NOI18N
        btnListarClientes.setText("Listar todo");
        btnListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarClientesActionPerformed(evt);
            }
        });

        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        lblGestionClientes.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblGestionClientes.setText("Gestion de Clientes");

        lblNombreLocal.setText("Nombre Local");

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_clear (1).png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lblCedulaa.setText("Cedula");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblInformacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblCedula)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDireccion)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblNombre)
                                    .addComponent(lblApellido)
                                    .addComponent(lblNombreLocal)
                                    .addComponent(lblCedulaa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTelefonoCliente)
                                        .addComponent(txtApellidoCliente)
                                        .addComponent(txtNombreCliente)
                                        .addComponent(txtCedulaCliente)
                                        .addComponent(txtNombreLocalCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(lblGestionClientes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnActualizarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnListarClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarCliente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGestionClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInformacion)
                    .addComponent(btnLimpiar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedulaa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido)
                            .addComponent(txtApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreLocal)
                            .addComponent(txtNombreLocalCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDireccion)
                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    /**
     * Metodo tblClienteMouseClicked.
     *
     * Al hacer click sobre alguna fila de la tabla, esta recupera los datos
     * guardados en esa fila y le asigna a los JTextField correspondientes
     * habilitando los botones de eliminar, actualizar, cancelar.
     *
     * @param evt Evento
     */
    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        int fila = tblCliente.getSelectedRow();

        String cedula = (String) tblCliente.getValueAt(fila, 0);
        String nombre = (String) tblCliente.getValueAt(fila, 1);
        String apellido = (String) tblCliente.getValueAt(fila, 2);
        String nombreLocal = (String) tblCliente.getValueAt(fila, 3);
        String teledono = (String) tblCliente.getValueAt(fila, 4);
        String direccion = (String) tblCliente.getValueAt(fila, 5);

        txtCedulaCliente.setText(cedula);
        txtNombreCliente.setText(nombre);
        txtApellidoCliente.setText(apellido);
        txtNombreLocalCliente.setText(nombreLocal);
        txtTelefonoCliente.setText(teledono);
        txtDireccionCliente.setText(direccion);

        txtNombreCliente.setEditable(true);
        txtApellidoCliente.setEditable(true);
        txtNombreLocalCliente.setEditable(true);
        txtTelefonoCliente.setEditable(true);
        txtDireccionCliente.setEditable(true);

        btnActualizarCliente.setEnabled(true);
        btnCancelarCliente.setEnabled(true);
        btnEliminarCliente.setEnabled(true);
    }//GEN-LAST:event_tblClienteMouseClicked

    /**
     * Metodo btnListarClientesActionPerformed.
     *
     * Lista todos los clientes registrados llamando al metodo LlenarDatosTabla
     *
     * @param evt Evento
     */
    private void btnListarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarClientesActionPerformed
        llenarDatosTabla();
    }//GEN-LAST:event_btnListarClientesActionPerformed

    /**
     * Metodo btnBuscarClienteActionPerformed.
     *
     * Al presionar el boton de buscar, recupra la informacion del JTextField
     * buscarCliente donde le envia al controlador y luego retornar el cliente y
     * mostrar en el clliente encontrado en la tabla.
     *
     * @param evt
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String cedula = txtBuscarCliente.getText();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, alertaBusqueda);
            limpiarTabla();
        } else {
            Cliente cliente = controladorCliente.buscarCliente(cedula);
            if (cliente != null) {
                listarCliente(cliente);
            } else {
                JOptionPane.showMessageDialog(this, alertano);
                limpiarTabla();
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Metodo btnActualizarClienteActionPerformed.
     *
     * Al presionar el boton este reupera la informacion de los JTextField y
     * actualiza el cliente enviando al controldor.
     *
     * @param evt Evento
     */
    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        String cedula = txtCedulaCliente.getText();
        String nombre = txtNombreCliente.getText();
        String apellido = txtApellidoCliente.getText();
        String nombreLocal = txtNombreLocalCliente.getText();
        String telefono = txtTelefonoCliente.getText();
        String direccion = txtDireccionCliente.getText();

        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || nombreLocal.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, alertaLlene);
        } else {
            Cliente cliente = new Cliente(cedula, nombre, apellido, nombreLocal, telefono, direccion);
            boolean cent = controladorCliente.actualizarCliente(cliente);
            if (cent == true) {
                JOptionPane.showMessageDialog(this, alertaActu);
                listarCliente(cliente);
                limpiar();
                botones();
                editables();
            } else {
                JOptionPane.showMessageDialog(this, alertaNoAc);
            }
        }
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    /**
     * Metodo btnLimpiarActionPerformed.
     *
     * Al presionar el boton este borra toda la informacion de la interfaz, con
     * ayuda de los metodos limpiar, botones, editables y limpiezaTabla.
     *
     * @param evt Evento
     */
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        botones();
        editables();
        limpiarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * Metodo btnCancelarClienteActionPerformed.
     *
     * El metodo realiza la accion de quitar la seleccion del jTable y borrar la
     * informacion de todos los JTextField ademas vuelve a desabilitar los
     * botones.
     *
     * @param evt Evento
     */
    private void btnCancelarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarClienteActionPerformed
        botones();
        editables();
        limpiar();
        tblCliente.clearSelection();
    }//GEN-LAST:event_btnCancelarClienteActionPerformed

    /**
     * Metodo btnEliminarClienteActionPerformed.
     *
     * Este metodo al hacer click el boton de eliminar, recupera el dato del
     * JTextField cedulaCliente y le envia al controlador para eliminar la
     * informacion ligada a la cedula.
     *
     * @param evt Evento
     */
    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        String cedula = txtCedulaCliente.getText();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, alertaCed);
        } else {
            boolean cent = controladorCliente.eliminarCliente(cedula);
            if (cent == true) {
                JOptionPane.showMessageDialog(this, alertaEl);
                llenarDatosTabla();
                limpiar();
                botones();
                editables();
            } else {
                JOptionPane.showMessageDialog(this, alertaNoEli);
            }
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    /**
     * Metodo botones.
     *
     * Este metodo desactiva los botones actualizar, cancelar, eliminar cuando
     * no esta seleccionado ningun elemento de la tabla.
     */
    public void botones() {
        btnActualizarCliente.setEnabled(false);
        btnCancelarCliente.setEnabled(false);
        btnEliminarCliente.setEnabled(false);
    }

    /**
     * Metodo editables.
     *
     * Este metodo desabilita la opcion de editar los jtext para no realizar
     * ningun cambio si no se desea.
     */
    public void editables() {
        txtCedulaCliente.setEditable(false);
        txtNombreCliente.setEditable(false);
        txtApellidoCliente.setEditable(false);
        txtNombreLocalCliente.setEditable(false);
        txtTelefonoCliente.setEditable(false);
        txtDireccionCliente.setEditable(false);
    }

    /**
     * Metodo limpiar.
     *
     * Borra todo el texto que este ingresado en los campos de texto o
     * JTextField
     */
    public void limpiar() {
        txtBuscarCliente.setText("");
        txtCedulaCliente.setText("");
        txtNombreCliente.setText("");
        txtApellidoCliente.setText("");
        txtNombreLocalCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
    }

    /**
     * Metodo llenarDatosTabla.
     *
     * Este metodo lista todo los cllientes que se hayan registrado, guardando
     * en una variable tipo lista lo que retorna el controlador para ser
     * agregado a la tabla.
     */
    public void llenarDatosTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
        modelo.setRowCount(0);

        List<Cliente> lista = controladorCliente.listarClientes();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, alertanoRegistrado);
        }

        for (Cliente cliente : lista) {
            Object[] objeto = {cliente.getCedula().trim(), cliente.getNombre().trim(), cliente.getApellido().trim(), cliente.getNombreDelLocal().trim(), cliente.getTelefono().trim(), cliente.getDireccion().trim()};
            modelo.addRow(objeto);
        }

        tblCliente.setModel(modelo);
    }

    /**
     * Metodo listarCliente.
     *
     * Este metodo lista al cliente que se encuentra al presionar el boton
     * buscar, recibe como parametro el cliente y el metodo le agrega a la
     * tabla.
     *
     * @param cliente Cliente
     */
    public void listarCliente(Cliente cliente) {
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
        modelo.setRowCount(0);

        Object[] objeto = {cliente.getCedula().trim(), cliente.getNombre().trim(), cliente.getApellido().trim(), cliente.getNombreDelLocal().trim(), cliente.getTelefono().trim(), cliente.getDireccion().trim()};
        modelo.addRow(objeto);

        tblCliente.setModel(modelo);
    }

    /**
     * Metodo limpiarTabla.
     *
     * Borra todos los datos de la Jtable
     */
    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
        for (int i = 0; i < tblCliente.getRowCount(); i++) {
            modelo.removeRow(i);
        }
        tblCliente.setModel(modelo);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListarClientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedulaa;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblGestionClientes;
    private javax.swing.JLabel lblInformacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreLocal;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreLocalCliente;
    private javax.swing.JFormattedTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
