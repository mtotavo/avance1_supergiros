import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class registroP extends JFrame {


    private JTable table1;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JButton consultarButton;
    private JButton limpiarButton;
    private JTextField txtid2;
    private JTextField txtproducto;
    private JTextField txtcantidad;
    private JTextField txtprecio;
    private JTextField txtfecha;
    private JPanel panelpedido;

    public registroP() {

        super("registro pedidos");
        setContentPane(panelpedido);

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });

        setContentPane(panelpedido);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID", new String[]{"id"});
        modelo.addColumn("Producto", new String[]{"producto"});
        modelo.addColumn("Cantidad", new String[]{"cantidad"});
        modelo.addColumn("Precio", new String[]{"precio"});
        modelo.addColumn("fecha", new String[]{"fecha"});
        String[] p1= new String[5];

        Connection con = null;
        String user = "postgres";
        String pass = "9876";
        try{

            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/aplicacion",user,pass);
            String sql = "SELECT * FROM \"PEDIDOS\"";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                p1[0]= rs.getString("id");
                p1[1]= rs.getString("producto");
                p1[2]= rs.getString("cantidad");
                p1[3]= rs.getString("precio");
                p1[4]= rs.getString("fecha");
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
                setContentPane(panelpedido);
                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("ID", new String[]{"id"});
                modelo.addColumn("Producto", new String[]{"producto"});
                modelo.addColumn("Cantidad", new String[]{"cantidad"});
                modelo.addColumn("Precio", new String[]{"precio"});
                modelo.addColumn("fecha", new String[]{"fecha"});
                String[] p1= new String[5];

                Connection con = null;
                String user = "postgres";
                String pass = "9876";
                try{

                    con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/aplicacion",user,pass);
                    String sql = "SELECT * FROM \"PEDIDOS\"";
                    Statement st = con.createStatement();
                    ResultSet rs= st.executeQuery(sql);
                    while(rs.next()){
                        p1[0]= rs.getString("id");
                        p1[1]= rs.getString("producto");
                        p1[2]= rs.getString("cantidad");
                        p1[3]= rs.getString("precio");
                        p1[4]= rs.getString("fecha");
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
                String id = txtid2.getText();
                String pr = txtproducto.getText();
                String c = txtcantidad.getText();
                String pc = txtprecio.getText();
                String f = txtfecha.getText();

                //inicia la conexion
                String user = "postgres";
                String pass = "9876";
                Connection connection = null;

                try{
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aplicacion",user,pass);
                    JOptionPane.showMessageDialog(null,"registro exitosamente");
                    String sql = "INSERT INTO \"PEDIDOS\" VALUES ("+id+",'"+pr+"',"+c+","+pc+",'"+f+"')";
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
                    String sql = "DELETE FROM \"PEDIDOS\" WHERE id='"+id+"'";
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(sql);


                }catch (Exception ex){

                }
            }
        });
    }


    //**************************************************
    public void limpiar(){
        txtid2.setText(null);
        txtproducto.setText(null);
        txtcantidad.setText(null);
        txtprecio.setText(null);
        txtfecha.setText(null);

    }

}
