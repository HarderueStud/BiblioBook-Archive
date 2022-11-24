package blibliobook;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.time.temporal.ChronoUnit;


public class Bliblio_App extends javax.swing.JFrame {

    private DataBase db;
    private int userID = 0;
    
    // Constructor avec l'id de l'utilistaeur en parametre 
    public Bliblio_App(int userID) {
        this.userID = userID;
        initComponents();
        this.db = new DataBase();
        InitBliblioApp();
    }
    
    // constru par defaut
    public Bliblio_App() {
        initComponents();
        this.db = new DataBase();
        InitBliblioApp();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InfoMessage = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserList_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        userSurname = new javax.swing.JTextField();
        userEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userGroup = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        userUpdateBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        bookUpdateBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        BookList_table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        bookTitle = new javax.swing.JTextField();
        bookAutor = new javax.swing.JTextField();
        bookStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bookCategory = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        bookRef = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        bookState = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookDescription = new javax.swing.JTextArea();
        loanNewBtn = new javax.swing.JButton();
        bookRazBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        LoanList_table = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        loanIDUtil = new javax.swing.JTextField();
        loanIDBook = new javax.swing.JTextField();
        loanDateRenduPrevue = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        bookNewBtn = new javax.swing.JButton();
        loanRazBtn = new javax.swing.JButton();
        loanUpdateBtn = new javax.swing.JButton();
        userChoice_combo = new javax.swing.JComboBox<>();
        bookChoice_combo = new javax.swing.JComboBox<>();
        loanChoice_combo = new javax.swing.JComboBox<>();
        userDeleteBtn = new javax.swing.JButton();
        bookDeleteBtn = new javax.swing.JButton();
        loanDeleteBtn = new javax.swing.JButton();
        bookRandomRefBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        InfoMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InfoMessage.setForeground(new java.awt.Color(51, 153, 255));
        InfoMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Name.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        Name.setForeground(new java.awt.Color(0, 153, 153));
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

        UserList_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom", "Prénom", "Email", "Groupe", "Date inscription"
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
        UserList_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(UserList_table);
        if (UserList_table.getColumnModel().getColumnCount() > 0) {
            UserList_table.getColumnModel().getColumn(0).setMinWidth(50);
            UserList_table.getColumnModel().getColumn(0).setPreferredWidth(50);
            UserList_table.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel1.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel1.setText("Utilisateurs");

        userName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        userSurname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        userEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userEmail.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nom");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Prénom");

        userGroup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Groupe");

        userUpdateBtn.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        userUpdateBtn.setText("Modifier");
        userUpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userUpdateBtnMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Catégorie");

        bookUpdateBtn.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        bookUpdateBtn.setText("Modifier");
        bookUpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bookUpdateBtnMousePressed(evt);
            }
        });

        BookList_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ref", "Titre", "Catégorie", "Date ajout", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        BookList_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(BookList_table);
        if (BookList_table.getColumnModel().getColumnCount() > 0) {
            BookList_table.getColumnModel().getColumn(0).setMinWidth(50);
            BookList_table.getColumnModel().getColumn(0).setPreferredWidth(50);
            BookList_table.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel7.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel7.setText("Livres");

        bookTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bookAutor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bookStock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bookStock.setToolTipText("");
        bookStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bookStockKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Titre");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Stock");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Auteur");

        bookCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Reference");

        bookRef.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Etat");

        bookState.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bookState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bookStateKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Description");

        bookDescription.setColumns(20);
        bookDescription.setLineWrap(true);
        bookDescription.setRows(5);
        bookDescription.setWrapStyleWord(true);
        jScrollPane3.setViewportView(bookDescription);

        loanNewBtn.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        loanNewBtn.setText("Nouveau");
        loanNewBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loanNewBtnMousePressed(evt);
            }
        });

        bookRazBtn.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        bookRazBtn.setText("RAZ");
        bookRazBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bookRazBtnMousePressed(evt);
            }
        });

        LoanList_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Utilisateur", "Livre", "Date Emprunt", "Date rendu prevue", "Date rendu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        LoanList_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(LoanList_table);
        if (LoanList_table.getColumnModel().getColumnCount() > 0) {
            LoanList_table.getColumnModel().getColumn(0).setMinWidth(50);
            LoanList_table.getColumnModel().getColumn(0).setPreferredWidth(50);
            LoanList_table.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel14.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel14.setText("Emprunt");

        loanIDUtil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loanIDUtil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                loanIDUtilKeyTyped(evt);
            }
        });

        loanIDBook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loanIDBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                loanIDBookKeyTyped(evt);
            }
        });

        loanDateRenduPrevue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loanDateRenduPrevue.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Utilisateur");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Date rendu prevue");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Livre");

        bookNewBtn.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        bookNewBtn.setText("Nouveau");
        bookNewBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bookNewBtnMousePressed(evt);
            }
        });

        loanRazBtn.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        loanRazBtn.setText("RAZ");
        loanRazBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loanRazBtnMousePressed(evt);
            }
        });

        loanUpdateBtn.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        loanUpdateBtn.setText("Modifier");
        loanUpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loanUpdateBtnMousePressed(evt);
            }
        });

        userChoice_combo.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        userChoice_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous les utilisateurs", "Les clients", "Les blibliothecaires" }));
        userChoice_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                userChoice_comboItemStateChanged(evt);
            }
        });

        bookChoice_combo.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        bookChoice_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous les livres", "Livres disponibles", "Livres non disponibles" }));
        bookChoice_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookChoice_comboItemStateChanged(evt);
            }
        });

        loanChoice_combo.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        loanChoice_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emprunts en cour", "Emprunts terminés" }));
        loanChoice_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                loanChoice_comboItemStateChanged(evt);
            }
        });

        userDeleteBtn.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        userDeleteBtn.setText("Supprimer");
        userDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userDeleteBtnMousePressed(evt);
            }
        });

        bookDeleteBtn.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        bookDeleteBtn.setText("Supprimer");
        bookDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bookDeleteBtnMousePressed(evt);
            }
        });

        loanDeleteBtn.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        loanDeleteBtn.setText("Terminer");
        loanDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loanDeleteBtnMousePressed(evt);
            }
        });

        bookRandomRefBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bookRandomRefBtn.setText("?");
        bookRandomRefBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bookRandomRefBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Name)
                                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(InfoMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(userSurname)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(userEmail)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(userGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addComponent(userUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(userDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(userChoice_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(loanIDUtil, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(loanIDBook)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(loanDateRenduPrevue)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(loanUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(loanNewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(loanRazBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(loanDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 24, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(1, 1, 1))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bookStock, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bookState)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bookRazBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bookDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bookUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bookNewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bookRandomRefBtn)
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bookRef)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bookTitle)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bookAutor)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bookCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bookChoice_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loanChoice_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(InfoMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(userChoice_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(userSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(userGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(userUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(userDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(bookChoice_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bookRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(bookAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(29, 29, 29)))))
                    .addComponent(bookRandomRefBtn))
                .addGap(26, 26, 26)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bookUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bookNewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bookRazBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bookDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(bookState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(bookStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50)
                .addComponent(jLabel14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loanChoice_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loanUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loanNewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loanRazBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loanDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loanIDUtil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loanDateRenduPrevue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loanIDBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // On deconnecte l'utilisateur -> retour a la page d'authentification
    private void logoutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMousePressed
        this.dispose();
        new AuthentificationFrame().setVisible(true);
    }//GEN-LAST:event_logoutButtonMousePressed

    // On essaye de mettre a jour l'utilisateur
    private void userUpdateBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userUpdateBtnMousePressed
        //System.out.println(UserList_table.getSelectedRow());
        if(UserList_table.getSelectedRow() == -1){
            SetInfoMessage("Il faut selectionner un utilisateur pour effectuer des actions dessu.");
            return;
        }
        
        int selectedUser = (Integer)UserList_table.getValueAt(UserList_table.getSelectedRow(), 0);
        String nom = userName.getText();
        String prenom = userSurname.getText();
        String email = userEmail.getText();
        String groupe = User.groupList[userGroup.getSelectedIndex()];
        
        System.out.println("groupe : " + groupe);
                
        if(DataBase.IsDataExist(selectedUser, DataBase.userTable)){
            String msg = "Une erreur est survenue durant la mise a jour de l'utilisateur ID " + Integer.toString(selectedUser);
            if(DataBase.UpdateUser(selectedUser, nom, prenom, email, groupe)){
               msg = "Utilisateur mis a jour avec succee.";
               RazUserFields();
               ResetTables();
            }
                
            SetInfoMessage(msg);
        }
    }//GEN-LAST:event_userUpdateBtnMousePressed

    // On essaye de cree un nouveau livre
    private void bookNewBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookNewBtnMousePressed
       String auteur = this.bookAutor.getText();
       String description = this.bookDescription.getText();
       String ref = this.bookRef.getText();
       
       if(this.bookState.getText().isEmpty() || this.bookStock.getText().isEmpty()){ // evite les parse de chaine vide
           SetInfoMessage("Tous les champs doivent être remplis !");
           return;
       }
       
       int etat = Integer.parseInt(this.bookState.getText()); // pas besoin de try si c'est parsable, on a deja verifier que le texte renseigné etait des chiffres
       int stock = Integer.parseInt(this.bookStock.getText()); // idem
       String titre = this.bookTitle.getText();
        
       String category = Book.CategoryList[this.bookCategory.getSelectedIndex()];
       
       String msg = "Une erreur est survenue durant la creation d'un nouveau livre !";
       if(DataBase.CreateBook(titre, category, ref, auteur, description, etat, stock)){
           msg = "Creation du livre reussie !";
           ResetTables();
           RazBookFields(); // Update du tableau -> deselection, si deselection on doit vider les champs, sinon on accede a une selection vide -> erreur
       }
       
       SetInfoMessage(msg);
    }//GEN-LAST:event_bookNewBtnMousePressed

    // On essaye de mettre a jour un livre (existant)
    private void bookUpdateBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookUpdateBtnMousePressed
        if(BookList_table.getSelectedRow() == -1){
            SetInfoMessage("Il faut selectionner un livre pour effectuer des actions dessu.");
            return;
        }
       int selectedBook = (Integer)BookList_table.getValueAt(BookList_table.getSelectedRow(), 0);
       
       String auteur = this.bookAutor.getText();
       String description = this.bookDescription.getText();
       String ref = this.bookRef.getText();
       
       if(this.bookState.getText().isEmpty() || this.bookStock.getText().isEmpty()){ // evite les parse de chaine vide
           SetInfoMessage("Tous les champs doivent être remplis !");
           return;
       }
       
       int etat = Integer.parseInt(this.bookState.getText()); // pas besoin de try si c'est parsable, on a deja verifier que le texte renseigné etait des chiffres
       int stock = Integer.parseInt(this.bookStock.getText()); // idem
       String titre = this.bookTitle.getText();
        
       String category = Book.CategoryList[this.bookCategory.getSelectedIndex()];
       
       String msg = "Une erreur est survenue durant la mise a jour du livre " + selectedBook;
       if(DataBase.UpdateBook(selectedBook, titre, category, ref, auteur, description, etat, stock)){
           msg = "Mise a jour du livre reussie !";
           ResetTables();
           RazBookFields(); // Update du tableau -> deselection, si deselection on doit vider les champs, sinon on accede a une selection vide -> erreur
       }
       
       SetInfoMessage(msg);
    }//GEN-LAST:event_bookUpdateBtnMousePressed

    // On clear les champs de textes en rapport avec les livres
    private void bookRazBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookRazBtnMousePressed
        RazBookFields();
    }//GEN-LAST:event_bookRazBtnMousePressed

    private void RazBookFields(){
        this.BookList_table.clearSelection();
        //this.BookList_table.setRowSelectionInterval(0, 0);
                
        this.bookAutor.setText("");
        this.bookDescription.setText("");
        this.bookRef.setText("");
        this.bookState.setText("");
        this.bookStock.setText("");
        this.bookTitle.setText("");
        
        this.bookCategory.setSelectedIndex(0);
    }
    
    // On essaye d emettre a jour un emprunt existant
    private void loanUpdateBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loanUpdateBtnMousePressed
        if(LoanList_table.getSelectedRow() == -1){
            SetInfoMessage("Il faut selectionner un emprunt pour effectuer des actions dessu.");
            return;
        }
        try{
            int selectedLoan = (Integer)LoanList_table.getValueAt(LoanList_table.getSelectedRow(), 0);
       
            if(this.loanIDUtil.getText().isEmpty() || this.loanIDBook.getText().isEmpty())
            {
                SetInfoMessage("Tous les champs doivent être remplis !");
                return;
            }

            int idUser = Integer.parseInt(this.loanIDUtil.getText());
            int idBook = Integer.parseInt(this.loanIDBook.getText());
            Date dateRenduPrevue = Date.valueOf(this.loanDateRenduPrevue.getText());

            String msg = "Une erreur est survenue durant la mise a jour de l'emprunt " + selectedLoan;
            if(DataBase.UpdateLoan(selectedLoan, idUser, idBook, dateRenduPrevue)){
                msg = "Mise a jour de l'emprunt reussie !";
                ResetTables();
                RazLoanFields(); // Update du tableau -> deselection, si deselection on doit vider les champs, sinon on accede a une selection vide -> erreur
            }

            SetInfoMessage(msg);
        }catch(Exception e){
            SetInfoMessage("Une erreur est survenue durant la mise a jour de l'emprunt ! verifier les champs renseignés !");
            
            System.out.println("Erreur loanUpdateBtn : " +  e.getMessage());
        }  
    }//GEN-LAST:event_loanUpdateBtnMousePressed

    // On essaye de cree un nouvel emprunt a partir des champs renseignés
    private void loanNewBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loanNewBtnMousePressed
        if(this.loanIDUtil.getText().isEmpty() || this.loanIDBook.getText().isEmpty() || this.loanDateRenduPrevue.getText().isEmpty())
       {
           SetInfoMessage("Tous les champs doivent être remplis !");
           return;
       }
       try{
            int idUser = Integer.parseInt(this.loanIDUtil.getText());
            int idBook = Integer.parseInt(this.loanIDBook.getText());
            Date dateRenduPrevue = Date.valueOf(this.loanDateRenduPrevue.getText());

            // Calcul la duree de l'emprunt prevu en jour pour le constructeur de l'emprunt
            int noOfDaysBetween = (int)ChronoUnit.DAYS.between(DataBase.GetActualDate().toLocalDate(), dateRenduPrevue.toLocalDate());
            System.out.println("Nombre de jour : " + noOfDaysBetween);
            if(noOfDaysBetween <= 0)
            {
                SetInfoMessage("La date est invalide, la date de rendu prevue doit etre dans le futur, avec minimum 1 jours.");
                System.out.println("Erreur le nombre d ejour d el'emprunt ne peut etre <= 0 ");
            }
            
            String msg = "Une erreur est survenue durant la création de l'emprunt ";
            if(DataBase.CreateLoan(idUser, idBook, noOfDaysBetween)){
                msg = "Création de l'emprunt reussie !";
                ResetTables();
                RazLoanFields(); // Update du tableau -> deselection, si deselection on doit vider les champs, sinon on accede a une selection vide -> erreur
            }

            SetInfoMessage(msg);
        } catch(Exception e){
            SetInfoMessage("Une erreur est survenue durant la création de l'emprunt ! verifier les champs renseignés !");
            
            System.out.println("Erreur loanNewBtn : " +  e.getMessage());
        }
       
    }//GEN-LAST:event_loanNewBtnMousePressed

    // Idem que BookRaz, mais pour les emprunts
    private void loanRazBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loanRazBtnMousePressed
       RazLoanFields();
    }//GEN-LAST:event_loanRazBtnMousePressed

    private void RazLoanFields(){
        this.LoanList_table.clearSelection();
        
       this.loanDateRenduPrevue.setText("");
       this.loanIDBook.setText("");
       this.loanIDUtil.setText("");
    }
    
    // Verification utilisateur rentre bien des chiffres
    private void loanIDBookKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loanIDBookKeyTyped
       char c = evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
           getToolkit().beep();
          evt.consume();
       }
    }//GEN-LAST:event_loanIDBookKeyTyped
    // idem
    private void loanIDUtilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loanIDUtilKeyTyped
       char c = evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
           getToolkit().beep();
          evt.consume();
       }
    }//GEN-LAST:event_loanIDUtilKeyTyped
    // idem
    private void bookStateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookStateKeyTyped
       char c = evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
           getToolkit().beep();
          evt.consume();
       }
    }//GEN-LAST:event_bookStateKeyTyped
    // idem
    private void bookStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookStockKeyTyped
       char c = evt.getKeyChar();
       if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
           getToolkit().beep();
          evt.consume();
       }
    }//GEN-LAST:event_bookStockKeyTyped

    
    // On met a jour la liste utilisateur en fonction du filtrage appliquer par la combobox
    private void userChoice_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_userChoice_comboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) // L'evenement peut soit etre deselection, soit selection, ici nous voulons nous concentrer sur la selection.
        {
            switch (this.userChoice_combo.getSelectedIndex()) {
                case 0 -> UpdateUserTable(false, false);
                case 1 -> UpdateUserTable(true, true);
                default -> UpdateUserTable(true, false);
            }
        }
    }//GEN-LAST:event_userChoice_comboItemStateChanged
    
    // On met a jour la liste de slivres en fonction du filtrage appliquer par la combobox
    private void bookChoice_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookChoice_comboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) // L'evenement peut soit etre deselection, soit selection, ici nous voulons nous concentrer sur la selection.
        {
            switch (this.bookChoice_combo.getSelectedIndex()) {
                case 0 -> UpdateBookTable(false, false, "");
                case 1 -> UpdateBookTable(true, true, "");
                default -> UpdateBookTable(true, false, "");
            }
        }
    }//GEN-LAST:event_bookChoice_comboItemStateChanged

    // On met a jour la liste des emprunts en fonction du filtrage appliqué par la combobox
    private void loanChoice_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_loanChoice_comboItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) // L'evenement peut soir etre deselection, soit selection, ici nous                                       //voulons nous concentrer sur la selection.
        {
            if (loanChoice_combo.getSelectedIndex() == 0)
            {
                UpdateLoanTable(false);
                EnableLoanFields(true);
            }
            else
            {
                UpdateLoanTable(true);
                EnableLoanFields(false);
            }
        }
    }//GEN-LAST:event_loanChoice_comboItemStateChanged

    // Active / desactive les champs de textes / les boutons concernant les emprunts
    private void EnableLoanFields(boolean enabled){
        loanIDUtil.setEnabled(enabled);
        loanIDBook.setEnabled(enabled);                
        loanDateRenduPrevue.setEnabled(enabled);
        
        loanDeleteBtn.setEnabled(enabled);
        loanNewBtn.setEnabled(enabled);
        loanRazBtn.setEnabled(enabled);
        loanUpdateBtn.setEnabled(enabled);
    }
    
    // On essaye de supprimer un utilisateur
    private void userDeleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userDeleteBtnMousePressed
        if(UserList_table.getSelectedRow() == -1){
            SetInfoMessage("Il faut selectionner un utilisateur pour effectuer des actions dessu.");
            return;
        }
        int selectedUser = (Integer)UserList_table.getValueAt(UserList_table.getSelectedRow(), 0);
        
        if(selectedUser == this.userID){ // On regarde si le compte supprimer c'est celui avec lequel l'utilisateur est connecter
            SetInfoMessage("Impossible de supprimer le compte avec lequel vous etes connecté actuellement.");
            return;
        }
        
        if(DataBase.IsDataExist(selectedUser, DataBase.userTable)){
            String msg = "Une erreur est survenue durant la suppression de l'utilisateur ID " + Integer.toString(selectedUser);
            if(DataBase.DeleteData(selectedUser, DataBase.userTable)){
               msg = "Utilisateur supprimer avec succee.";
               ResetTables();
                RazUserFields();
            }
                
            SetInfoMessage(msg);
        }
    }//GEN-LAST:event_userDeleteBtnMousePressed

    // idem que RazLoan et RazBook
    private void RazUserFields(){
        UserList_table.clearSelection();
        
        this.userEmail.setText("");
        this.userName.setText("");
        this.userSurname.setText("");

        this.userGroup.setSelectedIndex(0);
    }
    
    // On essaye de supprimer un livre
    private void bookDeleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookDeleteBtnMousePressed
        if(BookList_table.getSelectedRow() == -1){
            SetInfoMessage("Il faut selectionner un livre pour effectuer des actions dessu.");
            return;
        }
        
        int selectedBook = (Integer)BookList_table.getValueAt(BookList_table.getSelectedRow(), 0);
        if(DataBase.IsDataExist(selectedBook, DataBase.bookTable)){
            String msg = "Une erreur est survenue durant la suppression du livre ID " + Integer.toString(selectedBook);
            if(DataBase.DeleteData(selectedBook, DataBase.bookTable)){
               msg = "Livre supprimer avec succee.";
               ResetTables();
               RazBookFields();
            }
               
            SetInfoMessage(msg);
        }
    }//GEN-LAST:event_bookDeleteBtnMousePressed

    // On essaye de supprimer un emprunt (on le termine -> il ne disparait pas de la BDD, la date de rendu est mise a jour)
    private void loanDeleteBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loanDeleteBtnMousePressed
        if(LoanList_table.getSelectedRow() == -1){
            SetInfoMessage("Il faut selectionner un emprunt pour effectuer des actions dessu.");
            return;
        }
        
        // ~Duplication Avec client_app, fonction static ? -> Cas par cas, si le code evolue on voudra faire des choses personnalisées (retour de message ect)
        int selectedLoan = (Integer)LoanList_table.getValueAt(LoanList_table.getSelectedRow(), 0);
        
        if(DataBase.IsDataExist(selectedLoan, DataBase.loanTable)){
            
            int finishResult = DataBase.FinishLoan(selectedLoan);
            String msg = "Une erreur est survenue, impossible de terminer l'emprunt correctement.";
            
            if(finishResult > 0){
                msg = "Fin de l'emprunt reussi.";
                // On compare la date rendu et date rendu prevue
                
                // Si rendu en retard, on dit attention
                if(finishResult == 2){
                    msg += " ATTENTION : Livre rendu en retard. Une pénalité pourrait etre appliquer au compte client qui a fait cet emprunt.";
                }
                ResetTables();
                RazLoanFields();
            }
            SetInfoMessage(msg);
        }
    }//GEN-LAST:event_loanDeleteBtnMousePressed

    // Genere une reference de maniere aleatoire pour un nouveau livre. Pour faire des tests / gagner du temps
    private void bookRandomRefBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookRandomRefBtnMousePressed
        RandomStringGenerator rendS = new RandomStringGenerator(12, ThreadLocalRandom.current()); 
        bookRef.setText(rendS.nextString()); 
    }//GEN-LAST:event_bookRandomRefBtnMousePressed

    // Recharge les tableaux / listes comme lors de l'initialisation d ela page
    private void ResetTables(){
        UpdateLoanTable(false);
        this.loanChoice_combo.setSelectedIndex(0);
        
        UpdateBookTable(false, false, "");
        this.bookChoice_combo.setSelectedIndex(0);
        
        UpdateUserTable(false, false);
        this.userChoice_combo.setSelectedIndex(0);
    }
    
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
            java.util.logging.Logger.getLogger(Bliblio_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bliblio_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bliblio_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bliblio_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bliblio_App().setVisible(true);
            }
        });
    }

    // Initialisation de l'interface au demarrage de la frame
    private void InitBliblioApp(){
        // On charge le nom et le prénom pour montrer qui est connecté
        try{
            
            if(userID == 0) // + verif l'utilisateur est bien dans le bon groupe ?
                throw new RuntimeException("Erreur compte utilisateur. Pas une connexion depuis la page authentification.");
            
            //userID = 1; // Pour tester Client_app sans avoir besoin de ce connecter a chaque foi, renseigné l'id du client que l'on veut tester
            
            DataBase.stmt = DataBase.conn.createStatement(); 
            
            // Nom et prenom de l'utilisateur connecté
            String query = "SELECT Prenom, Nom FROM " + DataBase.userTable + " WHERE ID = " + userID;
            ResultSet result = DataBase.stmt.executeQuery(query);
            
            if(result.next()){
               Name.setText(result.getString("Prenom") + " " + result.getString("Nom").toUpperCase());
            }
            
            DataBase.stmt.close();
            
            // Listener -> evenement du tableau, la ligne selectionné a changer
            this.UserList_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent event) { // On change l'interafce des boutons en fonction du livre selectioné
                    if(event.getValueIsAdjusting() == false) // Suppression des lignes ignoré sinon out of bound array 
                        return;
                    
                    userName.setText(UserList_table.getValueAt(UserList_table.getSelectedRow(), 1).toString());
                    userSurname.setText(UserList_table.getValueAt(UserList_table.getSelectedRow(), 2).toString());
                    userEmail.setText(UserList_table.getValueAt(UserList_table.getSelectedRow(), 3).toString());
                    
                    
                    String target = UserList_table.getValueAt(UserList_table.getSelectedRow(), 4).toString();
                    //int index = Arrays.binarySearch(User.groupList, target);
                    int index = IntStream.range(0, User.groupList.length) // On utilise les stream -> ArrayBinaries ne trouve pas le groupe bliblio
					.filter(i -> (target == null ? User.groupList[i] == null : target.equals(User.groupList[i])))
					.findFirst()
					.orElse(-1);
                    
                    userGroup.setSelectedIndex(index);
                }
            });
            
            // Listener -> evenement du tableau, la ligne selectionné a changer
            this.BookList_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent event) { // On change l'interafce des boutons en fonction du livre selectioné
                    if(event.getValueIsAdjusting() == false) // Suppression des lignes ignoré sinon out of bound array 
                        return;
                    
                    int selectedBook = (Integer)BookList_table.getValueAt(BookList_table.getSelectedRow(), 0);
                    
                    bookRef.setText(BookList_table.getValueAt(BookList_table.getSelectedRow(), 1).toString());                    
                    bookTitle.setText(BookList_table.getValueAt(BookList_table.getSelectedRow(), 2).toString());
                    
                    String target = BookList_table.getValueAt(BookList_table.getSelectedRow(), 3).toString();
                    int index = IntStream.range(0, Book.CategoryList.length)
					.filter(i -> (target == null ? Book.CategoryList[i] == null : target.equals(Book.CategoryList[i])))
					.findFirst()
					.orElse(-1);
                    
                    bookCategory.setSelectedIndex(index);
                    
                    bookStock.setText(BookList_table.getValueAt(BookList_table.getSelectedRow(), 5).toString());
                    
                try{
                    DataBase.stmt = DataBase.conn.createStatement(); 
                    
                    //
                    String query = "SELECT Auteur, Description, Etat FROM " + DataBase.bookTable + " WHERE ID = " + selectedBook;
                    ResultSet result = DataBase.stmt.executeQuery(query);
                    if(result.next()){
                        bookAutor.setText(result.getString("Auteur"));
                        bookDescription.setText(result.getString("Description"));
                        bookState.setText(Integer.toString(result.getInt("Etat")));
                    }
                    DataBase.stmt.close();
                }
                catch (SQLException sqlExcept)
                {
                    bookAutor.setText("Erreur.");
                    bookDescription.setText("Erreur.");
                    bookState.setText("Erreur.");
                    System.out.println("Erreur get titre du livre : " + sqlExcept.getMessage());
                }
                    
                }
            });
            
            // Listener -> evenement du tableau, la ligne selectionné a changer
            this.LoanList_table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent event) { // On change l'interafce des boutons en fonction du livre selectioné
                    if(event.getValueIsAdjusting() == false) // Suppression des lignes ignoré sinon out of bound array 
                        return;
                    
                    loanIDUtil.setText(LoanList_table.getValueAt(LoanList_table.getSelectedRow(), 1).toString());
                    loanIDBook.setText(LoanList_table.getValueAt(LoanList_table.getSelectedRow(), 2).toString());                    
                    loanDateRenduPrevue.setText(LoanList_table.getValueAt(LoanList_table.getSelectedRow(), 4).toString());
                }
            });
            
            
            ResetTables();
            
            // On rempli la combobox dynamiquement dans lec as ou on veut rajouter des groupes d'utilisateur plus tard.
            for (String groupList : User.groupList) 
                this.userGroup.addItem(groupList);
            
            // On rempli la liste des categories dans le cas ou l'on voudrait rajouter des types de livres plus tard.
            for (String CategoryList : Book.CategoryList) 
                this.bookCategory.addItem(CategoryList);
            
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur Init Client : " + sqlExcept.getMessage());
        }
    }

    // On recharge la liste des emprunts
    private void UpdateLoanTable(boolean loanFinished){
        try{
            List<Loan> Loans = DataBase.GetUserLoan(loanFinished, 0); // 0 -> On veut TOUS les emprunts et non seulement ceux d'un seul utilisateur. 

            DefaultTableModel model = (DefaultTableModel) LoanList_table.getModel();
            Object rowData[] = new Object[LoanList_table.getColumnCount()];

            // On supprime les colonne existente
            while(model.getRowCount() > 0)
                model.removeRow(0);

            String l_bookTitle = ""; // On recupere le titre du livre emprunté
            String l_userEmail = ""; // on recupere l'email de l'utilisateur qui a fait l'emprunt

            for(int i = 0; i < Loans.size(); i++)
            {
                try{
                    DataBase.stmt = DataBase.conn.createStatement(); 
                    // On recup le titre du livre de cet emprunt
                    String query = "SELECT Titre FROM " + DataBase.bookTable + " WHERE ID = " + Loans.get(i).ID_Livre;
                    ResultSet result = DataBase.stmt.executeQuery(query);
                    if(result.next()){ l_bookTitle = result.getString("Titre"); }
                    
                    // On recup le titre du livre de cet emprunt
                    query = "SELECT Email FROM " + DataBase.userTable + " WHERE ID = " + Loans.get(i).ID_Utilisateur;
                    result = DataBase.stmt.executeQuery(query);
                    if(result.next()){ l_userEmail = result.getString("Email"); }
                    DataBase.stmt.close();
                }
                catch (SQLException sqlExcept)
                {
                    l_bookTitle = "ID" + Integer.toString(Loans.get(i).ID_Livre); // Si probléme on affiche l'ID du livre.
                    System.out.println("Erreur get titre du livre : " + sqlExcept.getMessage());
                }
                
                // Pour des raisons de simpliciter, nous afficheront les ID et non le titre et l'adresse email.
                rowData[0] = Loans.get(i).ID;
                rowData[1] = Loans.get(i).ID_Utilisateur; //l_userEmail;
                rowData[2] = Loans.get(i).ID_Livre;//l_bookTitle;
                rowData[3] = Loans.get(i).dateEmprunt.toString();
                rowData[4] = Loans.get(i).dateRenduPrevue.toString();
                rowData[5] = Loans.get(i).dateRendu != null ? Loans.get(i).dateRendu.toString() : "Non rendu";  // livre rendu ? si oui on affiche la date, sinon on affiche non rendu.

                model.addRow(rowData);
            }
        }
        catch(Exception e){
            System.out.println("Erreur dans updateLoanTable : " + e.getMessage());
        }
    }
    
    // On recharge la liste des livres
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
                    rowData[1] = Books.get(i).ref;
                    rowData[2] = Books.get(i).titre;
                    rowData[3] = Books.get(i).categorie;
                    rowData[4] = Books.get(i).dateAjout.toString();
                    rowData[5] = Books.get(i).stock;
                    
                    model.addRow(rowData);
                }
            }catch(Exception e){
                System.out.println("erreur dans boucle remplissage " + e.getMessage());
            }
            
        }catch(Exception e){
            System.out.println("Erreur dans updatebookTable : " + e.getMessage());
        }
        
    }
    
    // On recharge la liste des utilisateurs
    private void UpdateUserTable(boolean filter, boolean isClient){
        try{
            List<User>Users = DataBase.GetUser(filter, isClient);
            
            DefaultTableModel model = (DefaultTableModel) UserList_table.getModel();
            Object rowData[] = new Object[UserList_table.getColumnCount()];
            
            
            try{
                // On supprime les colonne existente
                while(model.getRowCount() > 0)
                    model.removeRow(0);
                
            }catch(Exception e){
                System.out.println("Erreur boucle suppression ligne " + e.getMessage());
            }
            
            try{
                
                for(int i = 0; i < Users.size(); i++)
                {
                    rowData[0] = Users.get(i).ID;
                    rowData[1] = Users.get(i).nom;
                    rowData[2] = Users.get(i).prenom;
                    rowData[3] = Users.get(i).email;
                    rowData[4] = Users.get(i).groupe;
                    rowData[5] = Users.get(i).dateInscription.toString();
                    
                    model.addRow(rowData);
                }
            }catch(Exception e){
                System.out.println("erreur dans boucle remplissage " + e.getMessage());
            }
            
        }catch(Exception e){
            System.out.println("Erreur dans updateUserTable : " + e.getMessage());
        }
        
    }
    
    // Affiche un message en cas de succee / echec d'une operation.
    private void SetInfoMessage(String msg){
        // Text qui disparais au bout des quelques secondes ? Threading / waitsecond
        this.InfoMessage.setText(msg);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BookList_table;
    private javax.swing.JLabel InfoMessage;
    private javax.swing.JTable LoanList_table;
    private javax.swing.JLabel Name;
    private javax.swing.JTable UserList_table;
    private javax.swing.JTextField bookAutor;
    private javax.swing.JComboBox<String> bookCategory;
    private javax.swing.JComboBox<String> bookChoice_combo;
    private javax.swing.JButton bookDeleteBtn;
    private javax.swing.JTextArea bookDescription;
    private javax.swing.JButton bookNewBtn;
    private javax.swing.JButton bookRandomRefBtn;
    private javax.swing.JButton bookRazBtn;
    private javax.swing.JTextField bookRef;
    private javax.swing.JTextField bookState;
    private javax.swing.JTextField bookStock;
    private javax.swing.JTextField bookTitle;
    private javax.swing.JButton bookUpdateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> loanChoice_combo;
    private javax.swing.JTextField loanDateRenduPrevue;
    private javax.swing.JButton loanDeleteBtn;
    private javax.swing.JTextField loanIDBook;
    private javax.swing.JTextField loanIDUtil;
    private javax.swing.JButton loanNewBtn;
    private javax.swing.JButton loanRazBtn;
    private javax.swing.JButton loanUpdateBtn;
    private javax.swing.JButton logoutButton;
    private javax.swing.JComboBox<String> userChoice_combo;
    private javax.swing.JButton userDeleteBtn;
    private javax.swing.JTextField userEmail;
    private javax.swing.JComboBox<String> userGroup;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField userSurname;
    private javax.swing.JButton userUpdateBtn;
    // End of variables declaration//GEN-END:variables
}