import javax.swing.*;

public class LojaDocesBorderDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Loja de Doces - BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(new LojaDocesBorderFrame());
        frame.setVisible(true);
    }
}
