/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Usuario;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class VentanaUsuario extends javax.swing.JInternalFrame {

    ControladorUsuario controladorUsuario;
    //clases para la internalizacion
    private Locale localizacion;
    private ResourceBundle recurso;
    //internalizacion para los JOprionPane
    private String alerta012;
    private String alerta013;
    private String alerta014;
    private String alerta015;
    private String alerta016;
    private String alerta017;
    private String alerta018;

    DefaultTableModel modelo;
    
    public VentanaUsuario(ControladorUsuario controladorUsuario) {
        initComponents();

        this.controladorUsuario = controladorUsuario;
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Correo");
        modelo.addColumn("Contraseña");
        this.tablaUsuarios.setModel(modelo);
        alerta012 = "Llene todos los campos solicitados para actualizar el usuario";
        alerta013 =  "¿Seguro desea actualizar sus datos?";
        alerta014 ="Sus datos han sido actualizados con exito";
        alerta015 =  "Sus datos no se han podido actualizar";
        alerta016 = "Por favor, llene el campo de busqueda";
        alerta017 =  "El cliente no se encuentra registrado";
        alerta018 =  "¿Esta seguro de eliminar el usuario?";
                
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
    
    public void cambiarIdioma(String idioma, String localizacion){
        lblGestionUsuarios.setText(recurso.getString("tlGestionUsuarios"));
        lblBuscarCedula.setText(recurso.getString("cedula"));
        lblCedula.setText(recurso.getString("cedula"));
        lblNombre.setText(recurso.getString("nombre"));
        lblApellido.setText(recurso.getString("apellido"));
        lblCorreo.setText(recurso.getString("correo"));
        lblContrasena.setText(recurso.getString("contrasena"));
        btnBuscar.setText(recurso.getString("buscar"));
        btnActualizar.setText(recurso.getString("actualizar"));
        btnListar.setText(recurso.getString("listar"));
        btnEliminar.setText(recurso.getString("eliminar"));
        btnLimpiar.setText(recurso.getString("limpiar"));
// Inter.... para la tabla de datos
        TableColumnModel modelo = tablaUsuarios.getColumnModel();
        modelo.getColumn(0).setHeaderValue(recurso.getString("cedula"));
        modelo.getColumn(1).setHeaderValue(recurso.getString("nombre"));
        modelo.getColumn(2).setHeaderValue(recurso.getString("apellido"));
        modelo.getColumn(3).setHeaderValue(recurso.getString("correo"));
        modelo.getColumn(4).setHeaderValue(recurso.getString("contrasena"));

//Internalizacion para los JOptionPane
         alerta012 = recurso.getString("alerta012");
         alerta013 = recurso.getString("alerta013");
         alerta014 = recurso.getString("alerta014");
         alerta015 = recurso.getString("alerta015");
         alerta016 = recurso.getString("alerta01");
         alerta017 = recurso.getString("alerta017");
         alerta018 = recurso.getString("alerta018");
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        lblGestionUsuarios = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        txtCedulaBuscar = new javax.swing.JTextField();
        lblBuscarCedula = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setClosable(true);
        setResizable(true);
        setTitle("Gestion de usuarios");
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

        lblGestionUsuarios.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblGestionUsuarios.setText("Gestion de Usuarios");

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        lblCorreo.setText("Correo:");

        lblContrasena.setText("Contraseña:");

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_clear (1).png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lblCedula.setText("Cedula:");

        txtCedula.setEditable(false);
        txtCedula.setBackground(new java.awt.Color(255, 255, 204));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agt_update_misc.png"))); // NOI18N
        btnActualizar.setText("Actualizar ");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/toolbar_find (1).png"))); // NOI18N
        btnBuscar.setText("Buscar ");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/list.png"))); // NOI18N
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Correo", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        lblBuscarCedula.setText("Cedula");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGestionUsuarios)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBuscarCedula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCedulaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblApellido)
                                    .addComponent(lblCorreo)
                                    .addComponent(lblContrasena)
                                    .addComponent(lblCedula))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContrasena))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(514, 514, 514)
                                        .addComponent(btnLimpiar)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btnActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(btnListar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedulaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarCedula))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCedula)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCorreo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContrasena))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Boton actualizar.
     * 
     *Con este boton recuperamos toda la informacion que el usuario ingrese  en el campo 
     * de texto y lo actualiza.
     * 
     * 
     * @param evt Evento
     */
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        String cedula = txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String correo = txtCorreo.getText().trim();
        String contrasena = txtContrasena.getText().trim();

        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this,alerta012);
        } else {

            Usuario u = new Usuario(cedula, nombre, apellido, correo, contrasena);

            int respuesta = JOptionPane.showConfirmDialog(this, alerta013);

            if (respuesta == JOptionPane.YES_OPTION) {

                boolean cent = controladorUsuario.actualizarUsuario(u);

                if (cent == true) {

                    JOptionPane.showMessageDialog(this, alerta014);

                } else {

                    JOptionPane.showMessageDialog(this, alerta015);
                }
            }

        }

        actualizarDatosUsuario(cedula);

    }//GEN-LAST:event_btnActualizarActionPerformed

    
    /**
     * metodo tabla Usuario
     * 
     * Este metodo lo utilizamos para seleccionar los datos de la tabla.
     * 
     * 
     * @param evt evento
     */
    
    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked

        int fila = tablaUsuarios.getSelectedRow();

        String cedula = (String) tablaUsuarios.getValueAt(fila, 0);
        String nombre = (String) tablaUsuarios.getValueAt(fila, 1);
        String apellido = (String) tablaUsuarios.getValueAt(fila, 2);
        String correo = (String) tablaUsuarios.getValueAt(fila, 3);
        String contrasena = (String) tablaUsuarios.getValueAt(fila, 4);

        txtCedula.setText(cedula);
        txtNombre.setText(nombre);
        txtApellido.setText(apellido);
        txtCorreo.setText(correo);
        txtContrasena.setText(contrasena);

        txtNombre.setEditable(true);
        txtApellido.setEditable(true);
        txtCorreo.setEditable(true);
        txtContrasena.setEditable(true);

        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);


    }//GEN-LAST:event_tablaUsuariosMouseClicked

    /**
     * metodo cargar lista de usuario.
     * 
     * Utilizamos este metodo para listar todos los datos que se hayan registrado.
     * 
     * 
     * @param listaUsuarios Evento
     */
    public void cargarListaUsuario(List<Usuario> listaUsuarios) {

        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        modelo.setRowCount(0);

        for (Usuario usuario : listaUsuarios) {

            Object[] objeto = {usuario.getCedula().trim(), usuario.getNombre().trim(),
                usuario.getApellido().trim(), usuario.getCorreo().trim(), usuario.getContraseña().trim()};

            modelo.addRow(objeto);

        }

        tablaUsuarios.setModel(modelo);

    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        limpiar();
        limpiarTabla();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * boton listar.
     * 
     * Al presionar el boton listamos todos los usuarios que se han registrado.
     * 
     * 
     * @param evt evento
     */
    
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed

        cargarListaUsuario(controladorUsuario.listarUsuario());

    }//GEN-LAST:event_btnListarActionPerformed

    
    /**
     * Boton buscar.
     * 
     * Al presionar este boton nos muestra en la tabla los datos del usuario que haya
     * buscado.
     * 
     * 
     * 
     * @param evt evento
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String cedula = txtCedulaBuscar.getText();

        if (cedula.isEmpty()) {
            
            JOptionPane.showMessageDialog(this,alerta016);
            
        }else{
            
            Usuario u = controladorUsuario.buscarUsuario(cedula);
            
            if (u != null) {
                
                listarUsuario(u);
                
            }else{
                
                JOptionPane.showMessageDialog(this,alerta017);
                
            }
            
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Boton eliminar.
     * 
     * Al presionar este boton eliminamos el usuario que este seleccionado en la tabla
     * le decimos con JOptionPane.showConfirmDialog si esta seguro de eliminar.
     * 
     * @param evt 
     */
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int opcion = JOptionPane.showConfirmDialog(this, alerta018);

        if (opcion == JOptionPane.YES_OPTION) {

            controladorUsuario.eliminarUsuario(txtCedula.getText());

            cargarUsuarioTablaUsuario();

        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    
    
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

        datosTablaUsuario();

    }//GEN-LAST:event_formInternalFrameActivated

    
    /**
     * Metodo cargarUsuarioTabalaUsuario.
     * 
     * Este metodo lo estamos utilizando para actualizar la tabla.
     * 
     * 
     */
    
    public void cargarUsuarioTablaUsuario() {

        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();

        modelo.setRowCount(0);

        for (Usuario usuario : controladorUsuario.listarUsuario()) {

            Object[] rowData = {usuario.getCedula().trim(), usuario.getNombre().trim(), usuario.getApellido().trim(),
                usuario.getCorreo().trim(), usuario.getContraseña().trim()};

            modelo.addRow(rowData);

        }

        tablaUsuarios.setModel(modelo);

    }


    
    /**
     * Metodo devolver Usuario.
     * 
     * Este metodo lo usamos para devolver al usaurio 
     * 
     * 
     * 
     */
    public void datosTablaUsuario() {

        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        modelo.setRowCount(0);

        Usuario u = controladorUsuario.devolverUsuario();

        Object[] objeto = {u.getCedula().trim(), u.getNombre().trim(), u.getApellido().trim(),
            u.getCorreo().trim(), u.getContraseña().trim()};

        modelo.addRow(objeto);

        tablaUsuarios.setModel(modelo);

    }

    /**
     * Metodo actualizarDatosUsuario.
     * 
     * Este metodo nos permite buscar al usaurio y listarlo pasandolo como parametro 
     * la cedula.
     * 
     * 
     * @param cedula 
     */
    public void actualizarDatosUsuario(String cedula) {

        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        modelo.setRowCount(0);

        Usuario u = controladorUsuario.buscarUsuario(cedula);

        Object[] objeto = {u.getCedula().trim(), u.getNombre().trim(), u.getApellido().trim(),
            u.getCorreo().trim(), u.getContraseña().trim()};

        modelo.addRow(objeto);

        tablaUsuarios.setModel(modelo);

    }
    
    /**
     * metodo listar Usuario.
     * 
     * Le pasamos como parametro al usuario, la utilizamos para buscar al usuario.
     * 
     * 
     * @param usuario 
     */
    
    public void listarUsuario(Usuario usuario){
        
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        modelo.setRowCount(0);
        
        Object[] objeto = {usuario.getCedula().trim(), usuario.getNombre().trim(), usuario.getApellido().trim(),
            usuario.getCorreo().trim(), usuario.getContraseña().trim()};
        
        modelo.addRow(objeto);
        
        tablaUsuarios.setModel(modelo);
        
        
    }

    /**
     * Metodo limpiarTabla
     * 
     * Con este metodo limpiamos la tabla.
     * 
     * 
     */
    
    public void limpiarTabla(){
        
        DefaultTableModel modelo = (DefaultTableModel)tablaUsuarios.getModel();
        for (int i = 0; i < tablaUsuarios.getRowCount(); i++) {
            
            modelo.removeRow(i);
            
        }
        tablaUsuarios.setModel(modelo);
        
    }
    
    
    /**
     * Metodo limpiar.
     * 
     * Limpiamos todos los campos de texto de la interfaz.
     * 
     * 
     */
    public void limpiar() {

        txtCedulaBuscar.setText("");
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtContrasena.setText("");
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblBuscarCedula;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblGestionUsuarios;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaBuscar;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
