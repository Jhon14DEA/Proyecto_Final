/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.DAO.*;
import ec.edu.ups.controlador.*;
import ec.edu.ups.modelo.*;
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

    public VentanaPrincipal() {
        initComponents();
        
        bodegaDAO=new BodegaDAO();
        productoDAO= new ProductoDAO(bodegaDAO);
        facturaDAO=new FacturaDAO();
        usuarioDao = new UsuarioDAO();
        clienteDao = new ClienteDAO();
        
        bodega=new Bodega();
        producto=new Producto();
        factura=new Factura();
        cliente=new Cliente();
        usuario=new Usuario();
        
        
        controladorUsuario = new ControladorUsuario(usuarioDao);
        controladorCliente = new ControladorCliente(clienteDao);
        controladorProducto=new ControladorProducto(bodega, bodegaDAO, productoDAO,producto);
        controladorBodega=new ControladorBodega(bodega, bodegaDAO);
        controladorFactura=new ControladorFactura();

        ventanaIniciarSesion = new VentanaIniciarSesion(controladorUsuario, this);
        ventanCliente = new VentanaCliente(controladorCliente);
        ventanaBodega = new VentanaBodega(controladorBodega);
        ventanaProductos = new VentanaProductos(controladorProducto, controladorBodega);
        ventanaFactura = new VentanaFactura(controladorBodega, bodega, controladorCliente, cliente, controladorFactura, factura, controladorProducto, producto);
        ventanaListarFacturas= new VentanaListarFacturas(controladorBodega,bodega, controladorCliente,cliente, controladorFactura,factura,
                controladorProducto, producto);
        ventanaRegistrarUsuario = new VentanaRegistrarseUsuario(controladorUsuario);
        ventanaUsuario = new VentanaUsuario(controladorUsuario);
        ventanaRegistrarCliente = new VentanaRegistrarCliente(controladorCliente);
        
        

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
        menuItemRegistrarUsuario = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuItemCerrarSesion = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();
        menuGestionClientes = new javax.swing.JMenu();
        menuItemClientes = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuItemProductos = new javax.swing.JMenuItem();
        menuItemFacturas = new javax.swing.JMenuItem();
        menuItemBodega = new javax.swing.JMenuItem();
        menuItemListaF = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        menuItemEspaniol = new javax.swing.JMenuItem();
        menuItemIngles = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        desktopPane.setLayout(null);

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

        menuItemRegistrarUsuario.setText("Registrar usuario");
        menuItemRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRegistrarUsuarioActionPerformed(evt);
            }
        });
        menuInicio.add(menuItemRegistrarUsuario);

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

        jMenuItem1.setText("Gestion Usuarios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuGestionClientes.add(jMenuItem1);

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

        helpMenu.setMnemonic('h');
        helpMenu.setText("Idioma");

        menuItemEspaniol.setMnemonic('c');
        menuItemEspaniol.setText("Español");
        helpMenu.add(menuItemEspaniol);

        menuItemIngles.setMnemonic('a');
        menuItemIngles.setText("Ingles");
        helpMenu.add(menuItemIngles);

        menuBar.add(helpMenu);

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

    private void menuItemRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRegistrarUsuarioActionPerformed

        desktopPane.add(ventanaRegistrarUsuario);
        ventanaRegistrarUsuario.setVisible(true);

    }//GEN-LAST:event_menuItemRegistrarUsuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        desktopPane.add(ventanaUsuario);
        ventanaUsuario.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCerrarSesionActionPerformed
        
        menuGestionClientes.setVisible(false);
        menuItemCerrarSesion.setVisible(false);
        menuItemIniciarSesion.setVisible(true);
        menuItemRegistrarUsuario.setVisible(true);
        
    }//GEN-LAST:event_menuItemCerrarSesionActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        desktopPane.add(ventanaRegistrarCliente);
        ventanaRegistrarCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuItemListaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListaFActionPerformed
        desktopPane.add(ventanaListarFacturas);
        ventanaListarFacturas.setVisible(true);

    }//GEN-LAST:event_menuItemListaFActionPerformed

    public JMenu getMenu() {

        return menuInicio;

    }

    public JMenuItem getMenuIniciarSesion() {

        return menuItemIniciarSesion;

    }

    public JMenuItem getMenuRegistrarse() {

        return menuItemRegistrarUsuario;
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
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuGestionClientes;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuItemBodega;
    private javax.swing.JMenuItem menuItemCerrarSesion;
    private javax.swing.JMenuItem menuItemClientes;
    private javax.swing.JMenuItem menuItemEspaniol;
    private javax.swing.JMenuItem menuItemFacturas;
    private javax.swing.JMenuItem menuItemIngles;
    private javax.swing.JMenuItem menuItemIniciarSesion;
    private javax.swing.JMenuItem menuItemListaF;
    private javax.swing.JMenuItem menuItemProductos;
    private javax.swing.JMenuItem menuItemRegistrarUsuario;
    private javax.swing.JMenuItem menuItemSalir;
    // End of variables declaration//GEN-END:variables

}
