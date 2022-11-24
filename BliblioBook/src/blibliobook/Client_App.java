package blibliobook;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class Client_App extends javax.swing.JFrame {

    private final DataBase db;
    private int userID = 0;
    
    // Constructor par defaut
    public Client_App(){
        db = new DataBase();
        initComponents();
        initClientApp();
    }
    
    // Constructor avec l'ID de l'utilisateur passé en parametre
    public Client_App(int p_userID) {
        initComponents();
        db = new DataBase();
        this.userID = p_userID;
        initClientApp();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InfoMessage = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        BookPanel = new javax.swing.JPanel();
        BookList_Scroll = new javax.swing.JScrollPane();
        BookList_table = new javax.swing.JTable();
        createLoanButton = new javax.swing.JButton();
        BookChoice_comboBox = new javax.swing.JComboBox<>();
        loanDuration = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        LoanPanel = new javax.swing.JPanel();
        LoanList_Scroll = new javax.swing.JScrollPane();
        LoanList_table = new javax.swing.JTable();
        LoanChoice_comboBox = new javax.swing.JComboBox<>();
        finishLoanButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        InfoMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InfoMessage.setForeground(new java.awt.Color(51, 153, 255));

        Name.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("Prénom Nom");
        Name.setToolTipText("");

        logoutButton.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        logoutButton.setText("Se deconnecter");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutButtonMousePressed(evt);
            }
        });

        BookList_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titre", "Auteur", "Catégorie", "Disponible", "Date ajout"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BookList_table.setName("Books"); // NOI18N
        BookList_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BookList_Scroll.setViewportView(BookList_table);
        if (BookList_table.getColumnModel().getColumnCount() > 0) {
            BookList_table.getColumnModel().getColumn(0).setMinWidth(100);
            BookList_table.getColumnModel().getColumn(0).setPreferredWidth(100);
            BookList_table.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        createLoanButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createLoanButton.setText("Nouvel emprunt");
        createLoanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createLoanButtonMousePressed(evt);
            }
        });

        BookChoice_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous les livres", "Livres disponibles", "Livres non disponibles" }));
        BookChoice_comboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BookChoice_comboBox1ItemStateChanged(evt);
            }
        });

        loanDuration.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loanDuration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loanDuration.setText("1");
        loanDuration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                loanDurationKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Durée de l'emprunt (en jours) :");

        javax.swing.GroupLayout BookPanelLayout = new javax.swing.GroupLayout(BookPanel);
        BookPanel.setLayout(BookPanelLayout);
        BookPanelLayout.setHorizontalGroup(
            BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BookList_Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BookChoice_comboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(loanDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(createLoanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        BookPanelLayout.setVerticalGroup(
            BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BookChoice_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BookList_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loanDuration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createLoanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LoanList_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ref emprunt", "Titre", "Date emprunt", "Date rendu prevue", "Date rendu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        LoanList_table.setMinimumSize(new java.awt.Dimension(175, 0));
        LoanList_table.setName("Emprunts"); // NOI18N
        LoanList_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        LoanList_table.getTableHeader().setResizingAllowed(false);
        LoanList_table.getTableHeader().setReorderingAllowed(false);
        LoanList_Scroll.setViewportView(LoanList_table);
        if (LoanList_table.getColumnModel().getColumnCount() > 0) {
            LoanList_table.getColumnModel().getColumn(0).setMinWidth(70);
            LoanList_table.getColumnModel().getColumn(0).setPreferredWidth(70);
            LoanList_table.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        LoanChoice_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emprunts en cour", "Emprunts terminés" }));
        LoanChoice_comboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                LoanChoice_comboBoxItemStateChanged(evt);
            }
        });

        finishLoanButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        finishLoanButton.setText("Rendre le livre");
        finishLoanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                finishLoanButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout LoanPanelLayout = new javax.swing.GroupLayout(LoanPanel);
        LoanPanel.setLayout(LoanPanelLayout);
        LoanPanelLayout.setHorizontalGroup(
            LoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoanList_Scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoanPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LoanChoice_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoanPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(finishLoanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        LoanPanelLayout.setVerticalGroup(
            LoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoanChoice_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LoanList_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(finishLoanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(InfoMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(InfoMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(LoanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // deconnexion de l'utilisateur, renvoyé sur la page d'authentification
    private void logoutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMousePressed
        this.dispose();
        new AuthentificationFrame().setVisible(true);
    }//GEN-LAST:event_logoutButtonMousePressed

    // Recharge la liste des emprunts en fonction du filtrage imposé par la combobox
    private void LoanChoice_comboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_LoanChoice_comboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) // L'evenement peut soir etre deselection, soit selection, ici nous                                       //voulons nous concentrer sur la selection.
        {
            if (LoanChoice_comboBox.getSelectedIndex() == 0)
            {
                UpdateLoanTable(false);
                finishLoanButton.setEnabled(true);
            }
            else
            {
                UpdateLoanTable(true);
                finishLoanButton.setEnabled(false);
            }
        }
    }//GEN-LAST:event_LoanChoice_comboBoxItemStateChanged

    // Termine un emprunt de la liste
    private void finishLoanButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishLoanButtonMousePressed
        int selectedLoan = (Integer)LoanList_table.getValueAt(LoanList_table.getSelectedRow(), 0);
        
        if(DataBase.IsDataExist(selectedLoan, DataBase.loanTable)){
            
            LoanList_table.setRowSelectionInterval(0, 0);
            int finishResult = DataBase.FinishLoan(selectedLoan);
            
            if(finishResult > 0){
                String msg = "Fin de l'emprunt reussi.";
                // On compare la date rendu et date rendu prevue
                
                // Si rendu en retard, on dit attention
                if(finishResult == 2){
                    msg += " ATTENTION : Livre rendu en retard. Une pénalité est appliquer a votre compte.";
                }
                SetInfoMessage(msg);
            }
            else
                SetInfoMessage("Une erreur est survenue, impossible de terminer l'emprunt correctement.");
            ResetTables();
        }
    }//GEN-LAST:event_finishLoanButtonMousePressed

    // Recharge la liste des livres en fonction du filtrage imposé par la combobox
    private void BookChoice_comboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BookChoice_comboBox1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) // L'evenement peut soit etre deselection, soit selection, ici nous voulons nous concentrer sur la selection.
        {
            switch (BookChoice_comboBox.getSelectedIndex()) {
                case 0 -> UpdateBookTable(false, false, "");
                case 1 -> UpdateBookTable(true, true, "");
                default -> UpdateBookTable(true, false, "");
            }
        }
    }//GEN-LAST:event_BookChoice_comboBox1ItemStateChanged

    // On verifie qu'on rentre bien des chiffres pour la durée de l'emprunt
    private void loanDurationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loanDurationKeyTyped
       char c = evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
           getToolkit().beep();
          evt.consume();
       }
    }//GEN-LAST:event_loanDurationKeyTyped

    // On essaye de cree un nouvel emprunt
    private void createLoanButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createLoanButtonMousePressed
        int nbrJour = Integer.parseInt(loanDuration.getText());  // On recupere le la duree du champs de texte et on la transforme en Int
        
        if(nbrJour < 1 || nbrJour > 20) // On emprunte un livre pour 1 - 20 jour, ni + ni -
            SetInfoMessage("Nombre de jours de l'emprunt invalide, un emprunt peut etre fait pour une durée de 1 à 20 jours max.");
        
        else {
            
            int bookID = (Integer)BookList_table.getValueAt(BookList_table.getSelectedRow(), 0);
            if(DataBase.CreateLoan(userID, bookID, nbrJour))
                SetInfoMessage("Emprunt reussi pour une duré de " + nbrJour + " jours. Bonne lecture !");
            else
                SetInfoMessage("L'emprunt n'a pas pu se faire correctement ! Peut-etre avez vous deja un exemplaire de ce livre..");

            ResetTables();
        }
        
        loanDuration.setText("1");
    }//GEN-LAST:event_createLoanButtonMousePressed

    // - main -
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client_App().setVisible(true);
            }
        });
    }
    
    
    // -------------------------------------------------------------------------------- --------------------------------------------------------------------------------

    // Initialisation de l'interface au demarrage de la Frame
    private void initClientApp(){
        // On charge le nom et le prénom pour montrer qui est connecté
        try{
            
            
            // A mettre en commentaire si on veut lancer Client_app sans passer par l'authentification
            if(userID == 0)
                throw new RuntimeException("Erreur compte utilisateur. Pas une connexion depuis la page authentification.");
            
            
            //userID = 1; // Pour tester Client_app sans avoir besoin de ce connecter a chaque foi, renseigné l'id d el'utilisateur dans le groupe bliblio
            
            DataBase.stmt = DataBase.conn.createStatement(); 
            
            // Nom et prenom de l'utilisateur connecté
            String query = "SELECT Prenom, Nom FROM " + DataBase.userTable + " WHERE ID = " + userID;
            ResultSet result = DataBase.stmt.executeQuery(query);
            
            if(result.next()){
               Name.setText(result.getString("Prenom") + " " + result.getString("Nom").toUpperCase());
            }
            
            DataBase.stmt.close();
            
            this.BookList_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent event) { // On change l'interafce des boutons en fonction du livre selectioné
                    if(event.getValueIsAdjusting() == false) // Suppression des lignes ignoré sinon out of bound array 
                        return;
                    
                    UpdateLoanCreationWidgetBySelectedRow();
                }
            });
            
            ResetTables(); // 
            
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur Init Client : " + sqlExcept.getMessage());
        }
    }
    
    // active / desactive le bouton & le champs de texte pour faire un nouvel emprunt en fonction du livre selectionné
    private void UpdateLoanCreationWidgetBySelectedRow(){
        if ("Disponible".equals(BookList_table.getValueAt(BookList_table.getSelectedRow(), 4).toString())){ // Livre dispo
            EnableLoanCreationWidget(true); // On peut emprunter
        }
        else{
            EnableLoanCreationWidget(false); // On peut pas emprunter, le livre n'est pas dispo
        }
    }
    
    private void EnableLoanCreationWidget(boolean enabled){
        createLoanButton.setEnabled(enabled);
        loanDuration.setEnabled(enabled);
    }
    
    // recharge les listes comme a la premiere initialisation
    private void ResetTables(){
        UpdateLoanTable(false);
        this.LoanChoice_comboBox.setSelectedIndex(0);
        
        UpdateBookTable(false, false, "");
        this.BookChoice_comboBox.setSelectedIndex(0);
    }
    
    
    // Recharge la liste des emprunts
    private void UpdateLoanTable(boolean loanFinished){
        try{
            List<Loan> Loans = DataBase.GetUserLoan(loanFinished, userID);      

            DefaultTableModel model = (DefaultTableModel) LoanList_table.getModel();
            Object rowData[] = new Object[LoanList_table.getColumnCount()];

            // On supprime les colonne existente
            while(model.getRowCount() > 0)
                model.removeRow(0);

            String bookTitle = "";

            for(int i = 0; i < Loans.size(); i++)
            {
                try{
                    DataBase.stmt = DataBase.conn.createStatement(); 
                    // On recup le titre du livre de cet emprunt
                    String query = "SELECT Titre FROM " + DataBase.bookTable + " WHERE ID = " + Loans.get(i).ID_Livre;
                    ResultSet result = DataBase.stmt.executeQuery(query);
                    if(result.next()){ bookTitle = result.getString("Titre"); }
                    DataBase.stmt.close();
                }
                catch (SQLException sqlExcept)
                {
                    bookTitle = "ID" + Integer.toString(Loans.get(i).ID_Livre); // Si probléme on affiche l'ID du livre.
                    System.out.println("Erreur get titre du livre : " + sqlExcept.getMessage());
                }

                rowData[0] = Loans.get(i).ID;
                rowData[1] = bookTitle;
                rowData[2] = Loans.get(i).dateEmprunt.toString();
                rowData[3] = Loans.get(i).dateRenduPrevue.toString();
                rowData[4] = Loans.get(i).dateRendu != null ? Loans.get(i).dateRendu.toString() : "Non rendu";  // livre rendu ? si oui on affiche la date, sinon on affiche non rendu.

                model.addRow(rowData);
            }
            
            if(model.getRowCount() <= 0)
                this.finishLoanButton.setEnabled(false);
            else {
                LoanList_table.setRowSelectionInterval(0, 0);
                this.finishLoanButton.setEnabled(true);
            }
        }
        catch(Exception e){
            System.out.println("Erreur dans updateLoanTable : " + e.getMessage());
        }
    }
    
    // recharge la liste des livres
    private void UpdateBookTable(boolean filter, boolean disponible, String categorie){
        try{
            List<Book>Books = DataBase.GetBook(filter, disponible, categorie);
            
            DefaultTableModel model = (DefaultTableModel) BookList_table.getModel();
            Object rowData[] = new Object[BookList_table.getColumnCount()];
            
            
            try{
                // On supprime les colonne existente
                while(model.getRowCount() > 0)
                    model.removeRow(0);
                
            }catch(Exception e){
                System.out.println("Erreur boucle suppression ligne " + e.getMessage());
            }
            
            try{
                
                for(int i = 0; i < Books.size(); i++)
                {
                    rowData[0] = Books.get(i).ID;
                    rowData[1] = Books.get(i).titre;
                    rowData[2] = Books.get(i).Auteur;
                    rowData[3] = Books.get(i).categorie;
                    rowData[4] = Books.get(i).stock > 0 ? "Disponible" : "Non Disponible";    
                    rowData[5] = Books.get(i).dateAjout.toString();

                    model.addRow(rowData);
                }
                
            }catch(Exception e){
                System.out.println("erreur dans boucle remplissage " + e.getMessage());
            }
            
            if(model.getRowCount() <= 0)
                EnableLoanCreationWidget(false);
            else {
                BookList_table.setRowSelectionInterval(0, 0);
                UpdateLoanCreationWidgetBySelectedRow(); // On active pas forcement les boutons pour faire un emprunt lorsque la liste
                                                         // n'est pas vide, notament dans le cas ou elle est composer de livres non disponibles.
            }
            
        }catch(Exception e){
            System.out.println("Erreur dans updatebookTable : " + e.getMessage());
        }
        
    }
    
    // affiche un message d'info / d'erreur apres une operation
    private void SetInfoMessage(String msg){
        // Text qui disparais au bout des quelques secondes ? Threading / waitsecond
        this.InfoMessage.setText(msg);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BookChoice_comboBox;
    private javax.swing.JScrollPane BookList_Scroll;
    private javax.swing.JTable BookList_table;
    private javax.swing.JPanel BookPanel;
    private javax.swing.JLabel InfoMessage;
    private javax.swing.JComboBox<String> LoanChoice_comboBox;
    private javax.swing.JScrollPane LoanList_Scroll;
    private javax.swing.JTable LoanList_table;
    private javax.swing.JPanel LoanPanel;
    private javax.swing.JLabel Name;
    private javax.swing.JButton createLoanButton;
    private javax.swing.JButton finishLoanButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField loanDuration;
    private javax.swing.JButton logoutButton;
    // End of variables declaration//GEN-END:variables
}
