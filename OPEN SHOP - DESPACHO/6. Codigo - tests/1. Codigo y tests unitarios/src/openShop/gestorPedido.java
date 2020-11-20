package openShop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import org.codehaus.jackson.map.ObjectMapper;
import static openShop.Inicio.i;
import static openShop.gestorCliente.ventas;

public class gestorPedido extends javax.swing.JFrame {

    DefaultListModel productos = new DefaultListModel();
    
    public gestorPedido() {
        initComponents();
        this.setLocationRelativeTo(null);
        productos = new DefaultListModel();
        textProductos.setModel(productos);
        
        try 
        {
            ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
            JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
            
            textMonto.setText(cargarMonto());
            obtenerProductos();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(gestorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textProductos = new javax.swing.JList<>();
        btnSiguiente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textMonto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 54)); // NOI18N
        jLabel1.setText("OPEN SHOP");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOS PRODUCTOS DESPACHADOS FUERON:");

        textProductos.setToolTipText("");
        jScrollPane1.setViewportView(textProductos);

        btnSiguiente.setText("SIGUIENTE");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Monto pagado");

        textMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSiguiente)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(85, 85, 85)
                                    .addComponent(textMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))))
                .addGap(0, 44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnSiguiente)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String cargarMonto()
    {
        String monto = String.valueOf(ventas.get(i).getTotalAPagar());
        
        return monto;
    }
    
    public void obtenerProductos()
    {
        for(int j=0; j < ventas.get(i).getProductos().size(); j++)
        {
            productos.addElement("x" + ventas.get(i).getProductos().get(j).getCantidad() + " " + ventas.get(i).getProductos().get(j).getNombre()
                                    + " " + ventas.get(i).getProductos().get(j).getMarca() + " $" + ventas.get(i).getProductos().get(j).getPrecio());
        }
    }
    
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
           gestorDespacho ventana5 = new gestorDespacho();
           ventana5.setVisible(true);
           this.setVisible(false);      
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void textMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMontoActionPerformed
    
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new gestorPedido().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textMonto;
    private javax.swing.JList<String> textProductos;
    // End of variables declaration//GEN-END:variables
}
