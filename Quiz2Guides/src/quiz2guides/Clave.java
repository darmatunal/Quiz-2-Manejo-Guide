/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2guides;

import java.awt.Color;

/**
 *
 * @author Dario Arango
 */
public class Clave extends javax.swing.JFrame {

    /**
     * Creates new form Clave
     */
    String Clave1;
    Boolean Open=false;
    Boolean Close=true;
    
    public Clave() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ENTER = new javax.swing.JButton();
        CHANGEKEY = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ENTER.setBackground(new java.awt.Color(255, 0, 0));
        ENTER.setForeground(new java.awt.Color(51, 51, 255));
        ENTER.setText("Open/Close");
        ENTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ENTERActionPerformed(evt);
            }
        });

        CHANGEKEY.setText("Change Combination");
        CHANGEKEY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHANGEKEYActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(CHANGEKEY)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(ENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CHANGEKEY)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ENTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ENTERActionPerformed
        // TODO add your handling code here:
        if (this.jTextField1.getText().length()!=0 && this.Open==false) {
            if (this.jTextField1.getText().equals(this.Clave1)) {
                System.out.println("Open es falso");
             this.ENTER.setBackground(Color.GREEN);    
             Open=true;
            }
        }else{
          if (this.jTextField1.getText().length()!=0 && this.Open==true) {
            if (this.jTextField1.getText().equals(this.Clave1)) {
             this.ENTER.setBackground(Color.RED); 
             System.out.println("Open es verdadero");
              Open=false;
            }
        }
        } 
        this.jTextField1.setText(null);
    }//GEN-LAST:event_ENTERActionPerformed

    private void CHANGEKEYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHANGEKEYActionPerformed
    
        if (this.jTextField1.getText().length()!=0) {
            this.Clave1=this.jTextField1.getText();
            this.jTextField1.setText(null);
        }
        
    }//GEN-LAST:event_CHANGEKEYActionPerformed

    /**
     * @param args tDari command line arguments
     */
    public static void main(String args[]) {
        
        // TODO code application logic here
    Clave C=new Clave();
    C.setTitle("LOCK");
    C.setVisible(true);
    C.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CHANGEKEY;
    private javax.swing.JButton ENTER;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
