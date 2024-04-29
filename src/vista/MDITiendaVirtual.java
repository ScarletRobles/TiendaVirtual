/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package vista;
import java.beans.PropertyVetoException;
import modelo.ConexionBD;

/**
 *
 * @author SENA
 */
public class MDITiendaVirtual extends javax.swing.JFrame {
    
    FRMAdministrador   fAdministrador;
    FRMProducto        fProducto;
    FRMCliente         fCliente;
    FRMProveedor       fProveedor;
    static FRMVenta           fVenta;
    FRMLogin           fLogin;
    FRMRol             fRol;
    FRMUsuario         fUsuario;
    static FRMFactura         fFactura;
    FRMAuditoria       fAuditoria;
    
    
    public MDITiendaVirtual(){
        ConexionBD.getInstance();
        initComponents();
        fAdministrador = new FRMAdministrador();
        fProducto      = new FRMProducto();
        fCliente       = new FRMCliente();
        fProveedor     = new FRMProveedor();
        fVenta         = new FRMVenta();
        fLogin         = new FRMLogin();
        fRol           = new FRMRol();
        fUsuario       = new FRMUsuario();
        fFactura       = new  FRMFactura();
        fAuditoria     = new FRMAuditoria();
        
        escritorio.add(fAdministrador);
        escritorio.add(fProducto);
        escritorio.add(fCliente);
        escritorio.add(fProveedor);
        escritorio.add(fVenta);
        escritorio.add(fLogin);
        escritorio.add(fRol);
        escritorio.add(fUsuario);
        escritorio.add(fFactura);
        escritorio.add(fAuditoria);
         
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        MNUAdministrar = new javax.swing.JMenu();
        ItemCliente = new javax.swing.JMenuItem();
        ItemProducto = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        ItemDetalle = new javax.swing.JMenuItem();
        ItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MNUAdministrar.setMnemonic('f');
        MNUAdministrar.setText("Administrar");

        ItemCliente.setMnemonic('o');
        ItemCliente.setText("Cliente");
        ItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemClienteActionPerformed(evt);
            }
        });
        MNUAdministrar.add(ItemCliente);

        ItemProducto.setMnemonic('s');
        ItemProducto.setText("Producto");
        ItemProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemProductoActionPerformed(evt);
            }
        });
        MNUAdministrar.add(ItemProducto);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Factura");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        MNUAdministrar.add(saveAsMenuItem);

        ItemDetalle.setMnemonic('x');
        ItemDetalle.setText("Detalle");
        ItemDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemDetalleActionPerformed(evt);
            }
        });
        MNUAdministrar.add(ItemDetalle);

        ItemSalir.setText("Salir");
        ItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemSalirActionPerformed(evt);
            }
        });
        MNUAdministrar.add(ItemSalir);

        menuBar.add(MNUAdministrar);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void ItemDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemDetalleActionPerformed
        fVenta = new FRMVenta();
        escritorio.add(fVenta);
        fVenta.setVisible(true);
    }//GEN-LAST:event_ItemDetalleActionPerformed

    private void ItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemClienteActionPerformed
        fCliente = new FRMCliente();
        escritorio.add(fCliente);
        fCliente.setVisible(true);
    }//GEN-LAST:event_ItemClienteActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        fFactura = new FRMFactura();
        escritorio.add(fFactura);
        fFactura.setVisible(true);
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void ItemProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemProductoActionPerformed
        fProducto = new FRMProducto();
        escritorio.add(fProducto);
        fProducto.setVisible(true);
    }//GEN-LAST:event_ItemProductoActionPerformed

    private void ItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemSalirActionPerformed
        ConexionBD.desconectar();
        try{

            fProducto.setClosed(true);
            fCliente.setClosed(true);
            fProveedor.setClosed(true);
            fVenta.setClosed(true);
            fLogin.setClosed(true);
            fRol.setClosed(true);
            fUsuario.setClosed(true);
            fFactura.setClosed(true);
            fAuditoria.setClosed(true);

        }catch (PropertyVetoException ex){
            System.err.println("Error al salir:"+ex.getMessage());
        }
        System.exit(0);
    }//GEN-LAST:event_ItemSalirActionPerformed

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
            java.util.logging.Logger.getLogger(MDITiendaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDITiendaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDITiendaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDITiendaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDITiendaVirtual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemCliente;
    private javax.swing.JMenuItem ItemDetalle;
    private javax.swing.JMenuItem ItemProducto;
    private javax.swing.JMenuItem ItemSalir;
    private javax.swing.JMenu MNUAdministrar;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem saveAsMenuItem;
    // End of variables declaration//GEN-END:variables

}
