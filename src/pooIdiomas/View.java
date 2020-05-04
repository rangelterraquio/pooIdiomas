package pooIdiomas;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
		return input == null ? "" : input;
	}
	
	static String showInputPassword(String msg) {
		JPasswordField passwordTextField = new JPasswordField(15);
		JOptionPane.showConfirmDialog(null, passwordTextField, msg, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		String password = new String(passwordTextField.getPassword());
		return password == null ? "" : password;
		
	}
	
	static  Integer exibirInputNumero(String titulo, String msg ){
        String input = JOptionPane.showInputDialog(null,msg,titulo,JOptionPane.INFORMATION_MESSAGE);
        return Integer.parseInt(input);
    }
	
	static void showErrorMsg(String titulo, String msg){
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }
	
	static void exibirMsg(String titulo, String msg){
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
	
	
	

}
