import java.awt.*;
import javax.swing.*;

public class LojaDocesGridFrame extends JPanel {
    private JTextField quantidadeBrigadeiro, quantidadeCookie, quantidadePudim;
    private JLabel totalLabel;

    public LojaDocesGridFrame() {
        setLayout(new GridBagLayout()); // Utilizando GridBagLayout para controle preciso

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os elementos
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        // Adicionando cabeçalhos
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Imagem"), gbc);

        gbc.gridx = 1;
        add(new JLabel("Produto"), gbc);

        gbc.gridx = 2;
        add(new JLabel("Quantidade"), gbc);

        // Brigadeiro
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(new JLabel(new ImageIcon("brizadeiro.jpg")), gbc);

        gbc.gridx = 1;
        add(new JLabel("Brigadeiro - R$10,00"), gbc);

        gbc.gridx = 2;
        quantidadeBrigadeiro = new JTextField("1", 2);
        add(quantidadeBrigadeiro, gbc);

        // Cookie
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(new JLabel(new ImageIcon("cukie.jpg")), gbc);

        gbc.gridx = 1;
        add(new JLabel("Cookie - R$15,00"), gbc);

        gbc.gridx = 2;
        quantidadeCookie = new JTextField("1", 2);
        add(quantidadeCookie, gbc);

        // Pudim
        gbc.gridy = 3;
        gbc.gridx = 0;
        add(new JLabel(new ImageIcon("midup.jpg")), gbc);

        gbc.gridx = 1;
        add(new JLabel("Pudim - R$25,00"), gbc);

        gbc.gridx = 2;
        quantidadePudim = new JTextField("2", 2);
        add(quantidadePudim, gbc);

        // Exibir total
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Ocupa duas colunas
        totalLabel = new JLabel("Total: R$0,00");
        add(totalLabel, gbc);

        // Botão "Pedir"
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        JButton pedirButton = new JButton("Pedir");
        pedirButton.addActionListener(e -> calcularTotal());
        add(pedirButton, gbc);
    }

    private void calcularTotal() {
        int qtdBrigadeiro = Integer.parseInt(quantidadeBrigadeiro.getText());
        int qtdCookie = Integer.parseInt(quantidadeCookie.getText());
        int qtdPudim = Integer.parseInt(quantidadePudim.getText());

        double total = (qtdBrigadeiro * 10.0) + (qtdCookie * 15.0) + (qtdPudim * 25.0);
        totalLabel.setText("Total: R$" + String.format("%.2f", total));
    }
}