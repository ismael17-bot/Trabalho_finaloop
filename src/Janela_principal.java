import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela_principal extends JFrame {

    private JList<String> myList;

    private Painel_mensagens mensagens = Painel_mensagens.getInstance();

    private JTextField Assunto;
    private JTextField Emisor;
    private JButton Escrever_nova;
    private JTextArea Mensagem;
    private JPanel Mostra_mensagem;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTree jTree1_Mensagens;
    private java.awt.List list1;

    private static Janela_principal _this;

    public static Janela_principal getInstance(){
        if(_this == null)
            _this= new Janela_principal();
        return _this;
    }

    private Janela_principal(){


//        String[] data = {"Inbox", "Sent"};
//        myList = new JList<String>(data);
//        add(myList);

        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTree1_Mensagens = new JTree();
        Escrever_nova = new JButton();
        Mostra_mensagem = new JPanel();
        Emisor = new JTextField();
        Assunto = new JTextField();
        jScrollPane2 = new JScrollPane();
        Mensagem = new JTextArea();
        jPanel2 = new JPanel();
        list1 = new List();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 255, 255));

        jTree1_Mensagens.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTree1_Mensagens.setForeground(new Color(255, 255, 255));


        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Caixa de entrada");
        DefaultMutableTreeNode inbox = new DefaultMutableTreeNode("Inbox");
        DefaultMutableTreeNode send = new DefaultMutableTreeNode("Sent");
        root.add(inbox);
        root.add(send);

        JTree tree = new JTree(root);
        add(tree);

//        jTree1_Mensagens.setModel(new DefaultTreeModel(root));
        tree.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tree);
        tree.getAccessibleContext().setAccessibleName("");



        Escrever_nova.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        Escrever_nova.setText("+ Escrever ");
        Escrever_nova.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Escrever_novaActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Escrever_nova, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Escrever_nova, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );

        Mostra_mensagem.setBackground(new Color(255, 255, 255));


        Emisor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EmisorActionPerformed(evt);
            }
        });
        Assunto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AssuntoActionPerformed(evt);
            }
        });

        Mensagem.setColumns(20);
        Mensagem.setRows(5);
        jScrollPane2.setViewportView(Mensagem);

        GroupLayout Mostra_mensagemLayout = new GroupLayout(Mostra_mensagem);
        Mostra_mensagem.setLayout(Mostra_mensagemLayout);
        Mostra_mensagemLayout.setHorizontalGroup(
                Mostra_mensagemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Mostra_mensagemLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(Mostra_mensagemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(Mostra_mensagemLayout.createSequentialGroup()
                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 20, Short.MAX_VALUE))
                                        .addComponent(Emisor)
                                        .addComponent(Assunto))
                                .addContainerGap())
        );
        Mostra_mensagemLayout.setVerticalGroup(
                Mostra_mensagemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Mostra_mensagemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Emisor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Assunto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(255, 255, 255));

        list1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });


        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mensagens, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mensagens, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Mostra_mensagem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Mostra_mensagem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                System.out.println("Selecao foi: " + e.getPath());

                if(e.getPath().toString().contains("Inbox")) {

                    mensagens.updateLista(new String[]{"mensagem 1", "mensagem 2", "mensagem 3"});

                    System.out.println(Talker.getInstance().getMensagens(Usuario.getInstance().getUser_id()));

                }
                else {
                    
                    mensagens.updateLista(new String[]{"ccacaacaacaa", "nbnbnbnbnbnbnb", "nnonononono 3"});
                }
            }
        });
        pack();
    }


    private void EmisorActionPerformed(ActionEvent evt) {

    }

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {
        // aqui fazer alguma funçao pra atualizar

    }
    private void Escrever_novaActionPerformed(java.awt.event.ActionEvent evt) {
        (new Janela_mensagem()).setVisible(true);
    }


    private void AssuntoActionPerformed(java.awt.event.ActionEvent evt) {

    }

}
