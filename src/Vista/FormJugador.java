/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Cursor;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


/**
 *
 * @author CORE I3
 */
public class FormJugador extends javax.swing.JFrame {

    private FormCasinoPrincipal myCasino;
    /**
     * Creates new form FormJugador
     */
     public FormCasinoPrincipal getMyCasino() {
        return myCasino;
    }

  
     
     

    public FormJugador(FormCasinoPrincipal myCasino) {
        initComponents();
        this.cambiarMouse();
        this.myCasino= myCasino;
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg.png")).getImage());
         this.setTitle("Opciones del Jugador");
         this.setLocationRelativeTo(null);
        this.jPanel7.setOpaque(false);

          //codigo del fondo
        ((JComponent) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Imagenes/fondo6.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
    }

    private void cambiarMouse(){
    ImageIcon im= new ImageIcon(getClass().getResource("/Imagenes/mouse.png"));
    Toolkit tk =Toolkit.getDefaultToolkit();

Cursor cursor=tk.createCustomCursor(im.getImage(), new Point(1,1), "Cursor");
    this.setCursor(cursor);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNombreJugador4 = new javax.swing.JTextField();
        txtCorreoJugador4 = new javax.swing.JTextField();
        txtCedulaJugador4 = new javax.swing.JTextField();
        cmdRegistrarJugador = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblBlackjack1 = new javax.swing.JLabel();
        cmdAtras = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInformacionJugadores = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nombre");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cedula");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Correo");

        cmdRegistrarJugador.setBackground(new java.awt.Color(204, 0, 0));
        cmdRegistrarJugador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdRegistrarJugador.setForeground(new java.awt.Color(255, 255, 255));
        cmdRegistrarJugador.setText("Registrar Jugador");
        cmdRegistrarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRegistrarJugadorActionPerformed1(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Listar Jugadores");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblBlackjack1.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
        lblBlackjack1.setForeground(new java.awt.Color(255, 255, 255));
        lblBlackjack1.setText("JUGADOR");

        cmdAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Atras.jpg"))); // NOI18N
        cmdAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtCorreoJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtNombreJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtCedulaJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(cmdRegistrarJugador)))
                        .addGap(23, 23, 23))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton2))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblBlackjack1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBlackjack1)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNombreJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCedulaJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdRegistrarJugador))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtCorreoJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addComponent(jButton2))
                    .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtInformacionJugadores.setColumns(20);
        txtInformacionJugadores.setRows(5);
        jScrollPane1.setViewportView(txtInformacionJugadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void limpiar (){
    this.txtCedulaJugador4.setText("");
    this.txtCorreoJugador4.setText("");
    this.txtNombreJugador4.setText("");
}
    private void cmdRegistrarJugadorActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRegistrarJugadorActionPerformed1
            String nombre = this.txtNombreJugador4.getText();
        String cedula = this.txtCedulaJugador4.getText();
        String correo = this.txtCorreoJugador4.getText();

        if (nombre.isEmpty() || cedula.isEmpty()
            ||correo.isEmpty() ) {
            this.myCasino.mostrarMsg("Debe Registrar Todos Los Datos");
            return;
        }
        String cad=this.myCasino.getMyCasino().crearJugador(cedula, nombre, correo);
        this.limpiar();
        String [] msg = cad.split("-");
        this.myCasino.mostrarMsg(msg[0]);
        this.txtInformacionJugadores.setText(msg[1]);
    }//GEN-LAST:event_cmdRegistrarJugadorActionPerformed1

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     String cad= this.myCasino.getMyCasino().listarJugadores();

        this.txtInformacionJugadores.setText(cad);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmdAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAtrasActionPerformed
      this.setVisible(false);
        this.myCasino.setVisible(true);
        int cantJuga= this.myCasino.getMyCasino().enumerar(0);//enumerar jugadores
        this.myCasino.validarBlackJack(cantJuga);
    }//GEN-LAST:event_cmdAtrasActionPerformed

    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton cmdAtras;
    private javax.swing.JButton cmdRegistrarJugador;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBlackjack1;
    private javax.swing.JTextField txtCedulaJugador4;
    private javax.swing.JTextField txtCorreoJugador4;
    private javax.swing.JTextArea txtInformacionJugadores;
    private javax.swing.JTextField txtNombreJugador4;
    // End of variables declaration//GEN-END:variables
}
