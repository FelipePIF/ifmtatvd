import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*; 

public class ButtonFrame extends JFrame{
    private JButton plainJButton;
    private JButton fancyJButton;
    
    public ButtonFrame(){
        super ("Testing Buttons");
        setLayout (new FlowLayout());
        plainJButton = new JButton("Plain Button");
        add(plainJButton);
        
        Icon bug1 = new ImageIcon (getClass().getResource("bug1.gif"));
        Icon bug2 = new ImageIcon (getClass().getResource("bug2.gif"));
        fancyJButton = new JButton ("Fancy Button", bug1);
        fancyJButton.setRolloverIcon(bug2);
        add(fancyJButton);
        
        ButtonHandler handler = new ButtonHandler();
        fancyJButton.addActionListener(handler);
        plainJButton.addActionListener(handler);
    }
    
    private class ButtonHandler implements ActionListener{
        public void actionPerfomed(ActionEvent event){
            JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
                "You pressed: %s", event.getActionCommand()));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }
}
