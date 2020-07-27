/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import javax.swing.JOptionPane;

/**
 * Clase VentanaRegistrarCliente.
 * 
 * esta clase permite el ingreso de datos para el registro de clientes.
 * 
 * @author santi
 */
public class VentanaRegistrarCliente extends javax.swing.JInternalFrame {

    ControladorCliente controladorCliente;
    /**
     * Creates new form VentanaRegistrarCliente
     */
    public VentanaRegistrarCliente(ControladorCliente controladorCliente) {
        initComponents();
        
        this.controladorCliente = controladorCliente;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        txtCedulaCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtApellidoCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombreLocalCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccionClientes = new javax.swing.JTextField();
        btnRegistrarCliente = new javax.swing.JButton();
        btnRegresarCliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jLabel6.setText("Cedula:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel1.setText("Nombre Local");

        jLabel4.setText("Telefono");

        txtTelefonoCliente.setText(" ");

        jLabel5.setText("Direccion");

        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user_group.png"))); // NOI18N
        btnRegistrarCliente.setText("Registrarse");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btnRegresarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/undo (1).png"))); // NOI18N
        btnRegresarCliente.setText("Atras");
        btnRegresarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarClienteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel7.setText("REGISTRAR CLIENTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrarCliente)
                                .addGap(33, 33, 33)
                                .addComponent(btnRegresarCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(9, 9, 9)))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreCliente)
                                    .addComponent(txtCedulaCliente)
                                    .addComponent(txtApellidoCliente)
                                    .addComponent(txtNombreLocalCliente)
                                    .addComponent(txtTelefonoCliente)
                                    .addComponent(txtDireccionClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel7)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreLocalCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccionClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCliente)
                    .addComponent(btnRegresarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo btnRegistrarClienteActionPerformed.
     * 
     * Este metodo recupera los datos ingresados en los JtextField al presionar el
     * botón y envia al controlador.
     * @param evt Evento
     */
    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        String cedula = txtCedulaCliente.getText();
        String nombre = txtNombreCliente.getText();
        String apellido = txtApellidoCliente.getText();
        String nombreLocal = txtNombreLocalCliente.getText();
        String telefono = txtTelefonoCliente.getText();
        String direccion = txtDireccionClientes.getText();
        
        if(cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || nombreLocal.isEmpty() || telefono.isEmpty() || direccion.isEmpty()){
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
        }else{
            controladorCliente.crearCliente(cedula, nombre, apellido, nombreLocal, telefono, direccion);
            JOptionPane.showMessageDialog(this, "Cliente registrado con exito");
            limpiar();
        }
        
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    /**
     * Metodo btnRegresarClienteActionPerformed.
     * 
     * Cierra la pantalla que esta visible al hacer click en el boton.
     * 
     * @param evt 
     */
    private void btnRegresarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarClienteActionPerformed
        limpiar();
        this.hide();
    }//GEN-LAST:event_btnRegresarClienteActionPerformed

    /**
     * Metodo limpiar.
     * 
     * Este metodo borra el texto que esta ingresado en los jTextField.
     */
    public void limpiar(){
            txtCedulaCliente.setText("");
            txtNombreCliente.setText("");
            txtApellidoCliente.setText("");
            txtNombreLocalCliente.setText("");
            txtTelefonoCliente.setText("");
            txtDireccionClientes.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegresarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JTextField txtDireccionClientes;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreLocalCliente;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
