import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela_principal extends JFrame {


    private JList<String> myList;

    private Painel_mensagens mensagens = Painel_mensagens.getInstance();

    private JTextField Assunto;
    private JTextField Destinatario_jfmensagem;
    private JButton Escrever_nova;
    private JTextArea Mensagem;
    private JPanel Mostra_mensagem;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTree jTree1_Mensagens;
    private java.awt.List list1;
    private JLabel jLabel1;
    private JLabel jLabel2;


    private Mensagem[] recebi=null;

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
        Destinatario_jfmensagem = new JTextField();
        Assunto = new JTextField();
        jScrollPane2 = new JScrollPane();
        Mensagem = new JTextArea();
        jPanel2 = new JPanel();
        list1 = new List();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();



        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(0, 153, 255));

        jTree1_Mensagens.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTree1_Mensagens.setForeground(new Color(0, 153, 255));


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

        Mostra_mensagem.setBackground(new Color(0, 153, 255));


        Destinatario_jfmensagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Destinatario_jfmensagemActionPerformed(evt);
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

        jLabel1.setText("Para:");

        jLabel2.setText("Assunto:");

        javax.swing.GroupLayout Mostra_mensagemLayout = new javax.swing.GroupLayout(Mostra_mensagem);
        Mostra_mensagem.setLayout(Mostra_mensagemLayout);
        Mostra_mensagemLayout.setHorizontalGroup(
                Mostra_mensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Mostra_mensagemLayout.createSequentialGroup()
                                .addGroup(Mostra_mensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Mostra_mensagemLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(Mostra_mensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(Mostra_mensagemLayout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(Destinatario_jfmensagem))
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(Mostra_mensagemLayout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Assunto, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26))
        );
        Mostra_mensagemLayout.setVerticalGroup(
                Mostra_mensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Mostra_mensagemLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(Mostra_mensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(Destinatario_jfmensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Mostra_mensagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Assunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(0, 153, 255));

        list1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mensagens, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(mensagens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Mostra_mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Mostra_mensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                System.out.println("Selecao foi: " + e.getPath());

                if(e.getPath().toString().contains("Inbox")) {

                    recebi = Talker.getInstance().getMensagens(Usuario.getInstance().getUser_id());
                    String mostraMensagem []=null;
                    mostraMensagem = new String [recebi.length];

                    for (int i = 0; i < recebi.length; i++) {
                        mostraMensagem[i]=("R: "+recebi[i].remetente.toString());
                    }
                    mensagens.updateLista(mostraMensagem);
                }
                 if(e.getPath().toString().contains("Sent")) {
                    Mensagem[] enviado = Talker.getInstance().getEnviados();

                    if(enviado == null){
                        System.out.println("nenhum email enviado");
                    }else{
                        System.out.println("enviados: "+Talker.getInstance().getEnviados());
                        String[] mostraMensagem = new String[enviado.length];
                        for (int i = 0; i < enviado.length; i++) {
                            mostraMensagem[i]= new String("R: "+enviado[i].destinatario.toString());
                        }
                        mensagens.updateLista(mostraMensagem);
                    }
                }
            }
        });

        pack();
    }

    public void mostraEmail(int index) {
        System.out.println(Painel_mensagens.getInstance().myList.getSelectedValue());
        Destinatario_jfmensagem.setText(recebi[index].remetente.toString());
        Assunto.setText(recebi[index].assunto.toString());
        Mensagem.setText(recebi[index].texto.toString());
    }

    private void Destinatario_jfmensagemActionPerformed(ActionEvent evt) {

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
