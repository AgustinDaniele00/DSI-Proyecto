package openShop;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import static openShop.Inicio.i;
import static openShop.gestorCliente.ventas;

public class gestorDespacho extends javax.swing.JFrame {

    public gestorDespacho() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        try 
        {
            ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
            JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
            
            for(int j=0; j < ventas.get(i).getProductos().size(); j++)
            {
                productosDespachados.add(new Producto(ventas.get(i).getProductos().get(j).getId(),ventas.get(i).getProductos().get(j).getNombre(),
                                                        ventas.get(i).getProductos().get(j).getMarca(),ventas.get(i).getProductos().get(j).getDescripcion(),
                                                            ventas.get(i).getProductos().get(j).getPrecio(),ventas.get(i).getProductos().get(j).getCantidad()));
            }
            
            envios.add(new Envio(LocalDate.now(), ventas.get(i).getCliente(), ventas.get(i).getProductos()));
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
        jLabel4 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 54)); // NOI18N
        jLabel1.setText("OPEN SHOP");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("¡MUCHAS GRACIAS POR ELEGIRNOS!");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SU PRODUCTO FUE DESPACHDO CON EXITO");

        btnFinalizar.setText("FINALIZAR");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 39, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFinalizar)
                            .addComponent(jLabel1))
                        .addGap(0, 24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnFinalizar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        i++;
        
        if(i < ventas.size())
        {
           Inicio ventana1 = new Inicio();
           ventana1.setVisible(true);
           this.setVisible(false);
        }
        else if(i == ventas.size())
        {
           try 
           {
                JSON_MAPPER.writeValue(new File("src\\openShop\\archivoDespacho.json"),productosDespachados);
           } catch (IOException ex) 
           {
                Logger.getLogger(gestorPedido.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           System.exit(0);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    public static ArrayList<Producto> productosDespachados = new ArrayList<>();
    public static ArrayList<Envio> envios = new ArrayList<>();
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new gestorDespacho().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}