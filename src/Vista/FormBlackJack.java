/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

import javax.swing.JComponent;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author Crysel Ayala
 */
public class FormBlackJack extends javax.swing.JFrame {

    private FormCasinoPrincipal myCasino;
    private int contRetirosJ1;
    private int contRetirosJ2;

    public FormCasinoPrincipal getMyCasino() {
        return this.myCasino;

    }

    public FormBlackJack(FormCasinoPrincipal myCasino) {
        initComponents();
        this.contRetirosJ1 = 0;
        this.contRetirosJ2 = 0;
        this.cambiarMouse();
        this.myCasino = myCasino;
        this.setResizable(false);
        this.setTitle("BlackJack");
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg.png")).getImage());
        this.Jugador1.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg.png")).getImage());
        this.setLocationRelativeTo(null);
        this.opcionesComponentesJuego1(false);
        this.opcionesComponentesJuego2(false);
        this.validarEv();
        this.jPanel3.setOpaque(false);
        this.jPanel4.setOpaque(false);
        this.jPanel1.setOpaque(false);

        //codigo del fondo
        ((JComponent) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Imagenes/fondo blackjack.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);

        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);

        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());

    }
    public void validarEv(){
        int num= this.myCasino.getMyCasino().enumerar(2);
        if (num>0) {
            this.cmdEvaluar.setEnabled(true);
        }else{
           this.cmdEvaluar.setEnabled(false);  
        }
    }

    private void cambiarMouse() {
        ImageIcon im = new ImageIcon(getClass().getResource("/Imagenes/mouse.png"));
        Toolkit tk = Toolkit.getDefaultToolkit();

        Cursor cursor = tk.createCustomCursor(im.getImage(), new Point(1, 1), "Cursor");
        this.setCursor(cursor);
    }

    private void restablecerImagCartas(int jug) {
        if (jug == 1) {
            this.lblImgCarta1Jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg")));
            this.lblImgCarta2Jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg")));

            this.lblImgCarta3Jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg")));

        } else if (jug == 2) {
            this.lblImgCarta1Jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg")));

            this.lblImgCarta2Jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg")));

            this.lblImgCarta3Jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg")));
        }

    }

