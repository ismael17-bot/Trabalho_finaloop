import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class janela1 extends JFrame {
    public janela1() {
        super("Pastas");
        setLayout( new BorderLayout());
        //
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Pasta Mensagens");
        DefaultMutableTreeNode inbox = new DefaultMutableTreeNode("inbox");
        DefaultMutableTreeNode sent = new DefaultMutableTreeNode("sent");


        root.add(inbox);
        root.add(sent);

        JTree tree= new JTree(root);
        add(tree);

        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                System.out.println("Seleçao foi :"+e.getPath().toString());
            }
        });
    }
}
