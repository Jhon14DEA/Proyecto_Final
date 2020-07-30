/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.*;
import ec.edu.ups.modelo.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class VentanaFactura extends javax.swing.JInternalFrame {

    private Bodega bodega;
    private Producto producto;
    private Cliente cliente;
    private Usuario usuario;
    private Factura factura;
    private ControladorFactura controladorfactura;
    private ControladorBodega controladorBodega;
    private ControladorCliente controladorCliente;
    private ControladorProducto controladorProducto;
    Calendar c = Calendar.getInstance();

    private String opcionSi;
    private String opcionCancelar;
    private String opcion2parte1;
    private String opcion2parte2;
    private String opcionTituloConfirmar;

    private Set<Producto> productosTabla;

    //internalizacion 
     private Locale localizacion;
    private ResourceBundle recurso;
    //Joptionpane
    private String alerta019;
    private String alerta020;
    private String alerta021;
    private String alerta022;
    private String alerta023;
    private String alerta024;
    private String alerta025;
    private String alerta026;
    private String alerta027;
    private String alerta028;
    
    /**
     * Creates new form VentanaFactura
     */
    public VentanaFactura(ControladorBodega controladorB, Bodega bodegaV, ControladorCliente controladorC, Cliente clienteV, ControladorFactura controladorF,
            Factura facturaV, ControladorProducto controladorP, Producto productoV) {
        initComponents();
        controladorBodega = controladorB;
        controladorCliente = controladorC;
        controladorProducto = controladorP;
        controladorfactura = controladorF;
        bodega = bodegaV;
        producto = productoV;
        factura = facturaV;
        cliente = clienteV;
        txtFacturaNumero.setText(controladorfactura.codigo() + "");
        txtFechaDeEmision.setText(fechaActual(c.getTime()));
        btnRegistrarCliente.setEnabled(false);
    //alerta019
    //alerta020
    alerta021 = "SI";
    alerta022 = "CANCELAR";
    alerta023 = "Desea Crear un cliente ";
    alerta024 = "CREAR";
    alerta025 =  "El campo se encuentra vacio";
    alerta026 = "ERROR";
    alerta027 =  "Llene todos los campos";
    alerta028 = "ERROR";
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
    lblTlFactura.setText(recurso.getString("factura"));
    lblFacturaNumero.setText(recurso.getString("numeroFactura"));
    lblFechaDeEmision.setText(recurso.getString("fechaEmision"));
    lblCedula.setText(recurso.getString("cedula"));
    lblCliente.setText(recurso.getString("cliente"));
    lblLocal.setText(recurso.getString("local"));
    lblNombre.setText(recurso.getString("nombre"));
    lblApellido.setText(recurso.getString("apellido"));
    lblDireccion.setText(recurso.getString("direccion"));
    lblTelefono.setText(recurso.getString("telefono"));
    lblSeleccionarB.setText(recurso.getString("seleccionarB"));
    lblSeleccionarP.setText(recurso.getString("seleccionarP"));
    lblSubTotal.setText(recurso.getString("subTotal"));
    lblIVA.setText(recurso.getString("totalIVA"));
    lblTotal.setText(recurso.getString("total"));
    btnRegistrarCliente.setText(recurso.getString("registrar"));
    botonProductos.setText(recurso.getString("productos"));
    botonGuardarFactura.setText(recurso.getString("guardar"));
    botonCalcular.setText(recurso.getString("calcular"));
    //TABLA datos factura
     TableColumnModel modelo = tablaDatosFactura.getColumnModel();
        modelo.getColumn(0).setHeaderValue(recurso.getString("stock"));
        modelo.getColumn(1).setHeaderValue(recurso.getString("codigoProducto"));
        modelo.getColumn(2).setHeaderValue(recurso.getString("nombreProducto"));
        modelo.getColumn(3).setHeaderValue(recurso.getString("PrecioU"));
        modelo.getColumn(4).setHeaderValue(recurso.getString("subTotal"));
        //joptionpane
        alerta021 = recurso.getString("alerta021");
        alerta022 = recurso.getString("alerta022");
        alerta023 = recurso.getString("alerta023");
        alerta024 = recurso.getString("alerta024");
        alerta025 = recurso.getString("alerta025");
        alerta026 = recurso.getString("alerta05");
        alerta027 = recurso.getString("alerta01");
        alerta028 = recurso.getString("alerta05");
            
    }
    /**
     * limpiar.
     * 
     * Este metodo limpia todo el contenido que pueda estar escrito en las cajas
     * de texto y tambien los combo-boxs.
     */
    public void limpiar() {
        txtCedula.setText("");
        txtLocal.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtSubtotal.setText("");
        txtIVA.setText("");
        txtTotal.setText("");
        cmbxBodega.setSelectedIndex(0);
        cmbxProducto.setSelectedIndex(0);
    }

    /**
     * FechaActual.
     * 
     * Este método formatea la manera en la que se quiere visualizar la fecha 
     * del computador al momento de implantarlo en la factura.
     * 
     * @param fecha
     * @return String fecha.
     */
    private String fechaActual(Date fecha) {

        String strDateFormat = "dd-MM-yyyy";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        return objSDF.format(fecha);
    }

    /**
     * actualizarCmbxBodega.
     * 
     * Este método ayuda a formatear el modelo de la tabla ya que cuando se 
     * agrega una bodega y un producto se les debe añadir a estas para que le 
     * permita al usuario interactuar con los nuevos producto y bodegas. 
     * 
     */
    public void actualizarCmbxBodega() {
        cmbxBodega.removeAllItems();

        cmbxBodega.addItem("--SELECCIONE UNA BODEGA--");
        if (controladorBodega.listarBodegas() == null) {
        } else {
            List<Bodega> bodegas = controladorBodega.listarBodegas();

            for (Bodega bodega1 : bodegas) {
                cmbxBodega.addItem(bodega1.getNombre());
            }
        }

        cmbxBodega.setSelectedIndex(0);

    }

    /**
     * ActivarTextBoxs.
     * 
     * Este método solamente habilita las cajas de texto para que el usuario 
     * pueda editarlas. 
     * 
     */
    public void ActivarTextBoxs() {
        txtNombre.setEditable(true);
        txtApellido.setEditable(true);
        txtLocal.setEditable(true);
        txtDireccion.setEditable(true);
        txtTelefono.setEditable(true);
        btnRegistrarCliente.setEnabled(true);
    }

    /**
     * desActivarTextBoxs.
     * 
     * Este método solamente deshabilita las cajas de texto para que el usuario 
     * no pueda editarlas. 
     * 
     */
    public void desActivarTextBoxs() {
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
        txtLocal.setEditable(false);
        txtDireccion.setEditable(false);
        txtTelefono.setEditable(false);
    }

    /**
     * actualizarVista.
     * 
     * Este método ayuda a actualizar la vista de la tabla ya que se debe añadir
     * nuevo elementos cada vez y la tabla debe actualizarse cada vez. 
     * 
     */
    public void actualizarVista() {

        DefaultTableModel modelo = (DefaultTableModel) tablaDatosFactura.getModel();
        modelo.setRowCount(0);
        tablaDatosFactura.setModel(modelo);
        for (Producto producto1 : productosTabla) {
            Object[] fila = new Object[5];
            fila[0] = null;
            fila[1] = producto1.getCodigo();
            fila[2] = producto1.getNombreDeProducto();
            fila[3] = producto1.getPrecioDeProdcuto();
            fila[4] = null;
            modelo.addRow(fila);
        }

        tablaDatosFactura.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblFacturaNumero = new javax.swing.JLabel();
        txtFacturaNumero = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblFechaDeEmision = new javax.swing.JLabel();
        txtFechaDeEmision = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatosFactura = new javax.swing.JTable();
        lblSubTotal = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        lblIVA = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        botonGuardarFactura = new javax.swing.JButton();
        lblTlFactura = new javax.swing.JLabel();
        botonProductos = new javax.swing.JButton();
        txtDireccion = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblSeleccionarB = new javax.swing.JLabel();
        cmbxBodega = new javax.swing.JComboBox<>();
        lblSeleccionarP = new javax.swing.JLabel();
        cmbxProducto = new javax.swing.JComboBox<>();
        lblLocal = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        botonCalcular = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Factura");
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

        lblCliente.setText("Cliente:");

        lblDireccion.setText("Direccion:");

        txtApellido.setEditable(false);

        lblCedula.setText("Cedula:");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        lblFacturaNumero.setText("Factura Nro:");

        txtFacturaNumero.setEditable(false);
        txtFacturaNumero.setBackground(new java.awt.Color(204, 204, 204));

        lblTelefono.setText("Telefono:");

        txtTelefono.setEditable(false);

        lblFechaDeEmision.setText("Fecha de Emision:");

        txtFechaDeEmision.setEditable(false);
        txtFechaDeEmision.setBackground(new java.awt.Color(204, 204, 204));

        tablaDatosFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Codigo de producto", "Nombre de Producto", "Precio U.", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatosFactura);

        lblSubTotal.setText("sub Total");

        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubtotal.setText("0.00");

        lblIVA.setText("Total IVA");

        txtIVA.setEditable(false);
        txtIVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIVA.setText("0.00");

        lblTotal.setText("TOTAL");

        txtTotal.setEditable(false);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0.00");

        botonGuardarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        botonGuardarFactura.setText("Guardar Factura");
        botonGuardarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarFacturaActionPerformed(evt);
            }
        });

        lblTlFactura.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTlFactura.setText("FACTURA");

        botonProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/box_full.png"))); // NOI18N
        botonProductos.setText("Productos");
        botonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProductosActionPerformed(evt);
            }
        });

        txtDireccion.setEditable(false);

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        txtNombre.setEditable(false);

        lblSeleccionarB.setText("Seleccionar Bodega:");

        cmbxBodega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECCIONE UNA BODEGA--" }));
        cmbxBodega.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbxBodegaFocusLost(evt);
            }
        });

        lblSeleccionarP.setText("Seleccionar Producto:");

        cmbxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECCIONE UN PRODUCTO--" }));

        lblLocal.setText("Local:");

        txtLocal.setEditable(false);

        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });

        btnRegistrarCliente.setText("Registrar");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblTelefono)
                                            .addGap(28, 28, 28)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRegistrarCliente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(lblFacturaNumero))
                                            .addComponent(lblCedula))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtFacturaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(lblFechaDeEmision)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtFechaDeEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblApellido)
                                        .addComponent(lblDireccion)
                                        .addComponent(lblNombre)
                                        .addComponent(lblLocal))
                                    .addGap(365, 365, 365)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblCliente)
                                .addGap(376, 376, 376)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(lblTlFactura))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(botonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSeleccionarP)
                                    .addComponent(lblSeleccionarB))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbxBodega, 0, 1, Short.MAX_VALUE)
                                    .addComponent(cmbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuardarFactura)
                .addGap(18, 18, 18)
                .addComponent(botonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubTotal)
                    .addComponent(lblIVA)
                    .addComponent(lblTotal))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFacturaNumero)
                                    .addComponent(txtFacturaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFechaDeEmision)
                                    .addComponent(txtFechaDeEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lblTlFactura)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCedula)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRegistrarCliente))
                                .addGap(18, 18, 18)
                                .addComponent(lblCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLocal)
                                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSeleccionarB)
                                    .addComponent(cmbxBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSeleccionarP)
                                    .addComponent(cmbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblApellido)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDireccion)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTelefono)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(botonProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblIVA)
                                .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSubTotal)
                                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botonGuardarFactura)
                        .addComponent(botonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * formFocusGained.
     * 
     * Este evento solamente acude a los métodos dentro de la interfaz y es que 
     * cada vez que pierda el enfoque y vuelva a ganar enfoque se actualizara el
     * combo-box automáticamente, se formatea la fecha de la caja de texto y 
     * también se actualiza el numero de factura.  
     * 
     * @param evt 
     */
    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        txtFacturaNumero.setText(controladorfactura.codigo() + "");
        actualizarCmbxBodega();
        txtFechaDeEmision.setText(fechaActual(c.getTime()));
    }//GEN-LAST:event_formFocusGained

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        actualizarCmbx();
        productosTabla = new HashSet<>();
        actualizarVista();
    }//GEN-LAST:event_formPropertyChange

    /**
     * cmbxBodegaFocusLost.
     * 
     * Este evento lo que permite es que cuando el combo-box pierda enfoque se 
     * actualiza automáticamente el combo-box de producto con los productos que 
     * existen en esa bodega. 
     * 
     * @param evt 
     */
    private void cmbxBodegaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbxBodegaFocusLost
        String bodega = cmbxBodega.getSelectedItem().toString();
        cmbxProducto.removeAllItems();

        cmbxProducto.addItem("--SELECCIONE UN PRODUCTO--");
        if (controladorBodega.listarBodegas() == null) {
        } else {
            List<Producto> bodegas = controladorProducto.verProductosPorBodega(bodega);
            for (Producto producto : bodegas) {
                cmbxProducto.addItem(producto.getNombreDeProducto());
            }
        }

        cmbxProducto.setSelectedIndex(0);

    }//GEN-LAST:event_cmbxBodegaFocusLost

    /**
     * txtCedulaKeyTyped.
     * 
     * Este evento corre cada vez que presionen “ENTER” en el teclado, comprueba
     * que todos los campos estén completos, sino soltará un error y un 
     * opciónpane aparecerá. Si no salta error los datos del cliente se cargarán
     * automáticamente en las cajas de texto. Si el cliente no existe un 
     * OptionPane aparecerá en la cual pregunta al usuario si quiere crear 
     * un nuevo cliente. Si es que selecciona que si se activara el botón para 
     * registrar el cliente y también se activaran las cajas de texto para que 
     * el usuario pueda ingresar los datos.  
     * 
     * @param evt 
     */
    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        char validar = evt.getKeyChar();
        if (validar == '\n') {
            if (!txtCedula.getText().equals("")) {
                if (controladorCliente.buscarCliente(txtCedula.getText()) != null) {
                    cliente = controladorCliente.buscarCliente(txtCedula.getText());
                    txtLocal.setText(cliente.getNombreDelLocal());
                    txtNombre.setText(cliente.getNombre());
                    txtApellido.setText(cliente.getApellido());
                    txtDireccion.setText(cliente.getDireccion());
                    txtTelefono.setText(cliente.getTelefono());
                } else {
                    Object[] opcionesJPanel = {alerta021, alerta022};
                    /*int confirmar = JOptionPane.showOptionDialog(null,
                            "<html>" + opcion2parte1 + " <strong>" + txtCedula.getText() + "</strong> " + opcion2parte2 + "</html>",
                            opcionTituloConfirmar,
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, opcionesJPanel, null);*/
                    int confirmar =JOptionPane.showOptionDialog(null, alerta023, alerta024, JOptionPane.YES_NO_CANCEL_OPTION, 
                            JOptionPane.INFORMATION_MESSAGE, null, opcionesJPanel, null);
                    if (JOptionPane.OK_OPTION == confirmar) {
                        ActivarTextBoxs();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,alerta025, alerta026, JOptionPane.ERROR_MESSAGE);
            }

        }


    }//GEN-LAST:event_txtCedulaKeyTyped

    /**
     * botonCalcularActionPerformed. 
     * 
     * Este evento permite que se calcule los valores del subtotal, el IVA y el
     * total cuando se presione le botón calcular. 
     * 
     * @param evt 
     */
    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
        double suma = 0;
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        for (int i = 0; i < tablaDatosFactura.getRowCount(); i++) {
            int numero = Integer.parseInt(tablaDatosFactura.getValueAt(i, 0).toString());
            double precio = Double.parseDouble(tablaDatosFactura.getValueAt(i, 3).toString());
            suma = numero * precio;
            tablaDatosFactura.setValueAt(suma, i, 4);
        }
        for (int i = 0; i < tablaDatosFactura.getRowCount(); i++) {
            double sbtotal = Double.parseDouble(tablaDatosFactura.getValueAt(i, 4).toString());
            subtotal += sbtotal;
        }
        iva = (subtotal * 0.12);
        total = (subtotal + iva);
        txtSubtotal.setText(subtotal + "");
        txtIVA.setText(iva + "");
        txtTotal.setText(total + "");
    }//GEN-LAST:event_botonCalcularActionPerformed

    /**
     * botonProductosActionPerformed.
     * 
     * Este evento lo que hace es cargar el producto seleccionado en el combo-box
     * en la tabla para poder proceder a facturarlo. 
     * 
     * @param evt 
     */
    private void botonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProductosActionPerformed
        String productoElegido = cmbxProducto.getSelectedItem().toString();
        producto = new Producto();
        producto = controladorProducto.verProducto(productoElegido);
        productosTabla.add(producto);
        actualizarVista();

    }//GEN-LAST:event_botonProductosActionPerformed

    /**
     * botonCrearFacturaActionPerformed.
     * 
     * Este evento lo que hace es extraer todos los datos de las cajas de texto
     * y de la tabla, procede a crear una factura. 
     * 
     * @param evt 
     */
    private void botonGuardarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarFacturaActionPerformed
         List<Factura> facturas=new ArrayList<>();
         
         for (int i = 0; i < tablaDatosFactura.getRowCount(); i++) {
            int numeroF=Integer.parseInt(txtFacturaNumero.getText());
            String cedula = txtCedula.getText();
            double subtotal=Double.parseDouble(txtSubtotal.getText());
            int cantidad =Integer.parseInt(tablaDatosFactura.getValueAt(i, 0).toString());
            double iva =Double.parseDouble(txtIVA.getText());
            double total=Double.parseDouble(txtTotal.getText());
            String nombre=tablaDatosFactura.getValueAt(i, 2).toString();
            cliente=new Cliente();
            producto=new Producto();
            cliente=controladorCliente.buscarCliente(cedula);
            producto=controladorProducto.verProducto(nombre);
            factura=new Factura(numeroF, cantidad, true, subtotal, iva, total, cliente, producto); 
           facturas.add(factura);
        }
        controladorfactura.crearFactura(facturas);
        productosTabla = new HashSet<>();
        txtFacturaNumero.setText(controladorfactura.codigo()+"");
        limpiar();
        actualizarVista();

    }//GEN-LAST:event_botonGuardarFacturaActionPerformed

    /**
     * botonRegistrarClienteActionPerformed.
     * 
     * Este evento lo que hace es registrar a un nuevo cliente para poder crear 
     * una factura. 
     * 
     * @param evt 
     */
    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        if (!txtCedula.getText().equals("") && !txtLocal.getText().equals("") && !txtNombre.getText().equals("")
                && !txtApellido.getText().equals("") && !txtDireccion.getText().equals("") && !txtTelefono.getText().equals("")) {
            String cedula = txtCedula.getText();
            String local = txtLocal.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            controladorCliente.crearCliente(cedula, nombre, apellido, local, telefono, direccion);
            btnRegistrarCliente.setEnabled(false);
            desActivarTextBoxs();
        } else {
            JOptionPane.showMessageDialog(null, alerta027, alerta028, JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnRegistrarClienteActionPerformed
    public void actualizarCmbx() {
        cmbxBodega.removeAllItems();

        cmbxBodega.addItem("--SELECCIONE UNA BODEGA--");
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
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonGuardarFactura;
    private javax.swing.JButton botonProductos;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JComboBox<String> cmbxBodega;
    private javax.swing.JComboBox<String> cmbxProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFacturaNumero;
    private javax.swing.JLabel lblFechaDeEmision;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSeleccionarB;
    private javax.swing.JLabel lblSeleccionarP;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTlFactura;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaDatosFactura;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFacturaNumero;
    private javax.swing.JTextField txtFechaDeEmision;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
