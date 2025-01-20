/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


/**
 *
 * @author CORE I3
 */
public class FormListados extends javax.swing.JFrame {

     private FormCasinoPrincipal myCasino;
    /**
     * Creates new form FormCasinoOpciones
     */
      public FormCasinoPrincipal getMyCasino() {
        return myCasino;
    }

    public FormListados(FormCasinoPrincipal myCasino) {
        
        initComponents();
        this.cambiarMouse();
        this.myCasino=myCasino;
         this.setLocationRelativeTo(null);
         this.setResizable(false);
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg.png")).getImage());
         this.setTitle("Opciones del Casino");
         
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtMostrarDatosC = new javax.swing.JTextArea();
        cmdAtras = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        cmdListarPartidos = new javax.swing.JButton();
        calendarFin = new com.toedter.calendar.JDateChooser();
        calendarInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmdSaldo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        cmdBuscarCedula = new javax.swing.JButton();
        cmdmostrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbMes = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 51));

        txtMostrarDatosC.setEditable(false);
        txtMostrarDatosC.setColumns(20);
        txtMostrarDatosC.setRows(5);
        jScrollPane1.setViewportView(txtMostrarDatosC);

        cmdAtras.setBackground(new java.awt.Color(0, 204, 51));
        cmdAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Atras.jpg"))); // NOI18N
        cmdAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAtrasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ravie", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTADOS");

        cmdListarPartidos.setBackground(new java.awt.Color(204, 0, 0));
        cmdListarPartidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdListarPartidos.setForeground(new java.awt.Color(255, 255, 255));
        cmdListarPartidos.setText("LISTAR PARTIDOS");
        cmdListarPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdListarPartidosActionPerformed(evt);
            }
        });

        calendarFin.setBackground(new java.awt.Color(204, 0, 0));

        calendarInicio.setBackground(new java.awt.Color(204, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha Inicio:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha Fin:");

        cmdSaldo.setBackground(new java.awt.Color(204, 0, 0));
        cmdSaldo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdSaldo.setForeground(new java.awt.Color(255, 255, 255));
        cmdSaldo.setText("SALDO");
        cmdSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaldoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cedula: ");

        cmdBuscarCedula.setBackground(new java.awt.Color(204, 0, 0));
        cmdBuscarCedula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdBuscarCedula.setForeground(new java.awt.Color(255, 255, 255));
        cmdBuscarCedula.setText("BUSCAR");
        cmdBuscarCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscarCedulaActionPerformed(evt);
            }
        });

        cmdmostrar.setBackground(new java.awt.Color(204, 0, 0));
        cmdmostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmdmostrar.setForeground(new java.awt.Color(255, 255, 255));
        cmdmostrar.setText("MOSTRAR");
        cmdmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdmostrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mes:");

        cmbMes.setBackground(new java.awt.Color(204, 0, 0));
        cmbMes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmbMes.setForeground(new java.awt.Color(255, 255, 255));
        cmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(calendarInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(calendarFin, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(cmdmostrar))
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmdSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmdBuscarCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(cmdListarPartidos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calendarFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(cmdListarPartidos)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cmdBuscarCedula))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmdmostrar)
                                .addComponent(cmdSaldo)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAtrasActionPerformed
        this.setVisible(false);
        this.myCasino.setVisible(true);
    }//GEN-LAST:event_cmdAtrasActionPerformed

    private void cmdListarPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdListarPartidosActionPerformed
   Calendar fechaInx= this.calendarInicio.getCalendar();
   Calendar fechaFinx= this.calendarFin.getCalendar();
   
        if (fechaInx==null || fechaFinx==null) {
     this.myCasino.mostrarMsg("Debe anotar todas las Fechas");
            return;
        }
        if (fechaFinx.before(fechaInx)) {
      this.myCasino.mostrarMsg("El orden de las fechas es incorrecto");
            return;
        }
      fechaInx.add(fechaInx.DAY_OF_MONTH, -1);
//      fechaFinx.add(fechaFinx.DAY_OF_MONTH, 1);
      Date fechaIn= fechaInx.getTime();
      Date fechaFin= fechaFinx.getTime();
//      fechaFin.setDate(fechaFin.getDate()+1);
      
        String cad=this.myCasino.getMyCasino().listarPartidos(fechaIn, fechaFin);
        this.txtMostrarDatosC.setText(cad);
    }//GEN-LAST:event_cmdListarPartidosActionPerformed

    private void cmdSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaldoActionPerformed
       this.txtMostrarDatosC.setText(this.myCasino.getMyCasino().mostrarSaldosCasino());
    }//GEN-LAST:event_cmdSaldoActionPerformed

    private void cmdmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdmostrarActionPerformed

        String mes = this.cmbMes.getSelectedItem().toString();
   
               
        String cad=this.myCasino.getMyCasino().consultarPartido(Integer.parseInt(mes));
        this.txtMostrarDatosC.setText(String.valueOf(cad));
    }//GEN-LAST:event_cmdmostrarActionPerformed

    private void cmdBuscarCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarCedulaActionPerformed
       String ced= this.txtCedula.getText();
        if (ced.isEmpty()) {
          this.myCasino.mostrarMsg("No se encontro la cedula de este Jugador");
            return;
        }this.txtMostrarDatosC.setText(this.myCasino.getMyCasino().buscarJugadorCedula(ced));
                 
       
       
    }//GEN-LAST:event_cmdBuscarCedulaActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser calendarFin;
    private com.toedter.calendar.JDateChooser calendarInicio;
    private javax.swing.JComboBox cmbMes;
    private javax.swing.JToggleButton cmdAtras;
    private javax.swing.JButton cmdBuscarCedula;
    private javax.swing.JButton cmdListarPartidos;
    private javax.swing.JButton cmdSaldo;
    private javax.swing.JButton cmdmostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextArea txtMostrarDatosC;
    // End of variables declaration//GEN-END:variables
}
