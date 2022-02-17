import javax.swing.*;

public class principal {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame log = new login();
                log.setSize(450,474);
                log.setVisible(true);
                log.setLocationRelativeTo(null);
            }
        });


    }
}

