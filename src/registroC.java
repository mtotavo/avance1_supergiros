import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class registroC extends JFrame {


    private JTable table1;
    private JTextField txtnombre;
    private JTextField txtid;
    private JTextField txtapellido;
    private JTextField txtcorreo;
    private JTextField txtpass;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JButton consultarButton;
    private JButton limpiarButton;
    private JPanel panelcliente;

    public registroC() {
        super("registro clientes");
        setContentPane(panelcliente);

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });

        setContentPane(panelcliente);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID", new String[]{"id"});
        modelo.addColumn("Nombre", new String[]{"nombre"});
        modelo.addColumn("Apellido", new String[]{"apellido"});
        modelo.addColumn("Correo", new String[]{"correo"});
        String[] p1= new String[4];

        Connection con = null;
        String user = "postgres";
        String pass = "9876";
        try{

            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/aplicacion",user,pass);
            String sql = "SELECT * FROM \"CLIENTES\"";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                p1[0]= rs.getString("id");
                p1[1]= rs.getString("nombre");
                p1[2]= rs.getString("apellido");
                p1[3]= rs.getString("correo");
                modelo.addRow(p1);
            }
            rs.close();
            st.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        table1.setModel(modelo);


        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panelcliente);
                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("ID", new String[]{"id"});
                modelo.addColumn("Nombre", new String[]{"nombre"});
                modelo.addColumn("Apellido", new String[]{"apellido"});
                modelo.addColumn("Correo", new String[]{"correo"});
                String[] p1= new String[4];

                Connection con = null;
                String user = "postgres";
                String pass = "9876";
                try{

                    con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/aplicacion",user,pass);
                    String sql = "SELECT * FROM \"CLIENTES\"";
                    Statement st = con.createStatement();
                    ResultSet rs= st.executeQuery(sql);
                    while(rs.next()){
                        p1[0]= rs.getString("id");
                        p1[1]= rs.getString("nombre");
                        p1[2]= rs.getString("apellido");
                        p1[3]= rs.getString("correo");
                        modelo.addRow(p1);
                    }
                    rs.close();
                    st.close();

                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                table1.setModel(modelo);
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtid.getText();
                String n = txtnombre.getText();
                String a = txtapellido.getText();
                String c = txtcorreo.getText();
                String p = txtpass.getText();

                //inicia la conexion
                String user = "postgres";
                String pass = "9876";
                Connection connection = null;

                try{
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aplicacion",user,pass);
                    JOptionPane.showMessageDialog(null,"registro exitosamente");
                    String sql = "INSERT INTO \"CLIENTES\" VALUES ("+id+",'"+n+"','"+a+"','"+c+"',"+p+")";
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(sql);


                }catch (Exception ex){

                }

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = JOptionPane.showInputDialog(null,"Introduzca id", "eliminar", JOptionPane.QUESTION_MESSAGE);


                //inicia la conexion
                String user = "postgres";
                String pass = "9876";
                Connection connection = null;

                try{
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aplicacion",user,pass);
                    JOptionPane.showMessageDialog(null,"eliminacion exitosa");
                    String sql = "DELETE FROM \"CLIENTES\" WHERE id='"+id+"'";
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(sql);


                }catch (Exception ex){

                }
            }
        });
    }



    //**************************************************
    public void limpiar(){
        txtid.setText(null);
        txtnombre.setText(null);
        txtapellido.setText(null);
        txtcorreo.setText(null);
        txtpass.setText(null);

    }
}
