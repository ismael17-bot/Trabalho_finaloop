import javax.swing.*;

public class Janela_login extends JFrame {

    private JTextPane Username;
    private JButton jButton1;
    private JButton jButton_login;
    private JEditorPane jEditorPane1;
    private JLabel jLabel1_login;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField jTextField2;
    private javax.swing.JLabel jLabel_fundo_login;

    public Janela_login(){

        JTextField jTextField1 = new JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Username = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton_login = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel1_login = new javax.swing.JLabel();



        setTitle("Login");
        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });





        jScrollPane2.setViewportView(jEditorPane1);
        jScrollPane1.setViewportView(Username);
        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Janela_login"); // NOI18N

        getContentPane().setLayout(null);

        jButton_login.setBackground(new java.awt.Color(0, 153, 255));
        jButton_login.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_login.setForeground(new java.awt.Color(0, 0, 0));
        jButton_login.setText("Login");
        jButton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loginActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_login);
        jButton_login.setBounds(260, 300, 100, 30);

        jTextField2.setBackground(new java.awt.Color(0, 153, 255));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Username"); // NOI18N
        jTextField2.setToolTipText("");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(210, 250, 190, 30);

        jLabel1_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imagem1.jpg"))); // NOI18N
        jLabel1_login.setToolTipText("");
        getContentPane().add(jLabel1_login);
        jLabel1_login.setBounds(90, 0, 510, 410);


        setSize(new java.awt.Dimension(600, 450));
        setLocationRelativeTo(null);
        
    }
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton_loginActionPerformed(java.awt.event.ActionEvent evt) {

        //fazer o if validar o login
        Usuario.getInstance().setUser_id(jTextField2.getText());
        String resp = Talker.getInstance().login(jTextField2.getText());

        if(Talker.getInstance().login(jTextField2.getText()).contains("usuario ja existe")||Talker.getInstance().login(jTextField2.getText()).contains("login aceito")) {
            System.out.println("NO BOTAO: " + resp);
            Janela_principal.getInstance().setVisible(true);
            dispose();
        } else {
            System.out.println("NO BOTAO: " + resp);
            System.out.println("erro ");
            dispose();
        }
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}
