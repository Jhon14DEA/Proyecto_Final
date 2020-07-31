/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.DAO.*;
import ec.edu.ups.controlador.*;
import ec.edu.ups.modelo.*;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * @author Sebastian Uyaguari
 * @author Denys Dutan
 * @author John Fárez
 * @author Santiago Cabrera
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    VentanaIniciarSesion ventanaIniciarSesion;
    VentanaCliente ventanCliente;
    VentanaBodega ventanaBodega;
    VentanaProductos ventanaProductos;
    VentanaFactura ventanaFactura;
    VentanaRegistrarseUsuario ventanaRegistrarUsuario;
    VentanaUsuario ventanaUsuario;
    VentanaRegistrarCliente ventanaRegistrarCliente;
    VentanaListarFacturas ventanaListarFacturas;

    UsuarioDAO usuarioDao;
    ClienteDAO clienteDao;
    ProductoDAO productoDAO;
    BodegaDAO bodegaDAO;
    FacturaDAO facturaDAO;

    private Bodega bodega;
    private Producto producto;
    private Cliente cliente;
    private Usuario usuario;
    private Factura factura;

    ControladorUsuario controladorUsuario;
    ControladorProducto controladorProducto;
    ControladorBodega controladorBodega;
    ControladorFactura controladorFactura;
    ControladorCliente controladorCliente;
    //clasees para localizacion 
    private Locale localizacion;
    private ResourceBundle mensajes;

    public VentanaPrincipal() {
        initComponents();

        bodegaDAO = new BodegaDAO();
        productoDAO = new ProductoDAO(bodegaDAO);
        facturaDAO = new FacturaDAO();
        usuarioDao = new UsuarioDAO();
        clienteDao = new ClienteDAO();

        bodega = new Bodega();
        producto = new Producto();
        factura = new Factura();
        cliente = new Cliente();
        usuario = new Usuario();

        controladorUsuario = new ControladorUsuario(usuarioDao);
        controladorCliente = new ControladorCliente(clienteDao);
        controladorProducto = new ControladorProducto(bodega, bodegaDAO, productoDAO, producto);
        controladorBodega = new ControladorBodega(bodega, bodegaDAO);
        controladorFactura = new ControladorFactura();

        ventanaIniciarSesion = new VentanaIniciarSesion(controladorUsuario, this);
        ventanCliente = new VentanaCliente(controladorCliente);
        ventanaBodega = new VentanaBodega(controladorBodega);
        ventanaProductos = new VentanaProductos(controladorProducto, controladorBodega);
        ventanaFactura = new VentanaFactura(controladorBodega, bodega, controladorCliente, cliente, controladorFactura, factura, controladorProducto, producto);
        ventanaListarFacturas = new VentanaListarFacturas(controladorBodega, bodega, controladorCliente, cliente, controladorFactura, factura,
                controladorProducto, producto);
        ventanaRegistrarUsuario = new VentanaRegistrarseUsuario(controladorUsuario);
        ventanaUsuario = new VentanaUsuario(controladorUsuario);
        ventanaRegistrarCliente = new VentanaRegistrarCliente(controladorCliente);
        //idiomas
        localizacion = new Locale("es", "EC");
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idioma.mensaje", localizacion);
    }

    public void cambiarIdioma(String idioma, String localidad) {
        localizacion = new Locale(idioma, localidad);
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idioma.mensaje", localizacion);
        if (ventanaRegistrarCliente != null) {
            ventanaProductos.setRecurso(mensajes);
            ventanaProductos.cambiarIdioma(idioma, localidad);
            ventanaRegistrarCliente.setRecurso(mensajes);
            ventanaRegistrarCliente.cambiarIdioma(idioma, localidad);
            ventanaRegistrarUsuario.setRecurso(mensajes);
            ventanaRegistrarUsuario.cambiarIdioma(idioma, localidad);
            ventanaUsuario.setRecurso(mensajes);
            ventanaUsuario.cambiarIdioma(idioma, localidad);
            ventanaBodega.setRecurso(mensajes);
            ventanaBodega.cambiarIdioma(idioma, localidad);
            ventanaFactura.setRecurso(mensajes);
            ventanaFactura.cambiarIdioma(idioma, localidad);
            ventanCliente.setRecurso(mensajes);
            ventanCliente.cambiarIdioma(idioma, localidad);
            ventanaListarFacturas.setRecurso(mensajes);
            ventanaListarFacturas.cambiarIdioma(idioma, localidad);
            ventanaListarFacturas.setRecurso(mensajes);
            ventanaListarFacturas.cambiarIdiomas(idioma, localidad);
            ventanaIniciarSesion.setRecurso(mensajes);
            ventanaIniciarSesion.cambiarIdioma(idioma, localidad);
            
        }
        
        
        //Ventana Principal
        
         menuInicio.setText(mensajes.getString("menuInicio"));
        menuGestionClientes.setText(mensajes.getString("menuGestionClientes"));
        menuIdioma.setText(mensajes.getString("menuIdioma"));
        menuItemIngles.setText(mensajes.getString("menuItemIngles"));
        menuItemEspaniol.setText(mensajes.getString("menuItemEspaniol"));
        menuItemIniciarSesion.setText(mensajes.getString("menuItemIniciarSesion"));
        menuItemRegistrarCliente.setText(mensajes.getString("menuItemRegistrarUsuario"));
        menuItemRegistrarCliente.setText(mensajes.getString("menuItemRegistrarCliente"));
        menuItemCerrarSesion.setText(mensajes.getString("menuItemCerrarSesion"));
        menuItemSalir.setText(mensajes.getString("menuItemSalir"));
        menuItemClientes.setText(mensajes.getString("menuItemClientes"));
        menuItemGestionUsuarios.setText(mensajes.getString("menuItemGestionUsuarios"));
        menuItemProductos.setText(mensajes.getString("menuItemProductos"));
        menuItemFacturas.setText(mensajes.getString("menuItemFacturas"));
        menuItemBodega.setText(mensajes.getString("menuItemBodega"));
        menuItemListaF.setText(mensajes.getString("menuItemListaF"));
        
              //Iniciar Sesion
        ventanaIniciarSesion.setTitle(mensajes.getString("menuItemIniciarSesion"));
        ventanaIniciarSesion.getIniciarSesion().setText(mensajes.getString("lblIniciarSesion"));
        ventanaIniciarSesion.getCorreo().setText(mensajes.getString("labelCorreoElectronico"));
        ventanaIniciarSesion.getPassword().setText(mensajes.getString("lblContrasena"));
        ventanaIniciarSesion.getBtnInciarSesion().setText(mensajes.getString("btnIniciarSesion"));
        ventanaIniciarSesion.getLimpiar().setText(mensajes.getString("btnLimpiar"));
                
        
        //Ventana Bodega
        ventanaBodega.setTitle(mensajes.getString("lblGestionDeBodega"));
        ventanaBodega.getGestionBodega().setText(mensajes.getString("lblGestionDeBodega"));
        ventanaBodega.getBodega().setText(mensajes.getString("lblBodega"));
        ventanaBodega.getBotonBuscar().setText(mensajes.getString("btnBuscar"));
        ventanaBodega.getInformacion().setText(mensajes.getString("lblInformacion"));
        ventanaBodega.getNombre().setText(mensajes.getString("lblNombre"));
        ventanaBodega.getDireccion().setText(mensajes.getString("lblDireccion"));
        ventanaBodega.getCiudad().setText(mensajes.getString("lblCiudad"));
        ventanaBodega.getBotonNuevo().setText(mensajes.getString("btnNuevo"));
        ventanaBodega.getBotonActualizar().setText(mensajes.getString("btnActualizar"));
        ventanaBodega.getBotonCancelar().setText(mensajes.getString("botonEliminar"));
        ventanaBodega.getBotonEliminar().setText(mensajes.getString("botonCancelar"));
        
           //Ventana Cliente
           
        ventanCliente.setTitle(mensajes.getString("lblGestionClientes"));
        ventanCliente.getGestionClientes().setText(mensajes.getString("lblGestionClientes"));
        ventanCliente.getCedula().setText(mensajes.getString("lblCedula"));
        ventanCliente.getBotonBuscar().setText(mensajes.getString("btnBuscar"));
        ventanCliente.getInformacion().setText(mensajes.getString("lblInformacion"));
        ventanCliente.getCedulaa().setText(mensajes.getString("lblCedulaa"));
        ventanCliente.getNombre().setText(mensajes.getString("lblNombre"));
        ventanCliente.getApellido().setText(mensajes.getString("lblApellido"));
        ventanCliente.getNombreLocal().setText(mensajes.getString("lblNombreLocal"));
        ventanCliente.getTelefono().setText(mensajes.getString("lblTelefono"));
        ventanCliente.getDireccion().setText(mensajes.getString("lblDireccion"));
        ventanCliente.getBotonActualizar().setText(mensajes.getString("btnActualizarCliente"));
        ventanCliente.getBotonCancelar().setText(mensajes.getString("btnCancelarCliente"));
        ventanCliente.getBotonEliminar().setText(mensajes.getString("btnEliminarCliente"));
        ventanCliente.getListar().setText(mensajes.getString("btnListarClientes"));
        ventanCliente.getLimpiar().setText(mensajes.getString("btnLimpiar"));

        //Ventana Listar Factura
        ventanaListarFacturas.getListarFacturas().setText(mensajes.getString("lblListarFacturas"));
        ventanaListarFacturas.getBotonAnular().setText(mensajes.getString("botonAnular"));
        ventanaListarFacturas.getVer().setText(mensajes.getString("botonVerDetalles"));
        ventanaListarFacturas.getLimpiar().setText(mensajes.getString("botonClear"));
        ventanaListarFacturas.getListarAnuladas().setText(mensajes.getString("botonListarAnuladas"));
        ventanaListarFacturas.getListarValidas().setText(mensajes.getString("botonListarValidas"));
        ventanaListarFacturas.getCedula().setText(mensajes.getString("lblCedula"));
        ventanaListarFacturas.getNombre().setText(mensajes.getString("lblNombre"));
        ventanaListarFacturas.getApellido().setText(mensajes.getString("lblApellido"));
        ventanaListarFacturas.getLocal().setText(mensajes.getString("lblLocal"));
        ventanaListarFacturas.getDireccion().setText(mensajes.getString("lblDireccion"));
        ventanaListarFacturas.getTelefono().setText(mensajes.getString("lblTelefono"));

   
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuItemIniciarSesion = new javax.swing.JMenuItem();
        menuItemRegistrarCliente = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuItemCerrarSesion = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();
        menuGestionClientes = new javax.swing.JMenu();
        menuItemClientes = new javax.swing.JMenuItem();
        menuItemGestionUsuarios = new javax.swing.JMenuItem();
        menuItemProductos = new javax.swing.JMenuItem();
        menuItemFacturas = new javax.swing.JMenuItem();
        menuItemBodega = new javax.swing.JMenuItem();
        menuItemListaF = new javax.swing.JMenuItem();
        menuIdioma = new javax.swing.JMenu();
        menuItemEspaniol = new javax.swing.JMenuItem();
        menuItemIngles = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        menuInicio.setMnemonic('f');
        menuInicio.setText("Inicio");

        menuItemIniciarSesion.setMnemonic('o');
        menuItemIniciarSesion.setText("Iniciar Sesion ");
        menuItemIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIniciarSesionActionPerformed(evt);
            }
        });
        menuInicio.add(menuItemIniciarSesion);

        menuItemRegistrarCliente.setText("Registrar usuario");
        menuItemRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRegistrarClienteActionPerformed(evt);
            }
        });
        menuInicio.add(menuItemRegistrarCliente);

        jMenuItem2.setText("Registrar cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuInicio.add(jMenuItem2);

        menuItemCerrarSesion.setText("Cerrar Sesion");
        menuItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCerrarSesionActionPerformed(evt);
            }
        });
        menuInicio.add(menuItemCerrarSesion);

        menuItemSalir.setMnemonic('x');
        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuInicio.add(menuItemSalir);

        menuBar.add(menuInicio);

        menuGestionClientes.setMnemonic('e');
        menuGestionClientes.setText(" Gestion");

        menuItemClientes.setMnemonic('t');
        menuItemClientes.setText("Gestion Clientes");
        menuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClientesActionPerformed(evt);
            }
        });
        menuGestionClientes.add(menuItemClientes);

        menuItemGestionUsuarios.setText("Gestion Usuarios");
        menuItemGestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGestionUsuariosActionPerformed(evt);
            }
        });
        menuGestionClientes.add(menuItemGestionUsuarios);

        menuItemProductos.setMnemonic('y');
        menuItemProductos.setText("Gesion Productos");
        menuItemProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProductosActionPerformed(evt);
            }
        });
        menuGestionClientes.add(menuItemProductos);

        menuItemFacturas.setMnemonic('p');
        menuItemFacturas.setText("Gestion Facturas");
        menuItemFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFacturasActionPerformed(evt);
            }
        });
        menuGestionClientes.add(menuItemFacturas);

        menuItemBodega.setMnemonic('d');
        menuItemBodega.setText("Gestion bodegas");
        menuItemBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBodegaActionPerformed(evt);
            }
        });
        menuGestionClientes.add(menuItemBodega);

        menuItemListaF.setMnemonic('d');
        menuItemListaF.setText("Listar Facturas");
        menuItemListaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListaFActionPerformed(evt);
            }
        });
        menuGestionClientes.add(menuItemListaF);

        menuBar.add(menuGestionClientes);

        menuIdioma.setMnemonic('h');
        menuIdioma.setText("Idioma");

        menuItemEspaniol.setMnemonic('c');
        menuItemEspaniol.setText("Español");
        menuItemEspaniol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEspaniolActionPerformed(evt);
            }
        });
        menuIdioma.add(menuItemEspaniol);

        menuItemIngles.setMnemonic('a');
        menuItemIngles.setText("Ingles");
        menuItemIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInglesActionPerformed(evt);
            }
        });
        menuIdioma.add(menuItemIngles);

        menuBar.add(menuIdioma);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void menuItemBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBodegaActionPerformed

        desktopPane.add(ventanaBodega);
        ventanaBodega.setVisible(true);

    }//GEN-LAST:event_menuItemBodegaActionPerformed

    private void menuItemIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIniciarSesionActionPerformed

        desktopPane.add(ventanaIniciarSesion);
        ventanaIniciarSesion.setVisible(true);


    }//GEN-LAST:event_menuItemIniciarSesionActionPerformed

    private void menuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClientesActionPerformed

        desktopPane.add(ventanCliente);
        ventanCliente.setVisible(true);

    }//GEN-LAST:event_menuItemClientesActionPerformed

    private void menuItemProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProductosActionPerformed

        desktopPane.add(ventanaProductos);
        ventanaProductos.setVisible(true);


    }//GEN-LAST:event_menuItemProductosActionPerformed

    private void menuItemFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFacturasActionPerformed

        desktopPane.add(ventanaFactura);
        ventanaFactura.setVisible(true);


    }//GEN-LAST:event_menuItemFacturasActionPerformed

    private void menuItemRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRegistrarClienteActionPerformed

        desktopPane.add(ventanaRegistrarUsuario);
        ventanaRegistrarUsuario.setVisible(true);

    }//GEN-LAST:event_menuItemRegistrarClienteActionPerformed

    private void menuItemGestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGestionUsuariosActionPerformed

        desktopPane.add(ventanaUsuario);
        ventanaUsuario.setVisible(true);

    }//GEN-LAST:event_menuItemGestionUsuariosActionPerformed

    private void menuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCerrarSesionActionPerformed

        menuGestionClientes.setVisible(false);
        menuItemCerrarSesion.setVisible(false);
        menuItemIniciarSesion.setVisible(true);
        menuItemRegistrarCliente.setVisible(true);

    }//GEN-LAST:event_menuItemCerrarSesionActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        desktopPane.add(ventanaRegistrarCliente);
        ventanaRegistrarCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuItemListaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListaFActionPerformed
        desktopPane.add(ventanaListarFacturas);
        ventanaListarFacturas.setVisible(true);

    }//GEN-LAST:event_menuItemListaFActionPerformed

    private void menuItemEspaniolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEspaniolActionPerformed
        // TODO add your handling code here:
        localizacion = new Locale("es", "EC");
        this.cambiarIdioma("es", "EC");
    }//GEN-LAST:event_menuItemEspaniolActionPerformed

    private void menuItemInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInglesActionPerformed
        localizacion = new Locale("en", "EU");
        this.cambiarIdioma("en", "EU");
    }//GEN-LAST:event_menuItemInglesActionPerformed

    public JMenu getMenu() {

        return menuInicio;

    }

    public JMenuItem getMenuIniciarSesion() {

        return menuItemIniciarSesion;

    }

    public JMenuItem getMenuRegistrarse() {

        return menuItemRegistrarCliente;
    }

    public JMenuItem getMenuCerrarSesion() {

        return menuItemCerrarSesion;

    }

    public JMenu getMenuGestionar() {

        return menuGestionClientes;

    }

    public JMenuItem getMenuSalir() {

        return menuItemSalir;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuGestionClientes;
    private javax.swing.JMenu menuIdioma;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemBodega;
    private javax.swing.JMenuItem menuItemCerrarSesion;
    private javax.swing.JMenuItem menuItemClientes;
    private javax.swing.JMenuItem menuItemEspaniol;
    private javax.swing.JMenuItem menuItemFacturas;
    private javax.swing.JMenuItem menuItemGestionUsuarios;
    private javax.swing.JMenuItem menuItemIngles;
    private javax.swing.JMenuItem menuItemIniciarSesion;
    private javax.swing.JMenuItem menuItemListaF;
    private javax.swing.JMenuItem menuItemProductos;
    private javax.swing.JMenuItem menuItemRegistrarCliente;
    private javax.swing.JMenuItem menuItemSalir;
    // End of variables declaration//GEN-END:variables

}
