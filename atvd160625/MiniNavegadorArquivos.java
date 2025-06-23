import javax.swing.*;
import java.io.File;

public class MiniNavegadorArquivos {
    public static void main(String[] args) {
        File currentDir = new File(System.getProperty("user.dir"));

        while (true) {
            File[] arquivos = currentDir.listFiles();
            StringBuilder conteudo = new StringBuilder("Conteudo de: " + currentDir.getPath() + "\n\n");
            if (arquivos != null) {
                for (File f : arquivos) {
                    conteudo.append(f.getName());
                    conteudo.append(f.isDirectory() ? " [Diretorio]" : " [Arquivo]");
                    conteudo.append("\n");
                }
            }

            JTextArea areaTexto = new JTextArea(conteudo.toString());
            areaTexto.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(areaTexto);
            scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));

            String[] opcoes = {"Entrar em Subdiretorio", "Voltar ao Anterior", "Atualizar Lista", "Sair"};
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    scrollPane,
                    "Mini Navegador de Arquivos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            if (escolha == 0) {
                String nome = JOptionPane.showInputDialog("Digite o nome do subdiretorio:");
                if (nome != null) {
                    File novoDir = new File(currentDir, nome);
                    if (novoDir.exists() && novoDir.isDirectory()) {
                        currentDir = novoDir;
                    } else {
                        JOptionPane.showMessageDialog(null, "Diretorio invalido");
                    }
                }
            } else if (escolha == 1) {
                File pai = currentDir.getParentFile();
                if (pai != null) {
                    currentDir = pai;
                } else {
                    JOptionPane.showMessageDialog(null, "Ja esta no diretorio raiz");
                }
            } else if (escolha == 3 || escolha == JOptionPane.CLOSED_OPTION) {
                break;
            }
        }

    }
}