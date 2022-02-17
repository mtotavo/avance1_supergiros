import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class login extends JFrame{

    private JTextField usuariotxt;
    private JButton ingresarButton;
    private JPasswordField passwordtxt;
    private JPanel loginpanel;
    private JButton salirButton;

    public login(){
        super("login");
        setContentPane(loginpanel);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresar();
            }
        });
    }


//***************************************************************

    public void ingresar(){
        String u = usuariotxt.getText();
        String p = String.valueOf(passwordtxt.getPassword());


        //inicia la conexion
        String user = "postgres";
        String pass = "9876";
        Connection connection = null;
        int resultado = 0;

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aplicacion",user,pass);
            String sql = "SELECT *FROM \"CLIENTES\" WHERE nombre = '"+u+"' AND contrasena = "+p+"";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                resultado = 1;
                if(resultado==1){
                    abrir();
                }

            }else{

                JOptionPane.showMessageDialog(null,"usuario o contraseña incorrectos");
            }

        }catch (Exception e){
            System.out.println("fallo conexion "+e.getMessage());

        }


    }

    //***************************************************************
    public void salir(){
        dispose();
        System.exit(0);

    }

    public void abrir(){
        JFrame dash = new dashboard();
        dash.setVisible(true);
        dash.setSize(600,500);
        dash.setLocationRelativeTo(null);
        dispose();

    }
}
