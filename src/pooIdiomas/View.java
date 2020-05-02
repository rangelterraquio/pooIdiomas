package pooIdiomas;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import pooIdiomas.Entites.Language;

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
	
	static void exibirMsg(String titulo, String msg){
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
	
	

	static Object  showComboOptionsView(ArrayList<Language> options, String title){
		
		JFrame frame = new JFrame(title);
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(0, 2, 2, 2));
		
		//JComboBox<Language> languages = new JComboBox<Language>(options);
		
		
		JRadioButton radioButton = new JRadioButton("Teste");
		JRadioButton radioButton2 = new JRadioButton("Rangel");
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton2);
		
		panel.add(new JLabel("Select one: " + title));
		panel.add(radioButton);
		panel.add(radioButton2);
		
		
		Integer option = JOptionPane.showConfirmDialog(frame,panel, "Preencha os campos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (option == JOptionPane.OK_OPTION) {
			System.out.println(group.getSelection().toString());
		}
		return null;
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

/In initialization code:
    //Create the radio buttons.
    JRadioButton birdButton = new JRadioButton(birdString);
    birdButton.setMnemonic(KeyEvent.VK_B);
    birdButton.setActionCommand(birdString);
    birdButton.setSelected(true);

    JRadioButton catButton = new JRadioButton(catString);
    catButton.setMnemonic(KeyEvent.VK_C);
    catButton.setActionCommand(catString);

    JRadioButton dogButton = new JRadioButton(dogString);
    dogButton.setMnemonic(KeyEvent.VK_D);
    dogButton.setActionCommand(dogString);

    JRadioButton rabbitButton = new JRadioButton(rabbitString);
    rabbitButton.setMnemonic(KeyEvent.VK_R);
    rabbitButton.setActionCommand(rabbitString);

    JRadioButton pigButton = new JRadioButton(pigString);
    pigButton.setMnemonic(KeyEvent.VK_P);
    pigButton.setActionCommand(pigString);

    //Group the radio buttons.
    ButtonGroup group = new ButtonGroup();
    group.add(birdButton);
    group.add(catButton);
    group.add(dogButton);
    group.add(rabbitButton);
    group.add(pigButton);

    //Register a listener for the radio buttons.
    birdButton.addActionListener(this);
    catButton.addActionListener(this);
    dogButton.addActionListener(this);
    rabbitButton.addActionListener(this);
    pigButton.addActionListener(this);
...
public void actionPerformed(ActionEvent e) {
    picture.setIcon(new ImageIcon("images/" 
                                  + e.getActionCommand() 
                                  + ".gif"));
}


*/