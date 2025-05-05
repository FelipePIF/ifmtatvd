import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class login extends JFrame {
    private JTextField textField1;
    private JPasswordField passwordField;
    private JLabel label1;
    private JLabel label2;
    private JButton ok;
    
    public login(){
        super("Testing JTextField and JPasswordField");
        setLayout(new FlowLayout());
        
        Icon ifmt = new ImageIcon(getClass().getResource( "ifmt.png" ));
        

        label1 = new JLabel();
        label1.setIcon(ifmt);
        label1.setHorizontalTextPosition(SwingConstants.RIGHT); 
        label1.setVerticalTextPosition(SwingConstants.CENTER); 
        label1.setText("Username:");
        add (label1);
        textField1 = new JTextField( 10 );
        add (textField1);

        label2 = new JLabel();
        label2.setText("Password:");
        add(label2);
        passwordField = new JPasswordField(30);
        add (passwordField);
        ok = new JButton("OK");
        add(ok);
        
        TextFieldHandler handler = new TextFieldHandler();
        ok.addActionListener(handler);
    }
    
    private class TextFieldHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String username = textField1.getText();
            char[] password = passwordField.getPassword();
            String rpassword = new String(password);
            String texto = ("Ola "+username+", sua senha eh "+rpassword);
            JOptionPane.showMessageDialog(null, texto);

        }
    }
}
