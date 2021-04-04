import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Vector;

public class Painel_mensagens extends JPanel {
    private JList<Mensagem> listMensagens = new JList<>();

    private JList<String> myList;

    private static Painel_mensagens _this;

    public static Painel_mensagens getInstance(){
        if(_this==null) _this = new Painel_mensagens();
        return _this;
    }

    private Painel_mensagens(){

        String[] data = {"Inbox", "Sent"};
        myList = new JList<String>(data);
        add(myList);
        JScrollPane scrollMensagens = new JScrollPane();

        scrollMensagens.setViewportView(myList);

        GroupLayout panelLayout = new GroupLayout(this);
        this.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollMensagens, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollMensagens)
                                .addContainerGap())
        );

        myList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Selecao no List foi: " + myList.getSelectedValue());
            }
        });
    }

//    public void addListener(ListSelectionListener listSelectionListener){
//        listMensagens.addListSelectionListener(listSelectionListener);
//    }

    public void updateLista(String[] strings) {
        myList.removeAll();
        myList.setListData(strings);
    }
//    public void updateLista(Vector<Mensagem> strings) {
//        listMensagens.removeAll();
//        System.out.println(strings);
//        listMensagens.setListData(strings);
//        /*assunto.setVisible(true);
//        remetente.setVisible(true);
//        mensagem_corpo.setVisible(true);*/
//    }

}
