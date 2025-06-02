import java.awt.*;
import javax.swing.*;

public class LojaDocesBorderFrame extends JPanel {
    private JTextField quantidadeChocolate, quantidadeCookie, quantidadePudim;
    private JLabel totalLabel;

    public LojaDocesBorderFrame() {
        setLayout(new BorderLayout(10, 10));

        // Título no topo
        JLabel titulo = new JLabel("Loja de Doces", JLabel.CENTER);
        add(titulo, BorderLayout.NORTH);

        // Painel de produtos (Centro)
        JPanel painelDoces = new JPanel(new GridLayout(3, 2, 5, 5));

        painelDoces.add(new JLabel("Brigadeiro - R$10,00"));
        quantidadeChocolate = new JTextField("0", 2);
        painelDoces.add(quantidadeChocolate);

        painelDoces.add(new JLabel("Cookie - R$15,00"));
        quantidadeCookie = new JTextField("0", 2);
        painelDoces.add(quantidadeCookie);

        painelDoces.add(new JLabel("Pudim - R$25,00"));
        quantidadePudim = new JTextField("0", 2);
        painelDoces.add(quantidadePudim);

        add(painelDoces, BorderLayout.CENTER);

        JPanel painelImagens = new JPanel();
        painelImagens.setLayout(new BoxLayout(painelImagens, BoxLayout.Y_AXIS));

        painelImagens.add(new JLabel(new ImageIcon("brizadeiro.jpg")));
        painelImagens.add(new JLabel(new ImageIcon("cukie.jpg")));
        painelImagens.add(new JLabel(new ImageIcon("midup.jpg")));

        add(painelImagens, BorderLayout.WEST);


        // Detalhes do pedido (EAST)
        JPanel painelPedido = new JPanel();
        totalLabel = new JLabel("Total: R$0,00");
        painelPedido.add(totalLabel);
        add(painelPedido, BorderLayout.EAST);

        // Botão para finalizar compra (Sul)
        JButton finalizarCompra = new JButton("Finalizar Pedido");
        finalizarCompra.addActionListener(e -> calcularTotal());
        add(finalizarCompra, BorderLayout.SOUTH);
    }

    private void calcularTotal() {
        int qtdChocolate = Integer.parseInt(quantidadeChocolate.getText());
        int qtdCookie = Integer.parseInt(quantidadeCookie.getText());
        int qtdPudim = Integer.parseInt(quantidadePudim.getText());

        double total = (qtdChocolate * 10.0) + (qtdCookie * 15.0) + (qtdPudim * 25.0);
        totalLabel.setText("Total: R$" + String.format("%.2f", total));
    }
}