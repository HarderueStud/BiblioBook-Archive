package blibliobook;

public class CreateAccountFrame extends javax.swing.JFrame {
    
    private final DataBase db;
    
    public CreateAccountFrame() {
        initComponents();
        db = new DataBase();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        passText1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AlreadyAccount = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        passText2 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        nomText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        prenomText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        infoMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(160, 80, 126));
        jLabel1.setText("BliblioBooks ");

        emailText.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        emailText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailText.setToolTipText("Enter your email");

        passText1.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        passText1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passText1.setToolTipText("Enter your password");
        passText1.setEchoChar('*');

        jLabel2.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel2.setText("MDP :");

        jLabel3.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel3.setText("Email :");

        AlreadyAccount.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        AlreadyAccount.setText("Deja un compte ?");
        AlreadyAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AlreadyAccountMousePressed(evt);
            }
        });

        RegisterButton.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        RegisterButton.setText("Enreg.");
        RegisterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RegisterButtonMousePressed(evt);
            }
        });

        passText2.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        passText2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passText2.setToolTipText("Enter your password");
        passText2.setEchoChar('*');

        jLabel4.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel4.setText("MDP :");

        nomText.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        nomText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomText.setToolTipText("Enter your email");

        jLabel5.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel5.setText("Nom :");

        prenomText.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        prenomText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prenomText.setToolTipText("Enter your email");

        jLabel6.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel6.setText("Prénom :");

        infoMessage.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        infoMessage.setForeground(new java.awt.Color(156, 42, 42));
        infoMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(35, 35, 35))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(38, 38, 38))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel3))
                                                .addGap(32, 32, 32)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(nomText, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(passText2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passText1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(prenomText, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AlreadyAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(infoMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passText1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passText2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(infoMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AlreadyAccount)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Deja un compte -> retour sur la page d econnexion
    private void AlreadyAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlreadyAccountMousePressed
        BackToAuthFrame();
    }//GEN-LAST:event_AlreadyAccountMousePressed

    // On essaye d ecree le compte avec les champs renseignés
    private void RegisterButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterButtonMousePressed
        String prenom = prenomText.getText();      
        String nom = nomText.getText();
        String email = emailText.getText().toLowerCase();
        
        String pass1 = new String(passText1.getPassword());
        String pass2 = new String(passText2.getPassword());
        
        String groupe = User.groupList[0];
        
        if(pass1.equals(pass2)) // Les deux mdp renseignés sont-il bien identique ?
        {
            if (DataBase.CreateUser(nom, prenom, email, pass1, groupe))
                BackToAuthFrame();
            else
                infoMessage.setText("Erreur : Un ou plusieurs champs sont invalides !");
        }
        else
            infoMessage.setText("Les deux mots de passe ne sont pas identiques et/ou pas renseignés.");
    }//GEN-LAST:event_RegisterButtonMousePressed

    // retour sur la page d'authentification
    private void BackToAuthFrame(){ // Retour sur la page d'authentification
        this.dispose();
        new AuthentificationFrame().setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccountFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlreadyAccount;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel infoMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nomText;
    private javax.swing.JPasswordField passText1;
    private javax.swing.JPasswordField passText2;
    private javax.swing.JTextField prenomText;
    // End of variables declaration//GEN-END:variables
}
