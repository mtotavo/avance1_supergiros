import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class Email extends JFrame {


    private JTextField destitxt;
    private JTextField asuntotxt;
    private JButton enviarButton;
    private JTextArea msjtxt;
    private JPanel emailpanel;

    public Email() {

        super("Email");
        setContentPane(emailpanel);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviar();
            }
        });
    }

    public void enviar(){

        String remitente = "mishelltatianaotavo@gmail.com";
        String clave = "31977177";
        String destino = destitxt.getText();

        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.user",remitente);
        props.put("mail.smtp.clave",clave);

        Session session = Session.getDefaultInstance(props);
        MimeMessage mensaje = new MimeMessage(session);

        try{
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            mensaje.setSubject(asuntotxt.getText());
            mensaje.setText(msjtxt.getText());
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com",remitente,clave);
            transport.sendMessage(mensaje, mensaje.getAllRecipients());
            transport.close();
            System.out.println("correo enviado");

        }catch (Exception e){
            e.printStackTrace();

        }


    }
}