//    private void mostrarCartasJ1(ArrayList<String> myC){
//        
//    }
    public void opcionesComponentesRegistrarPartido(boolean opcion) {

        this.cmdEvaluar.setEnabled(opcion);
        this.txtValorCedulaJugador1.setEditable(opcion);
        this.txtValorCedulaJugador2.setEditable(opcion);
        this.txtValorApostarJugador1.setEditable(opcion);
        this.txtValorApostarJugador2.setEditable(opcion);
        this.cmdNuevo.setEnabled(opcion);
        this.CalendarFecha.setEnabled(opcion);
        this.cmdAtras.setEnabled(opcion);
    }

    public void opcionesComponentesJuego1(boolean opcion) {//true=habilitar; false=deshabilitar

        this.cmdOtraCartaJugador1.setEnabled(opcion);
        this.cmdStopJugador1.setEnabled(opcion);

        this.cmdRetirarseJ1.setEnabled(opcion);
    }

    public void opcionesComponentesJuego2(boolean opcion) {//true=habilitar; false=deshabilitar

        this.cmdOtraCartaJugador2.setEnabled(opcion);
        this.cmdStopJugador2.setEnabled(opcion);

        this.cmdRetirarseJ2.setEnabled(opcion);
    }

    public void validarPuntajeJugador(int juego) {//0 o 1
        int puntajeJugador = this.myCasino.getMyCasino().mostrarPuntajeJuego(juego);

        
        if (puntajeJugador < 17) {
            if (juego == 0) {
                this.cmdStopJugador1.setEnabled(false);

            } else {
                this.cmdStopJugador2.setEnabled(false);
            }
        } else {
            if (juego == 0) {
                this.cmdStopJugador1.setEnabled(true);

            } else {
                this.cmdStopJugador2.setEnabled(true);
            }

        }
        if (puntajeJugador >= 21) {
            if (juego == 0) {
                this.cmdOtraCartaJugador1.setEnabled(false);
                this.CartaRetirarJ1.setEnabled(false);
                this.RetirarJ1.setEnabled(false);
            } else {
                this.cmdOtraCartaJugador2.setEnabled(false);
                this.CartaRetirarJ2.setEnabled(false);
                this.RetirarJ2.setEnabled(false);

            }
        }
        if (this.contRetirosJ1==3) {
             this.CartaRetirarJ1.setEnabled(false);
                this.RetirarJ1.setEnabled(false);
        }else if(this.contRetirosJ2==3) {
             this.CartaRetirarJ2.setEnabled(false);
                this.RetirarJ2.setEnabled(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jugador1 = new javax.swing.JFrame();
        lblBlackjack1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblImgCarta1Jugador1 = new javax.swing.JLabel();
        lblImgCarta2Jugador1 = new javax.swing.JLabel();
        lblImgCarta3Jugador1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmdOtraCartaJugador1 = new javax.swing.JButton();
        cmdStopJugador1 = new javax.swing.JButton();
        cmdRetirarseJ1 = new javax.swing.JButton();
        CartaRetirarJ1 = new javax.swing.JComboBox();
        RetirarJ1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lblImgCarta1Jugador2 = new javax.swing.JLabel();
        lblImgCarta2Jugador2 = new javax.swing.JLabel();
        lblImgCarta3Jugador2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmdOtraCartaJugador2 = new javax.swing.JButton();
        cmdStopJugador2 = new javax.swing.JButton();
        cmdRetirarseJ2 = new javax.swing.JButton();
        CartaRetirarJ2 = new javax.swing.JComboBox();
        RetirarJ2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMostrarDatosJugador1 = new javax.swing.JTextArea();
        lblPartido = new javax.swing.JLabel();
        lblNumeroPartido = new javax.swing.JLabel();
        lblBlackjack = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtValorApostarJugador1 = new javax.swing.JTextField();
        txtValorCedulaJugador1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtValorApostarJugador2 = new javax.swing.JTextField();
        txtValorCedulaJugador2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmdEvaluar = new java.awt.Button();
        cmdNuevo = new java.awt.Button();
        lblFecha = new javax.swing.JLabel();
        CalendarFecha = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        cmdAtras = new javax.swing.JToggleButton();

        Jugador1.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Jugador1.setTitle("Jugador 1");
        Jugador1.setIconImages(null);

        lblBlackjack1.setBackground(new java.awt.Color(0, 0, 0));
        lblBlackjack1.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        lblBlackjack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo blackjack.png"))); // NOI18N

        jPanel5.setOpaque(false);

        lblImgCarta1Jugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgCarta1Jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg"))); // NOI18N

        lblImgCarta2Jugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgCarta2Jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg"))); // NOI18N

        lblImgCarta3Jugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgCarta3Jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel5.setText("Jugador 1");

        cmdOtraCartaJugador1.setBackground(new java.awt.Color(204, 0, 0));
        cmdOtraCartaJugador1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdOtraCartaJugador1.setForeground(new java.awt.Color(255, 255, 255));
        cmdOtraCartaJugador1.setText("Otra Carta");
        cmdOtraCartaJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOtraCartaJugador1ActionPerformed(evt);
            }
        });

        cmdStopJugador1.setBackground(new java.awt.Color(204, 0, 0));
        cmdStopJugador1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdStopJugador1.setForeground(new java.awt.Color(255, 255, 255));
        cmdStopJugador1.setText("Stop");
        cmdStopJugador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStopJugador1ActionPerformed(evt);
            }
        });

        cmdRetirarseJ1.setBackground(new java.awt.Color(204, 0, 0));
        cmdRetirarseJ1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdRetirarseJ1.setForeground(new java.awt.Color(255, 255, 255));
        cmdRetirarseJ1.setText("Retirarse");
        cmdRetirarseJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRetirarseJ1ActionPerformed(evt);
            }
        });

        RetirarJ1.setText("Retirar Carta");
        RetirarJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirarJ1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdRetirarseJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(CartaRetirarJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RetirarJ1)
                .addGap(48, 48, 48))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lblImgCarta1Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblImgCarta2Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblImgCarta3Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(cmdOtraCartaJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdStopJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgCarta1Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImgCarta2Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImgCarta3Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdOtraCartaJugador1)
                    .addComponent(cmdStopJugador1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdRetirarseJ1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CartaRetirarJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RetirarJ1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setOpaque(false);

        lblImgCarta1Jugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgCarta1Jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg"))); // NOI18N

        lblImgCarta2Jugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgCarta2Jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg"))); // NOI18N

        lblImgCarta3Jugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgCarta3Jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel10.setText("Jugador 2");

        cmdOtraCartaJugador2.setBackground(new java.awt.Color(204, 0, 0));
        cmdOtraCartaJugador2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdOtraCartaJugador2.setForeground(new java.awt.Color(255, 255, 255));
        cmdOtraCartaJugador2.setText("Otra Carta");
        cmdOtraCartaJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOtraCartaJugador2ActionPerformed(evt);
            }
        });

        cmdStopJugador2.setBackground(new java.awt.Color(204, 0, 0));
        cmdStopJugador2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdStopJugador2.setForeground(new java.awt.Color(255, 255, 255));
        cmdStopJugador2.setText("Stop");
        cmdStopJugador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStopJugador2ActionPerformed(evt);
            }
        });

        cmdRetirarseJ2.setBackground(new java.awt.Color(204, 0, 0));
        cmdRetirarseJ2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmdRetirarseJ2.setForeground(new java.awt.Color(255, 255, 255));
        cmdRetirarseJ2.setText("Retirarse");
        cmdRetirarseJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRetirarseJ2ActionPerformed(evt);
            }
        });

        RetirarJ2.setText("Retirar Carta");
        RetirarJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirarJ2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblImgCarta1Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblImgCarta2Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblImgCarta3Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cmdOtraCartaJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmdStopJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel10)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cmdRetirarseJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(CartaRetirarJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RetirarJ2)
                .addGap(39, 39, 39))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgCarta1Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImgCarta2Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImgCarta3Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdOtraCartaJugador2)
                    .addComponent(cmdStopJugador2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdRetirarseJ2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CartaRetirarJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RetirarJ2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtMostrarDatosJugador1.setEditable(false);
        txtMostrarDatosJugador1.setColumns(20);
        txtMostrarDatosJugador1.setRows(5);
        jScrollPane2.setViewportView(txtMostrarDatosJugador1);

        lblPartido.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        lblPartido.setText("Partido No.");

        lblNumeroPartido.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        lblNumeroPartido.setText("XX");

        javax.swing.GroupLayout Jugador1Layout = new javax.swing.GroupLayout(Jugador1.getContentPane());
        Jugador1.getContentPane().setLayout(Jugador1Layout);
        Jugador1Layout.setHorizontalGroup(
            Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jugador1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblPartido))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jugador1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(lblNumeroPartido)
                        .addGap(238, 238, 238))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jugador1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(Jugador1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(lblBlackjack1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jugador1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        Jugador1Layout.setVerticalGroup(
            Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jugador1Layout.createSequentialGroup()
                .addComponent(lblBlackjack1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPartido)
                    .addComponent(lblNumeroPartido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        lblBlackjack.setBackground(new java.awt.Color(0, 0, 0));
        lblBlackjack.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        lblBlackjack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo blackjack.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel3.setText("Apuesta:");

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel4.setText("Cedula:");

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel1.setText("Jugador 1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtValorApostarJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(txtValorCedulaJugador1))
                .addGap(22, 22, 22))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtValorCedulaJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValorApostarJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel6.setText("Cedula:");

        jLabel7.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel7.setText("Apuesta:");

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel2.setText("Jugador 2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorCedulaJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorApostarJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel2))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorCedulaJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorApostarJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmdEvaluar.setBackground(new java.awt.Color(51, 51, 255));
        cmdEvaluar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cmdEvaluar.setForeground(new java.awt.Color(255, 255, 255));
        cmdEvaluar.setLabel("Evaluar");
        cmdEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEvaluarActionPerformed(evt);
            }
        });

        cmdNuevo.setBackground(new java.awt.Color(51, 51, 255));
        cmdNuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cmdNuevo.setForeground(new java.awt.Color(255, 255, 255));
        cmdNuevo.setLabel("Nuevo");
        cmdNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNuevoActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        lblFecha.setText("Fecha:");

        CalendarFecha.setBackground(new java.awt.Color(204, 255, 153));

        jLabel9.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel9.setText("Nuevo Partido");

        cmdAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Atras.jpg"))); // NOI18N
        cmdAtras.setSelected(true);
        cmdAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(lblFecha)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CalendarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(cmdNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdEvaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(181, 181, 181))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha)
                    .addComponent(CalendarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cmdNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdEvaluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmdAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBlackjack)
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBlackjack, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void cmdNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNuevoActionPerformed

        //ACA ME CREA UN NUEVO PARTIDO
        String tipoJuego = "BlackJack";
        String ced1 = this.txtValorCedulaJugador1.getText();
        String ced2 = this.txtValorCedulaJugador2.getText();
        String apuesta1 = this.txtValorApostarJugador1.getText();
        String apuesta2 = this.txtValorApostarJugador2.getText();

        Date fecha = this.CalendarFecha.getDate();

        if (apuesta1.isEmpty() || apuesta2.isEmpty() || ced1.isEmpty() || ced2.isEmpty() || fecha == null) {
            this.myCasino.mostrarMsg("Debe anotar todos los Datos");

            return;
        }
        String cad = this.myCasino.getMyCasino().crearPartido(ced1, ced2, Integer.parseInt(apuesta1),
                Integer.parseInt(apuesta2), tipoJuego, fecha);
        ///falta terminar codigo  
        if (!cad.equalsIgnoreCase("El partido fue registrado exitosamente")) { ///depronto me bote algun msg de advertencia
            this.myCasino.mostrarMsg(cad);
            return;
        }

        //debo verificar cuando alguna carta de cada jugador sea comodin o as
        this.opcionesComponentesJuego1(true);
        this.opcionesComponentesRegistrarPartido(false);

        this.validarPuntajeJugador(0);
        this.lblNumeroPartido.setText(this.myCasino.getMyCasino().mostrarConsecutivo());

//        this.limpiar();
        int retiroj1 = 0;//pos juego 1

        boolean Validarretiroj1 = this.myCasino.getMyCasino().validarRetiro(retiroj1);
        if (Validarretiroj1) {
            this.cmdRetirarseJ1.setEnabled(false);
        } else {
            this.cmdRetirarseJ1.setEnabled(true);
        }

        //codigo del fondo j1
        //cambiar mouse
        ImageIcon im = new ImageIcon(getClass().getResource("/Imagenes/mouse.png"));
        Toolkit tk = Toolkit.getDefaultToolkit();

        Cursor cursor = tk.createCustomCursor(im.getImage(), new Point(1, 1), "Cursor");
        this.Jugador1.setCursor(cursor);

        ((JComponent) Jugador1.getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Imagenes/fondo blackjack.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);

        Jugador1.getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);

        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());

        this.setVisible(false);
        this.Jugador1.setResizable(false);
        this.restablecerImagCartas(2);
        this.visualizarJugador1();

        Jugador1.setSize(656, 620);
        this.Jugador1.setVisible(true);
        this.Jugador1.setResizable(false);
        this.Jugador1.setLocationRelativeTo(null);
        this.myCasino.mostrarMsg(cad);
    }//GEN-LAST:event_cmdNuevoActionPerformed

    private void limpiar() {
        this.txtValorCedulaJugador1.setText("");
        this.txtValorCedulaJugador2.setText("");
        this.txtValorApostarJugador2.setText("");
        this.txtValorApostarJugador1.setText("");
    }

    private int escogerValorCarta(int[] sumaC) {
        int valor = 0;

        return valor;
    }

    private void cmdEvaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEvaluarActionPerformed
        String cad = this.myCasino.getMyCasino().evaluarResultado();
        this.myCasino.mostrarMsg(cad);
    }//GEN-LAST:event_cmdEvaluarActionPerformed


    private void cmdRetirarseJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRetirarseJ1ActionPerformed
        int juego = 0;
        String msg = this.myCasino.getMyCasino().retirarJugador(juego);
        this.myCasino.mostrarMsg(msg);
        this.cmdStopJugador1ActionPerformed(evt);
        this.CartaRetirarJ1.setEnabled(false);
        this.RetirarJ1.setEnabled(false);
    }//GEN-LAST:event_cmdRetirarseJ1ActionPerformed
