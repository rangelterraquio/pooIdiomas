package pooIdiomas;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View {

	
	
	static void  showLoginView(){
		
		JFrame frame = new JFrame("Veículo");
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(0, 2, 2, 2));
		
		JTextField emailTextField = new JTextField(15);
		JTextField passwordTextField = new JTextField(15);
		
		panel.add(new JLabel("Email: "));
		panel.add(emailTextField);
		
		panel.add(new JLabel("Password: "));
		panel.add(passwordTextField);
		
		JOptionPane.showConfirmDialog(frame,panel, "Preencha os campos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

	}
	
	
	static String showInputText(String titulo, String msg) {
		
		String input = JOptionPane.showInputDialog(null,msg,titulo,JOptionPane.INFORMATION_MESSAGE);
		return input;
	}
	
	static  Integer exibirInputNumero(String titulo, String msg ){
        String input = JOptionPane.showInputDialog(null,msg,titulo,JOptionPane.INFORMATION_MESSAGE);
        return Integer.parseInt(input);
    }
	
	static void showErrorMsg(String titulo, String msg){
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }
}
/*

veiculoViewFrame = new JFrame("Veículo");

        marcas = new JComboBox<Marca>(marcaOptions);

        veiculoPanel = new JPanel();
        veiculoPanel.setLayout(new GridLayout(0, 2, 2, 2));


        veiculoModeloTextField = new JTextField(5);
        veiculoKMTextField = new JTextField(5);
        veiculoValorTextField = new JTextField(5);

        veiculoPanel.add(new JLabel("Qual é a marca do carro?"));
        veiculoPanel.add(marcas);
        marcas.getSelectedItem();

        veiculoPanel.add(new JLabel("Qual é o modelo do carro?"));
        veiculoPanel.add(veiculoModeloTextField);

        veiculoPanel.add(new JLabel("Qual é a quilometragem do carro?"));
        veiculoPanel.add(veiculoKMTextField);

        veiculoPanel.add(new JLabel("Qual é valor atual do carro?"));
        veiculoPanel.add(veiculoValorTextField);
    }




*/