import javax.swing.JOptionPane;

public class addition{
    public static void main(String[] args){
        String firstnumber = JOptionPane.showInputDialog("Coloque o primeiro inteiro: ");
        String secondnumber = JOptionPane.showInputDialog("Coloque o segundo inteiro: ");
        
        int number1 = Integer.parseInt(firstnumber);
        int number2 = Integer.parseInt(secondnumber);
        
        int soma = number1+number2;
        
        JOptionPane.showMessageDialog(null, "A soma eh "+ soma, "Soma de dois inteiros", JOptionPane.ERROR_MESSAGE);
    }
}