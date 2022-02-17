import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame {


    private JButton clientesButton;
    private JButton pedidosButton;
    private JButton productosButton;
    private JButton salirButton;
    private JPanel dashpanel;
    private JButton correoButton;

    public dashboard() {

        super("dashboard");
        setContentPane(dashpanel);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirC();
            }
        });
        pedidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirP();
            }
        });
        productosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirS();
            }
        });
        correoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirEmail();
            }
        });
    }


    //*********************************************************+++

    public void salir(){
        dispose();
        System.exit(0);

    }

    public void abrirC(){
        JFrame c = new registroC();
        c.setVisible(true);
        c.setSize(800,400);
        c.setLocationRelativeTo(null);


    }

    public void abrirP(){
        JFrame p = new registroP();
        p.setVisible(true);
        p.setSize(800,400);
        p.setLocationRelativeTo(null);


    }

    public void abrirS(){
        JFrame s = new registroS();
        s.setVisible(true);
        s.setSize(800,400);
        s.setLocationRelativeTo(null);


    }

    public void abrirEmail(){
        JFrame e = new Email();
        e.setVisible(true);
        e.setSize(450,350);
        e.setLocationRelativeTo(null);

    }
}
