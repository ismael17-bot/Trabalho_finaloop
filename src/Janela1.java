import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela1 extends JFrame {
    private JList<String> myList;


    public Janela1() {
        super("Pastas");
        setLayout(new BorderLayout());
        String[] data = {"Inbox", "Sent"};
        myList = new JList<String>(data);
        add(myList);

        myList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Selecao no List foi: " + myList.getSelectedValue());
            }
        });

        //
        DefaultMutableTreeNode root  = new DefaultMutableTreeNode("Pastas de Email");
        DefaultMutableTreeNode inbox = new DefaultMutableTreeNode("Inbox");
        DefaultMutableTreeNode sent  = new DefaultMutableTreeNode("Sent");

        root.add(inbox);
        root.add(sent);

        JTree tree = new JTree(root);
        add(tree);

        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                System.out.println("Selecao foi: " + e.getPath());

                if(e.getPath().toString().contains("Inbox")) {
                   updateLista(new String[]{"mensagem 1", "mensagem 2", "mensagem 3"});

                }
                else {
                    updateLista(new String[]{"ccacaacaacaa", "nbnbnbnbnbnbnb", "nnonononono 3"});
                }
            }
        });

        JButton btLogin = new JButton("Login");
        add(btLogin, BorderLayout.SOUTH);

        btLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resp = Talker.getInstance().login("Valmor");
                System.out.println("NO BOTAO: " + resp);
            }
        });

        JButton btEnviar = new JButton("Enviar");
        add(btEnviar, BorderLayout.WEST);
        btEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resp = Talker.getInstance().enviarMensagem("Usuario1", "Valmor", "teste123", "enviando uma mensagem de teste");
                System.out.println("Mensagem enviada: " + resp);
            }
        });

        JButton btGet = new JButton("GET");
        add(btGet, BorderLayout.EAST);
        btGet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mensagem[] resp = Talker.getInstance().getMensagens("Usuario1");
                if(resp == null) System.out.println("Nao existem mensagens para este usuario.");
                else {
                    for (Mensagem m : resp) {
                        System.out.println(m);
                    }
                }
            }
        });

        pack();
    }

    public void updateLista(String[] strings) {
        myList.removeAll();
        myList.setListData(strings);
    }

}