import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class Ventana extends JFrame implements ActionListener{

	public Ventana(){
		getContentPane().setLayout(new FlowLayout());
		setTitle("Tarea de concurrencia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JTextArea area1 = new JTextArea();
		JTextArea area2 = new JTextArea();
		
		JLabel lbl = new JLabel("asdasd");
		
		add(area1);
		add(area2);
		add(lbl);
		
		
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
