package vistas;

import conexionDB.Conexion;
import java.sql.*;
/**
 *
 * @author Saske
 */
public class Inicio extends javax.swing.JFrame { 
    private final javax.swing.border.Border PADDING_FIELD = javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3);
    private final javax.swing.border.Border BORDERLINE_FIELD = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153));
    private final javax.swing.border.Border BORDER = javax.swing.BorderFactory.createCompoundBorder(BORDERLINE_FIELD, PADDING_FIELD);
    private final javax.swing.border.Border BORDERLINE_FIELD_EXCEPTION = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0));
    private final javax.swing.border.Border BORDER_EXCEPTION = javax.swing.BorderFactory.createCompoundBorder(BORDERLINE_FIELD_EXCEPTION, PADDING_FIELD);
    private final String DATOS_INCORRECTOS = "Usuario o contraseña incorrectos";
    private final String CAMPOS_VACIOS = "Rellene los campos vacíos";


    /**
     * Creates new form Inicio
     */
    public Inicio() {
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

        jPanel2 = new javax.swing.JPanel();
        jlPlaceholderUser = new javax.swing.JLabel();
        jlPlaceholderPassword = new javax.swing.JLabel();
        jlTitle = new javax.swing.JLabel();
        jlTittle = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jpfPassword = new javax.swing.JPasswordField();
        jbInicio = new javax.swing.JButton();
        jlExcepcion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(731, 409));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 392));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlPlaceholderUser.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jlPlaceholderUser.setForeground(new java.awt.Color(204, 204, 204));
        jlPlaceholderUser.setText(" Usuario");
        jPanel2.add(jlPlaceholderUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 140, 185, 33));

        jlPlaceholderPassword.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jlPlaceholderPassword.setForeground(new java.awt.Color(204, 204, 204));
        jlPlaceholderPassword.setText(" Contraseña");
        jPanel2.add(jlPlaceholderPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 203, 185, 33));

        jlTitle.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jlTitle.setText("Bienvenido");
        jPanel2.add(jlTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 70, -1, -1));

        jlTittle.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jlTittle.setForeground(new java.awt.Color(102, 255, 255));
        jlTittle.setText("Paletero");
        jPanel2.add(jlTittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 70, -1, -1));

        jtfUsername.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jtfUsername.setForeground(new java.awt.Color(102, 102, 102));
        jtfUsername.setBorder(BORDER);
        jtfUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfUsernameKeyReleased(evt);
            }
        });
        jPanel2.add(jtfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 140, 185, 33));

        jpfPassword.setBorder(BORDER);
        jpfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfPasswordActionPerformed(evt);
            }
        });
        jpfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpfPasswordKeyReleased(evt);
            }
        });
        jPanel2.add(jpfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 203, 185, 33));

        jbInicio.setBackground(new java.awt.Color(0, 204, 204));
        jbInicio.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jbInicio.setForeground(new java.awt.Color(255, 255, 255));
        jbInicio.setText("Iniciar Sesión");
        jbInicio.setBorderPainted(false);
        jbInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbInicioMouseClicked(evt);
            }
        });
        jbInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInicioActionPerformed(evt);
            }
        });
        jPanel2.add(jbInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 289, -1, -1));

        jlExcepcion.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jlExcepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, 20));
        jlExcepcion.setVisible(false);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 381, 409));

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));

        jLabel3.setFont(new java.awt.Font("Open Sans Semibold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("venta");

        jLabel4.setFont(new java.awt.Font("Open Sans Semibold", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sistema punto de");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 409));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInicioActionPerformed
        String username = jtfUsername.getText().trim();
        char password[] = jpfPassword.getPassword();
        byte flujo = 0;
        
        if(username.isEmpty()) flujo += 1;
        if(password.length == 0) flujo += 2;
        
        if(flujo > 0){
            jlExcepcion.setText(CAMPOS_VACIOS);
            jlExcepcion.setVisible(true);
            
            switch (flujo) {
                case 1 -> jtfUsername.setBorder(BORDER_EXCEPTION);
                case 2 -> jpfPassword.setBorder(BORDER_EXCEPTION);
                case 3 -> {
                    jtfUsername.setBorder(BORDER_EXCEPTION);
                    jpfPassword.setBorder(BORDER_EXCEPTION);
                }
            }
            return;
        }
         
        try {
            Conexion consulta = new Conexion();
            PreparedStatement pst = consulta.connection.prepareStatement("SELECT * FROM usuario WHERE uUsuario = ? ");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            
            if (!rs.next()) {
                jlExcepcion.setText(DATOS_INCORRECTOS);
                jlExcepcion.setVisible(true);
                return;
            }
            
            String realPassword = rs.getString("uContraseña");
                
            for (int i = 0; i < password.length; i++) {
                if(password[i] != realPassword.charAt(i)){
                    jlExcepcion.setText(DATOS_INCORRECTOS);
                    jlExcepcion.setVisible(true);
                    return;
                }
            }
            
            System.out.println("CORRECTO");//REDIRIGIR AL CASO DE USO DE CADA UNO
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jbInicioActionPerformed

    private void jbInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbInicioMouseClicked

    }//GEN-LAST:event_jbInicioMouseClicked

    private void jpfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfPasswordActionPerformed

    private void jtfUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsernameKeyReleased
        jlPlaceholderUser.setVisible(false);
        jtfUsername.setBorder(BORDER);
        jlExcepcion.setVisible(false);
    }//GEN-LAST:event_jtfUsernameKeyReleased

    private void jpfPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfPasswordKeyReleased
        jlPlaceholderPassword.setVisible(false);
        jpfPassword.setBorder(BORDER);
        jlExcepcion.setVisible(false);
    }//GEN-LAST:event_jpfPasswordKeyReleased

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbInicio;
    private javax.swing.JLabel jlExcepcion;
    private javax.swing.JLabel jlPlaceholderPassword;
    private javax.swing.JLabel jlPlaceholderUser;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlTittle;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
