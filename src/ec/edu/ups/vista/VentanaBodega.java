/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.DAO.BodegaDAO;
import ec.edu.ups.controlador.ControladorBodega;
import ec.edu.ups.modelo.Bodega;
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
public class VentanaBodega extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    private ResourceBundle recurso;
    private Locale localizacion;

    private ControladorBodega controladorBodega;

    private List<Bodega> bodegas;

    /**
     * Crear nueva ventana bodega
     *
     * Para este metodo estamos controlando la visibilidad de siertos
     * componentes como la actualizacion de vista y la desactivacion de los
     * botones que interactuaran con la interfaz grafica de usuario, El
     * initComponents() no lo puedes modificar asi no mas, en el metodo donde el
     * ide lleva el control de lo que hace, si lo alteras posiblemente ya no
     * pueda cargarse la interfaz. Lo que puedes hacer es usar el editor del ide
     * hasta donde ya creas que no puedes mas, luego lo que haces es un
     * copy-paste del initComponents(), si lo haces tendrias dos metodos con el
     * mismo nombre, aca solo debes de documetar el metodo del ide y listo, ya
     * puedes modificar el initComponents() que haz copiado
     *
     * @param controladorB
     */
    private String alerta029;
    private String alerta30;
    private String alerta31;
    private String alerta32;
    private String alerta33;
    private String alerta35;
    

    public VentanaBodega(ControladorBodega controladorB) {
        initComponents();
        controladorBodega = controladorB;

        modelo = new DefaultTableModel();

        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");

        this.TblDatosBodega.setModel(modelo);
        alerta30 = "Llene todos los campos";
        alerta029 = "No se ha encontrado la bodega";
        alerta31 = "se encuentra vacio el campo";
        alerta32 = "ERROR";
        alerta33 = "Bodega eliminada con exito";
        alerta35 = "Seguro desea eliminar";
        
        desactivarBotones();
        actualizarVista();

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

    //////
    public void cambiarIdioma(String idioma, String localizacion) {

        // Inter.... para la tabla de datos
        TableColumnModel modelo = TblDatosBodega.getColumnModel();
        modelo.getColumn(0).setHeaderValue(recurso.getString("nombre"));
        modelo.getColumn(1).setHeaderValue(recurso.getString("direccion"));
        modelo.getColumn(2).setHeaderValue(recurso.getString("ciudad"));

        alerta30 = recurso.getString("alerta30");
        alerta029 = recurso.getString("alerta029");
        alerta31 = recurso.getString("alerta31");
        alerta32 = recurso.getString("alerta32");
        alerta33 = recurso.getString("alerta33");
        alerta35 = recurso.getString("alerta35");
        
    }

    public JLabel getGestionBodega() {
        return lblGestionDeBodega;
    }

    public JLabel getBodega() {
        return lblBodega;
    }

    public JButton getBotonBuscar() {
        return btnBuscar;
    }

    public JLabel getInformacion() {
        return lblInformacion;
    }

    public JLabel getNombre() {
        return lblNombre;
    }

    public JLabel getDireccion() {
        return lblDireccion;
    }

    public JLabel getCiudad() {
        return lblCiudad;
    }

    public JButton getBotonNuevo() {
        return btnNuevo;
    }

    public JButton getBotonActualizar() {
        return btnActualizar;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }

    public JButton getBotonCancelar() {
        return botonCancelar;
    }

    /**
     * Metodo Actualizar Vista
     *
     * Este metodo se encarga directamente con la GUI ya que si llamamos este
     * metodo tendremos como resultados los datos cargados dentro de la tabla
     * Datos haciendo que el usuario pueda ver los datos de la bodega que en
     * este caso serian solo tres datos que serian el nombre la direccion y a
     * ciudad donde estara ubicado la bodega a gestionar
     *
     */
    public void actualizarVista() {
        List<Bodega> listaDeBodegas = controladorBodega.listarBodegas();

        DefaultTableModel modelo = (DefaultTableModel) TblDatosBodega.getModel();
        modelo.setRowCount(0);
        TblDatosBodega.setModel(modelo);
        Object[] fila = new Object[3];
        for (Bodega bodega : listaDeBodegas) {
            fila[0] = bodega.getNombre();
            fila[1] = bodega.getDireccion();
            fila[2] = bodega.getCuidad();
            modelo.addRow(fila);
        }
        TblDatosBodega.setModel(modelo);
    }

    /**
     * Metodo Limpiar
     *
     * El metodo clean o limpiar es muy usable para la GUI porque ara que la
     * experiencia con el usuario sea satisfactorio ya que cada ves que el
     * metodo sea llamado este podra limpiar los espacios designados para el
     * nomnre ladireccion y la ciudad aunque ya esten caargados los datos ese
     * metodo podra limpiar en caso de que sea llamado
     *
     */
    public void limpiar() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtCiudad.setText("");
    }

    /**
     * Metodo activar botones
     *
     * El metodo activar botones nos da la factibilidad en los comandos como de
     * botones como actualizar, buscar, cancelar, eliminar, para que estos
     * botones sean acivados de la manera true, dependera mucho de el tipo de
     * gestion que este haciendo el usuario en la ventana bodega para que el
     * pueda tener accesibilidad a estos botones seria como una restriccion para
     * ellos ya que no podran estar activando y desactivando sino reguirse ala
     * funcionalidad del programa
     *
     */
    public void ActivarBotones() {
        btnActualizar.setEnabled(true);
        btnBuscar.setEnabled(true);
        botonCancelar.setEnabled(true);
        botonEliminar.setEnabled(true);
        txtBodega.setEditable(true);
    }

    /**
     * Metodo desactivar botones
     *
     * El siguiente metodo nos descativara los botoes para que el usuario no
     * pueda manipular dependiendo el tio de gestion este haciendo ellos tendran
     * la accesibilidad y en caso de que este metodo sea invocado en cualquier
     * otro el metodo nos ara que se desactiven a diferencia el metodo
     * anteriormente tratado
     */
    public void desactivarBotones() {
        btnActualizar.setEnabled(false);
        btnBuscar.setEnabled(false);
        botonCancelar.setEnabled(false);
        botonEliminar.setEnabled(false);
        txtBodega.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCiudad = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblInformacion = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblDatosBodega = new javax.swing.JTable();
        txtDireccion = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblBodega = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        lblCiudad = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtBodega = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        lblGestionDeBodega = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestion de bodegas");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/toolbar_find (1).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblInformacion.setText("Informacion de la bodega");

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        TblDatosBodega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Direccion", "Cuidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblDatosBodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDatosBodegaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblDatosBodega);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/window_new.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre");

        lblBodega.setText("Bodega");

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agt_update_misc.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        lblCiudad.setText("Ciudad");

        txtBodega.setEditable(false);

        lblDireccion.setText("Direccion");

        lblGestionDeBodega.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblGestionDeBodega.setForeground(new java.awt.Color(51, 0, 51));
        lblGestionDeBodega.setText("Gestion de Bodega");

        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/no (1).png"))); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lblInformacion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblBodega)
                        .addGap(18, 18, 18)
                        .addComponent(txtBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(botonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCiudad)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblGestionDeBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblGestionDeBodega)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBodega)
                    .addComponent(txtBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(39, 39, 39)
                .addComponent(lblInformacion)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCiudad))))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Metodo btnActualizarActionPerformed
     *
     * Este metodo fue generado automaticamente por java y correcponde al boton
     * actualizar que esta en la interfaz grafica de usuario y este metodo ara
     * que establesca los nombre direciones y la ciudad de donde estara situado
     * la bodega a gestionar ya que estara avtivado solo este boton y el nuevo
     * en caso de que el usuario quiera agregar otra bodega ala lista de bodegas
     *
     * @param evt
     */
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (!txtNombre.getText().equals("") && !txtDireccion.getText().equals("") && !txtCiudad.getText().equals("")) {
            String nombre = txtNombre.getText();
            String direccion = txtDireccion.getText();
            String cuidad = txtCiudad.getText();
            controladorBodega.actualizarBodega(nombre, direccion, cuidad);
            actualizarVista();
            desactivarBotones();
            btnNuevo.setEnabled(true);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, alerta30, alerta32, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnActualizarActionPerformed
    /**
     * Metodo btnBuscarActionPerformed
     *
     * Este metodo es la encargada de buscar dentro de la tabla creada donde
     * estaran todos los datos almacenados con las caracteristicas de bodega, y
     * esto controlara que el usuario en el momento de buscar una bodega la
     * coficacion permita buscar dentro con un for ya que debera recorrer todas
     * las columnas con el dato que el usuario le dara para su busqueda y en
     * caso de no encontrarle nos dara un mensaje de error y en caso de que si
     * solo nos dara los valores encontrados dentro del dato especificado
     *
     * @param evt
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handlifng code here
        if (!txtBodega.getText().equals("")) {
            String nombre = txtBodega.getText();
            int filas = TblDatosBodega.getRowCount();
            boolean encontrado = true;

            for (int i = 0; i < filas; i++) {
                String datoABuscar = TblDatosBodega.getValueAt(i, 0).toString().trim();
                if (nombre.equals(datoABuscar)) {
                    encontrado = false;
                    TblDatosBodega.setRowSelectionInterval(i, i);
                    break;
                }
            }
            if (encontrado) {
                JOptionPane.showMessageDialog(null, alerta029, alerta32, JOptionPane.ERROR_MESSAGE);

            }
            txtBodega.setText("");

        } else {
            JOptionPane.showMessageDialog(null, alerta31, alerta32, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    /**
     * Metodo botonEliminarActionPerformed
     *
     * El metodo eliminar nos ayudara a eliminar las bodegas que esten
     * alamecenados dentro del fichero automanticamente pero por supuesto si el
     * dato a eliminar es correcto se procedera con la ejecucion del codigo
     * elimninar en caso de que se logre desarrollar con exito tendremos como
     * resultado un Bodega eliminado con exito
     *
     * @param evt
     */
    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed

        int eliminar = JOptionPane.showConfirmDialog(this, alerta35);
        if (eliminar == JOptionPane.YES_OPTION) {
            String nombre = txtNombre.getText();
            controladorBodega.eliminarBodega(nombre);
            actualizarVista();
            desactivarBotones();
            btnNuevo.setEnabled(true);
            limpiar();
            JOptionPane.showMessageDialog(this, alerta33);
        }

    }//GEN-LAST:event_botonEliminarActionPerformed
    /**
     * Metodo btnNuevoActionPerformed
     *
     * El metodo nuevo nos ayudara a crear una bodega nuevo con los nombre.
     * direciones y ciudad establecida por el usuario estos datos inmetiatamente
     * pasaran alos ficheros para ser almacenados de una manera automatica ya
     * que si se procede a ejecutar este metodo es lo que ara.
     *
     */
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (!txtNombre.getText().equals("") && !txtDireccion.getText().equals("") && !txtCiudad.getText().equals("")) {
            String nombre = txtNombre.getText();
            String direccion = txtDireccion.getText();
            String cuidad = txtCiudad.getText();
            controladorBodega.crearBodega(nombre, direccion, cuidad);
            actualizarVista();
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, alerta30, alerta32, JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnNuevoActionPerformed
    /**
     * Metodo TblDatosMouseClicked
     *
     * El metodo daos es la que nos muestra los atributos de bodega de una
     * manera inmediata solo cuando se selecione ndicha columna se procedera a
     * ejecutarse este codigo devolviendonos de una manera rapida el estatus de
     * la bodega selecionada y maracandola de una manera particular que sea
     * diferenciada de las demas columnas
     *
     */
    private void TblDatosBodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDatosBodegaMouseClicked
        ActivarBotones();
        btnNuevo.setEnabled(false);
        int filaSelecionada = TblDatosBodega.getSelectedRow();

        if (filaSelecionada >= 0) {
            String nombre = TblDatosBodega.getValueAt(filaSelecionada, 0).toString();
            String direccion = TblDatosBodega.getValueAt(filaSelecionada, 1).toString();
            String cuidad = TblDatosBodega.getValueAt(filaSelecionada, 2).toString();

            txtNombre.setText(nombre);
            txtDireccion.setText(direccion);
            txtCiudad.setText(cuidad);
        }

    }//GEN-LAST:event_TblDatosBodegaMouseClicked
    /**
     * Metodo botonCancelarActionPerformed
     *
     * El metodo cancelar nos ayudara simplemente a detener un proceso que el
     * ussuario este haciendo en la interfaz limpiando todo lo que este echo ya
     * permitiendole que pueda el volver hacer todo ese proceso o hacer otro
     * distinto.
     *
     */
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        limpiar();
        desactivarBotones();
        btnNuevo.setEnabled(true);


    }//GEN-LAST:event_botonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblDatosBodega;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBodega;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblGestionDeBodega;
    private javax.swing.JLabel lblInformacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtBodega;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
