package Sort;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class app {

	private JFrame jf;
	//Panels
	JPanel tools = new JPanel();
	
	//Labels
	JLabel algorithm = new JLabel("Algorithm");
	JLabel compare = new JLabel("Compare");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.jf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//System.out.println("I'm in main");
	}

	/**
	 * Create the application.
	 */
	public app() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//the frame
		jf = new JFrame();
		jf.setSize(800,635);
		jf.setTitle("Visual Sort");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().setLayout(null);
		
		//Algorithm Select
		algorithm.setHorizontalAlignment(JLabel.CENTER);
		algorithm.setBounds(40,20,100,25);
		tools.add(algorithm);
		/*
		jf = new JFrame();
		jf.setBounds(100, 100, 450, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(new BoxLayout(jf.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		jf.getContentPane().add(panel);
		
		JLabel lblOne = new JLabel("");
		panel.add(lblOne);
		
		JButton btnNewButton = new JButton("Click here for ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "This is the FBI: The Sequel ");
				lblOne.setText("This is now the FBI: The Trequel ");
			}
		});
		*/
		//panel.add(btnNewButton);
	}

}
