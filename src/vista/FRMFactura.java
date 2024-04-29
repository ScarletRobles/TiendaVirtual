/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.ControladorFactura;
import controlador.ControladorProducto;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import modelo.Factura;
import modelo.Producto;
import modelo.Venta;
import java.sql.PreparedStatement;
import modelo.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;
import vista.FRMVenta;

/**
 *
 * @author SENA
 */
public class FRMFactura extends javax.swing.JInternalFrame {

    ControladorProducto ControladorProducto = new ControladorProducto();
    int total = 0;
    /**
     * Creates new form FRMProducto
     */
    public FRMFactura() {
        initComponents();
        TXTIdProducto.setValue(0);
        TXTIdProducto.setVisible(false);
        llenarTabla();
        //llamar combobox
        cargarCliente();

    }

    public void llenarTabla() {
        Producto unProducto = new Producto();
        DefaultTableModel tabla = (DefaultTableModel) TBLProducto.getModel();
        Iterator<Producto> itProducto = unProducto.listar();
        Object[] filaProducto = new Object[TBLProducto.getColumnCount()];
        tabla.setRowCount(0);
        while (itProducto.hasNext()) {
            unProducto = itProducto.next();
            filaProducto[0] = unProducto.getIdProducto();
            filaProducto[1] = unProducto.getNombreProducto();
            filaProducto[2] = unProducto.getPrecioProducto();
            filaProducto[3] = unProducto.getStockProducto();
            tabla.addRow(filaProducto);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem6 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem7 = new javax.swing.JCheckBoxMenuItem();
        popupMenu1 = new java.awt.PopupMenu();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        popupMenu2 = new java.awt.PopupMenu();
        jCheckBoxMenuItem8 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem9 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem10 = new javax.swing.JCheckBoxMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jProgressBar1 = new javax.swing.JProgressBar();
        jColorChooser1 = new javax.swing.JColorChooser();
        jProgressBar2 = new javax.swing.JProgressBar();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBLProducto = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBLCompra = new javax.swing.JTable();
        BTNComprar = new javax.swing.JButton();
        TXTIdProducto = new javax.swing.JFormattedTextField();
        ComboCliente = new javax.swing.JComboBox<>();
        TXTCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("jCheckBoxMenuItem4");

        jCheckBoxMenuItem5.setSelected(true);
        jCheckBoxMenuItem5.setText("jCheckBoxMenuItem5");

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem6.setSelected(true);
        jCheckBoxMenuItem6.setText("jCheckBoxMenuItem6");

        jCheckBoxMenuItem7.setSelected(true);
        jCheckBoxMenuItem7.setText("jCheckBoxMenuItem7");

        popupMenu1.setLabel("popupMenu1");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        popupMenu2.setLabel("popupMenu2");

        jCheckBoxMenuItem8.setSelected(true);
        jCheckBoxMenuItem8.setText("jCheckBoxMenuItem8");

        jCheckBoxMenuItem9.setSelected(true);
        jCheckBoxMenuItem9.setText("jCheckBoxMenuItem9");

        jCheckBoxMenuItem10.setSelected(true);
        jCheckBoxMenuItem10.setText("jCheckBoxMenuItem10");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jRadioButton1.setText("jRadioButton1");

        jCheckBox1.setText("jCheckBox1");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(jEditorPane1);

        setBackground(new java.awt.Color(51, 153, 0));
        setClosable(true);
        setForeground(new java.awt.Color(51, 153, 0));
        setTitle("Factura");
        setToolTipText("");

        TBLProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Precio", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBLProducto);

        TBLCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre  Cliente", "ID Producto", "Nombre", "Precio", "Cantidad", "Subtotal"
            }
        ));
        TBLCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLCompraMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TBLCompra);

        BTNComprar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        BTNComprar.setForeground(new java.awt.Color(0, 102, 51));
        BTNComprar.setText("Comprar");
        BTNComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNComprarMouseClicked(evt);
            }
        });
        BTNComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNComprarActionPerformed(evt);
            }
        });

        TXTIdProducto.setText("0");
        TXTIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTIdProductoActionPerformed(evt);
            }
        });

        ComboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboClienteActionPerformed(evt);
            }
        });

        TXTCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTCantidadActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("Carrito");

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Cantidad de producto");

        jLabel3.setText("Seleccione los productos que desea :)");

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 51));
        jLabel5.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Engravers MT", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("SYK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(504, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(34, 34, 34))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(117, 117, 117)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TXTCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(205, 205, 205)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TXTIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTNComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TXTIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addGap(60, 60, 60)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXTCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXTIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTIdProductoActionPerformed

    private void TBLCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLCompraMouseClicked

    }//GEN-LAST:event_TBLCompraMouseClicked

    private void TBLProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLProductoMouseClicked
        // TODO add your handling code here:
        System.out.println("entra a mouse click");
        if (evt.getClickCount() == 2) {

            int cantidad = Integer.parseInt(TXTCantidad.getText());
            int fila = TBLProducto.rowAtPoint(evt.getPoint());
            Cliente miCliente = (Cliente) ComboCliente.getSelectedItem();

            if (fila > -1) {
                Object[] filaProducto = new Object[TBLCompra.getColumnCount()];
                DefaultTableModel tabla = (DefaultTableModel) TBLCompra.getModel();

                filaProducto[0] = miCliente.getNombreCliente();
                filaProducto[1] = TBLProducto.getValueAt(fila, 0);
                filaProducto[2] = TBLProducto.getValueAt(fila, 1);
                filaProducto[3] = TBLProducto.getValueAt(fila, 2);
                filaProducto[4] = cantidad;
                filaProducto[5] = Integer.parseInt(filaProducto[4] + "") * Integer.parseInt(TBLProducto.getValueAt(fila, 2) + "");//TBLProducto.getValueAt(fila,3);
                total = Integer.parseInt(total +"") + Integer.parseInt(filaProducto[5]+"");
                tabla.addRow(filaProducto);

            }
        }
    }//GEN-LAST:event_TBLProductoMouseClicked

    private void BTNComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNComprarActionPerformed
        System.out.println("entra a comprar");
        Factura miFactura = new Factura();
        Cliente mC = (Cliente) ComboCliente.getSelectedItem();
        miFactura.setIdCliente(mC.getIdCliente());
        miFactura.setSubTotal(total);
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        miFactura.setFechaFactura(sqlDate);
        int idF = miFactura.insertar();
        System.out.println("abrir ventana " + idF);

        int rows = TBLCompra.getRowCount();
        
        for (int i = 0; i < rows; i++) {
            Venta miVenta = new Venta();
            System.out.println("realizar detalle");
            miVenta.setIdFactura(idF);
            miVenta.setIdProducto((int)TBLCompra.getValueAt(i, 1));
            miVenta.setCantidadProducto((int)TBLCompra.getValueAt(i,4 ));
            
            miVenta.setValorDetalle(Integer.parseInt(TBLCompra.getValueAt(i, 5)+""));
            miVenta.insertar();
        }


    }//GEN-LAST:event_BTNComprarActionPerformed

    private void BTNComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNComprarMouseClicked


    }//GEN-LAST:event_BTNComprarMouseClicked

    private void ComboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboClienteActionPerformed

    private void TXTCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTCantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNComprar;
    private javax.swing.JComboBox<Cliente> ComboCliente;
    private javax.swing.JTable TBLCompra;
    private javax.swing.JTable TBLProducto;
    private javax.swing.JTextField TXTCantidad;
    private javax.swing.JFormattedTextField TXTIdProducto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem10;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem7;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem8;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem9;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    // End of variables declaration//GEN-END:variables

    private void cargarCliente() {
        try {
            Cliente unCliente = new Cliente();
            unCliente.setNombreCliente("selecione cliente ");
            ComboCliente.removeAllItems();
            ComboCliente.addItem(unCliente);
            Iterator rs = unCliente.listar();
            while (rs.hasNext()) {
                ComboCliente.addItem((Cliente) rs.next());
            }
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
    }

}
