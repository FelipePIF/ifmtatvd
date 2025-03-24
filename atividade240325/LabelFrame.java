import java.awt.FlowLayout; 
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.SwingConstants; 
import javax.swing.Icon; 
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame 
{ 
    private JLabel label; 


    public LabelFrame() 
    { 
        super( "Testando  JLabel"); 
        setLayout(new FlowLayout());

        Icon bug = new ImageIcon(getClass().getResource( "images.png" ));
        label = new JLabel();
        label.setText("INSTITUTO FEDERAL DE EDUCACAO, CIENCIA E TECNOLOGIA DE MATO GROSSO"); 
        label.setIcon(bug);
        label.setHorizontalTextPosition(SwingConstants.CENTER); 
        label.setVerticalTextPosition(SwingConstants.BOTTOM); 
        label.setToolTipText("Essa eh a logo do IFMT"); 
        add(label);
    }
}