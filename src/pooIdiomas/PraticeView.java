package pooIdiomas;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import pooIdiomas.Entites.Word;

public class PraticeView extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private ArrayList<Word> words;
	private JLabel labelTime;
	private JLabel labelInstruction;
	private JLabel wordLabel;
	private JTextField aweserTextField;
	private JButton nextButton;
	private ArrayList<String> answers = new ArrayList<String>();
	private Integer indice = 0;
	private Integer amountOfWords = 0;
	private static int interval; //Defines time for each difficult
	private JButton ok = new JButton("OK");
	private Timer timer;

	public PraticeView(ArrayList<Word> words, Difficult difficult) {
		this.words = words;
		setupDifficult(difficult);
		setupView();
		setAmountOfWords();
	}
	
	
	private void setupView() {
		panel = new JPanel();
		labelTime =  new JLabel();
		aweserTextField = new JTextField(15);
		
		
		wordLabel = new JLabel();
		wordLabel.setText(words.get(indice).getContent());
		
		panel.setLayout(new GridLayout(0, 2, 2, 2));
		
		labelInstruction = new JLabel("Write the right translation: \n");
		
        int delay = 1000;
        int period = 1;
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMinimumIntegerDigits(2);
        format.setMaximumFractionDigits(2);
        timer = new Timer("MY time");
       
		
		timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (interval == 0) {
                	closeView();
                	stopTime();
                } else {
                    setInterval();
                    int minutes = (int)(interval/60000);
                    int seconds = (int)((interval-60000*minutes)/1000);
                    labelTime.setText(format.format(minutes) + ":" + format.format(seconds));
                }
            }
        }, delay, period);

		ok.setEnabled(false);
		ok.setActionCommand("okButton");
		ok.addActionListener(this);
		
		nextButton = new JButton("Next Word");
		nextButton.setActionCommand("nextButton");
		nextButton.addActionListener(this);
		
		panel.add(labelTime);
		panel.add(labelInstruction);
		panel.add(wordLabel);
		panel.add(aweserTextField);
		panel.add(new JLabel(""));
		panel.add(nextButton);
	
		
	}
	
	 private static int setInterval() { 
	     return --interval;
	}
	 
	 
	private void setupDifficult(Difficult difficult) {
		if (difficult == Difficult.EASY) {
			interval = 120000;
		}else {
			interval = 60000;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		indice++;
		if (indice == amountOfWords) {
			panel.remove(nextButton);
			panel.remove(aweserTextField);
			wordLabel.setText("You did it :D");
			panel.revalidate();
			panel.repaint();
			answers.add(aweserTextField.getText());
			aweserTextField.setText("");
			ok.setEnabled(true);
			stopTime();
			return;
		}
		if (e.getActionCommand() == "okButton") {
			stopTime();
			closeView();
	        return;
		}
		if(e.getActionCommand() == "nextButton") {
			answers.add(aweserTextField.getText());
			aweserTextField.setText("");
			wordLabel.setText(words.get(indice).getContent());	
		}
		
	}


	public JPanel getPanel() {
		return panel;
	}


	public JButton getOk() {
		return ok;
	}
	
	public ArrayList<String> getAnswers() {
		return answers;
	}
	
	private void closeView() {
		Window w = SwingUtilities.getWindowAncestor(ok);
        if(w != null) w.setVisible(false);
	}
	
	private void stopTime() {
		timer.cancel();
        timer.purge();
	}
	
	private void setAmountOfWords() {
		if (words.size() >= 10) {
			amountOfWords = 10;
		}else {
			amountOfWords = words.size(); 
		}
	}
}
