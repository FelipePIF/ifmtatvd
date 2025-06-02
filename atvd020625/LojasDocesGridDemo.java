import javax.swing.*;

public class LojaDocesGridDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Loja de Doces - GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(new LojaDocesGridFrame());
        frame.setVisible(true);
    }
}