private void listarCartasCombobox1(ArrayList <String> cad){
this.CartaRetirarJ1.removeAllItems();

    for (String cad1 : cad) {
        this.CartaRetirarJ1.addItem(cad1);
    }

}

private void listarCartasCombobox2(ArrayList <String> cad){
this.CartaRetirarJ2.removeAllItems();

    for (String cad1 : cad) {
        this.CartaRetirarJ2.addItem(cad1);
    }

}
    
    private void visualizarJugador1() {
        int posJuego = 0;
        ArrayList<String> cad = this.myCasino.getMyCasino().visualizarCartas(posJuego);
        this.listarCartasCombobox1(cad);
        if (cad.size()>2) {
            this.lblImgCarta1Jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + cad.get(cad.size() - 3) + ".JPG")));
       this.CartaRetirarJ1.setEnabled(true);
        this.RetirarJ1.setEnabled(true);
        }else{
              this.CartaRetirarJ1.setEnabled(false);
        this.RetirarJ1.setEnabled(false);
          this.lblImgCarta1Jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg")));  
        }
        this.lblImgCarta2Jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + cad.get(cad.size() - 2) + ".JPG")));
        this.lblImgCarta3Jugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + cad.get(cad.size() - 1) + ".JPG")));

        this.txtMostrarDatosJugador1.setText("Historial de Cartas Jugador 1\n");
        for (String cad1 : cad) {
            this.txtMostrarDatosJugador1.setText(this.txtMostrarDatosJugador1.getText() + cad1 + "\n");
        }
        int puntaje = this.myCasino.getMyCasino().mostrarPuntajeJuego(0);
        this.txtMostrarDatosJugador1.setText(this.txtMostrarDatosJugador1.getText() + "Puntaje Jugador 1 = " + puntaje);
    }

    private void visualizarJugador2() {
        int posJuego = 1;
        ArrayList<String> cad = this.myCasino.getMyCasino().visualizarCartas(posJuego);
        this.listarCartasCombobox2(cad);
   
        this.txtMostrarDatosJugador1.setText("Historial de Cartas Jugador 2\n");
        for (String cad2 : cad) {
            this.txtMostrarDatosJugador1.setText(this.txtMostrarDatosJugador1.getText() + cad2 + "\n");
        }

        int puntaje = this.myCasino.getMyCasino().mostrarPuntajeJuego(1);
        this.txtMostrarDatosJugador1.setText(this.txtMostrarDatosJugador1.getText() + "Puntaje Jugador 1 = " + puntaje);

        this.cmdStopJugador1.setEnabled(false);
        if (cad.size()>2) {
          this.CartaRetirarJ2.setEnabled(true);
        this.RetirarJ2.setEnabled(true);
            this.lblImgCarta1Jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + cad.get(cad.size() - 3) + ".JPG")));
        }else{
            this.CartaRetirarJ2.setEnabled(false);
        this.RetirarJ1.setEnabled(false);
          this.lblImgCarta1Jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tapa.jpg")));  
        }
        this.lblImgCarta2Jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + cad.get(cad.size() - 2) + ".JPG")));
        this.lblImgCarta3Jugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/" + cad.get(cad.size() - 1) + ".JPG")));
    }
    private void cmdStopJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStopJugador1ActionPerformed
        this.opcionesComponentesJuego1(false);
        this.opcionesComponentesJuego2(true);
        this.cmdStopJugador1.setEnabled(false);
        this.validarPuntajeJugador(1);
        this.txtMostrarDatosJugador1.setText("");
        this.lblImgCarta1Jugador1.setIcon(null);
        this.lblImgCarta2Jugador1.setIcon(null);
        this.lblImgCarta3Jugador1.setIcon(null);
        int retiroj2 = 1;//pos juego 2
        this.CartaRetirarJ1.removeAll();

        boolean Validarretiroj2 = this.myCasino.getMyCasino().validarRetiro(retiroj2);
        if (Validarretiroj2) {
            this.cmdRetirarseJ2.setEnabled(false);
        } else {
            this.cmdRetirarseJ2.setEnabled(true);
        }
        this.restablecerImagCartas(1);
        this.visualizarJugador2();
    }//GEN-LAST:event_cmdStopJugador1ActionPerformed

    private void cmdOtraCartaJugador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOtraCartaJugador1ActionPerformed
        int juego = 0;
        this.myCasino.getMyCasino().pedirCarta(juego);
        //        Ventana.imp(cad, "Casino Internacional");
        this.validarPuntajeJugador(0);
        this.lblImgCarta1Jugador1.setIcon(null);
        this.lblImgCarta2Jugador1.setIcon(null);
        this.lblImgCarta3Jugador1.setIcon(null);
        this.txtMostrarDatosJugador1.setText("");
        this.validarPuntajeJugador(0);

        boolean Validarretiroj1 = this.myCasino.getMyCasino().validarRetiro(juego);
        if (Validarretiroj1 || this.contRetirosJ1>0) {
            this.cmdRetirarseJ1.setEnabled(false);
        } else {
            this.cmdRetirarseJ1.setEnabled(true);
        }
        this.visualizarJugador1();
    }//GEN-LAST:event_cmdOtraCartaJugador1ActionPerformed


    private void cmdOtraCartaJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOtraCartaJugador2ActionPerformed
        int juego = 1;
        this.myCasino.getMyCasino().pedirCarta(juego);
        this.validarPuntajeJugador(1);

        this.lblImgCarta1Jugador2.setIcon(null);
        this.lblImgCarta2Jugador2.setIcon(null);
        this.lblImgCarta3Jugador2.setIcon(null);
        this.txtMostrarDatosJugador1.setText("");
        boolean Validarretiroj2 = this.myCasino.getMyCasino().validarRetiro(juego);
        if (Validarretiroj2 || this.contRetirosJ2>0) {
            this.cmdRetirarseJ2.setEnabled(false);
        } else {
            this.cmdRetirarseJ2.setEnabled(true);
        }
        this.visualizarJugador2();
    }//GEN-LAST:event_cmdOtraCartaJugador2ActionPerformed

    private void cmdStopJugador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStopJugador2ActionPerformed
        this.opcionesComponentesJuego2(false);
        this.opcionesComponentesRegistrarPartido(true);
        this.txtMostrarDatosJugador1.setText("");

        this.lblImgCarta1Jugador2.setIcon(null);
        this.lblImgCarta2Jugador2.setIcon(null);
        this.lblImgCarta3Jugador2.setIcon(null);
        this.CartaRetirarJ2.removeAll();
        String cad = this.myCasino.getMyCasino().hacerEvaluacionFinal();

        int juegos = this.myCasino.getMyCasino().enumerar(1);//enumerar juegos
        String x = "";
        if (juegos == 1) {
            x += "Puntaje Jugador 1: " + this.myCasino.getMyCasino().mostrarPuntajeJuego(1) + "\n\n";
        } else {
            x = "Puntaje Jugador 1: " + this.myCasino.getMyCasino().mostrarPuntajeJuego(0)
                    + "\nPuntaje Jugador 2: " + this.myCasino.getMyCasino().mostrarPuntajeJuego(1) + "\n\n";
        }
        this.restablecerImagCartas(2);

        this.Jugador1.setVisible(false);
        this.setVisible(true);
        this.myCasino.mostrarMsg((x + cad));
    }//GEN-LAST:event_cmdStopJugador2ActionPerformed

    private void cmdRetirarseJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRetirarseJ2ActionPerformed
        int juego = 1;
        String msg = this.myCasino.getMyCasino().retirarJugador(juego);

        this.myCasino.mostrarMsg(msg);
        this.cmdStopJugador2ActionPerformed(evt);
        this.CartaRetirarJ2.setEnabled(false);
        this.RetirarJ2.setEnabled(false);
    }//GEN-LAST:event_cmdRetirarseJ2ActionPerformed

    private void cmdAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAtrasActionPerformed
        this.setVisible(false);
        this.myCasino.setVisible(true);
    }//GEN-LAST:event_cmdAtrasActionPerformed

    
    

    private void RetirarJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirarJ1ActionPerformed
        int pos = this.CartaRetirarJ1.getSelectedIndex();
        int posJ = 0;
        boolean retiro = this.myCasino.getMyCasino().retirarCartaJuego(posJ, pos, this.contRetirosJ1);
        if (retiro) {
            this.contRetirosJ1++;
        }else{
            this.myCasino.mostrarMsg("No se puede retirar la carta");
        }
     
          this.cmdRetirarseJ1.setEnabled(false);
        this.validarPuntajeJugador(0);
        this.visualizarJugador1();
    
        if (this.contRetirosJ1==3) {
             this.CartaRetirarJ1.setEnabled(false);
             this.RetirarJ1.setEnabled(false);
        }

    }//GEN-LAST:event_RetirarJ1ActionPerformed

    private void RetirarJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirarJ2ActionPerformed
        int pos = this.CartaRetirarJ2.getSelectedIndex();
        int posJ = 1;
        boolean retiro = this.myCasino.getMyCasino().retirarCartaJuego(posJ, pos, this.contRetirosJ2);
        if (retiro) {
            this.contRetirosJ2++;
        }else{
            this.myCasino.mostrarMsg("No se puede retirar la carta");
        }
        if (this.contRetirosJ2==3) {
             this.CartaRetirarJ2.setEnabled(false);
             this.RetirarJ2.setEnabled(false);
        }
        this.cmdRetirarseJ2.setEnabled(false);
        this.validarPuntajeJugador(1);
        this.visualizarJugador2();

    }//GEN-LAST:event_RetirarJ2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CalendarFecha;
    private javax.swing.JComboBox CartaRetirarJ1;
    private javax.swing.JComboBox CartaRetirarJ2;
    private javax.swing.JFrame Jugador1;
    private javax.swing.JButton RetirarJ1;
    private javax.swing.JButton RetirarJ2;
    private javax.swing.JToggleButton cmdAtras;
    private java.awt.Button cmdEvaluar;
    private java.awt.Button cmdNuevo;
    private javax.swing.JButton cmdOtraCartaJugador1;
    private javax.swing.JButton cmdOtraCartaJugador2;
    private javax.swing.JButton cmdRetirarseJ1;
    private javax.swing.JButton cmdRetirarseJ2;
    private javax.swing.JButton cmdStopJugador1;
    private javax.swing.JButton cmdStopJugador2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBlackjack;
    private javax.swing.JLabel lblBlackjack1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImgCarta1Jugador1;
    private javax.swing.JLabel lblImgCarta1Jugador2;
    private javax.swing.JLabel lblImgCarta2Jugador1;
    private javax.swing.JLabel lblImgCarta2Jugador2;
    private javax.swing.JLabel lblImgCarta3Jugador1;
    private javax.swing.JLabel lblImgCarta3Jugador2;
    private javax.swing.JLabel lblNumeroPartido;
    private javax.swing.JLabel lblPartido;
    private javax.swing.JTextArea txtMostrarDatosJugador1;
    private javax.swing.JTextField txtValorApostarJugador1;
    private javax.swing.JTextField txtValorApostarJugador2;
    private javax.swing.JTextField txtValorCedulaJugador1;
    private javax.swing.JTextField txtValorCedulaJugador2;
    // End of variables declaration//GEN-END:variables
}
