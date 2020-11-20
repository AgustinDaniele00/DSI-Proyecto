package openShop;

public class gestorTransporte extends javax.swing.JFrame {

    public gestorTransporte() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        seleccionarTransporte();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        checkCorreo = new javax.swing.JCheckBox();
        checkOCCA = new javax.swing.JCheckBox();
        checkAndreani = new javax.swing.JCheckBox();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 54)); // NOI18N
        jLabel1.setText("OPEN SHOP");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("EL TRANSPORTE ELEGIDO FUE");

        checkCorreo.setText("Correo Argentino");
        checkCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCorreoActionPerformed(evt);
            }
        });

        checkOCCA.setText("OCCA");
        checkOCCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOCCAActionPerformed(evt);
            }
        });

        checkAndreani.setText("Andreani");
        checkAndreani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAndreaniActionPerformed(evt);
            }
        });

        btnSiguiente.setText("SIGUIENTE");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSiguiente)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(checkAndreani, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkOCCA, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel1)
                        .addComponent(checkCorreo)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(checkCorreo)
                .addGap(18, 18, 18)
                .addComponent(checkOCCA)
                .addGap(18, 18, 18)
                .addComponent(checkAndreani)
                .addGap(18, 18, 18)
                .addComponent(btnSiguiente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void seleccionarTransporte()
    {
        if(transporte1.getPrecio() < transporte2.getPrecio() && transporte1.getPrecio() < transporte3.getPrecio())
        {
            checkCorreo.setSelected(true);
            checkAndreani.setEnabled(false);
            checkOCCA.setEnabled(false);
        }
        else if(transporte2.getPrecio() < transporte1.getPrecio() && transporte2.getPrecio() < transporte3.getPrecio())
        {
            checkOCCA.setSelected(true);
            checkAndreani.setEnabled(false);
            checkCorreo.setEnabled(false);
        }
        else if(transporte3.getPrecio() < transporte1.getPrecio() && transporte3.getPrecio() < transporte2.getPrecio())
        {
            checkAndreani.setSelected(true);
            checkOCCA.setEnabled(false);
            checkCorreo.setEnabled(false);
        } else{
            checkOCCA.setEnabled(true);
            checkAndreani.setEnabled(true);
            checkCorreo.setEnabled(true);
            btnSiguiente.setEnabled(false);
        }   
    }
    
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        gestorPedido ventana4 = new gestorPedido();
        ventana4.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void checkCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCorreoActionPerformed
        if(checkCorreo.isSelected())
        {
            checkAndreani.setEnabled(false);
            checkOCCA.setEnabled(false);
            btnSiguiente.setEnabled(true);
        }
        else
        {
            checkAndreani.setEnabled(true);
            checkOCCA.setEnabled(true);
            btnSiguiente.setEnabled(false);
        }
    }//GEN-LAST:event_checkCorreoActionPerformed

    private void checkOCCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOCCAActionPerformed
       if(checkOCCA.isSelected())
        {
            checkAndreani.setEnabled(false);
            checkCorreo.setEnabled(false);
            btnSiguiente.setEnabled(true);
        }
        else
        {
            checkAndreani.setEnabled(true);
            checkCorreo.setEnabled(true);
            btnSiguiente.setEnabled(false);
        }
    }//GEN-LAST:event_checkOCCAActionPerformed

    private void checkAndreaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAndreaniActionPerformed
       if(checkAndreani.isSelected())
        {
            checkOCCA.setEnabled(false);
            checkCorreo.setEnabled(false);
            btnSiguiente.setEnabled(true);
        }
        else
        {
            checkOCCA.setEnabled(true);
            checkCorreo.setEnabled(true);
            btnSiguiente.setEnabled(false);
        }
    }//GEN-LAST:event_checkAndreaniActionPerformed

    public static Transporte transporte1 = new Transporte("Correo Argentino", "Independencia 87", 541);
    public static Transporte transporte2 = new Transporte("OCCA", "Buenos Aires 324", 542);
    public static Transporte transporte3 = new Transporte("Andreani", "Colon 1254", 543);
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new gestorTransporte().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JCheckBox checkAndreani;
    private javax.swing.JCheckBox checkCorreo;
    private javax.swing.JCheckBox checkOCCA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
