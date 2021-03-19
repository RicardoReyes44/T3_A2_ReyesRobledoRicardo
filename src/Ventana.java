import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


class Contenedor implements Runnable{
	
	ArrayList<String> al;
	JTextArea area1;
	JTextArea area2; 

	
	public Contenedor(ArrayList<String> al, JTextArea area1, JTextArea area2){
		this.al=al;
		this.area1=area1;
		this.area2=area2;
	}
	

	@Override
	public void run() {
		
		int i=0, j=0;
		for(String a: al) {
			if(a.equals("Si")) {
				area1.insert(i+" "+a+"\n", 0);
				i++;
			}else {
				area2.insert(j+" "+a+"\n", 0);
				j++;
			}
		}
		
	}
}


public class Ventana extends JFrame implements ActionListener{
	
	ArrayList<String> al = new ArrayList<String>();
	JTextArea area1;
	JTextArea area2; 
	JScrollPane sp2;
	JScrollPane sp1;

	public Ventana(){
		getContentPane().setLayout(new FlowLayout());
		setTitle("Tarea de concurrencia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		for(int i=0; i<10000000; i++) {
			if((int)((Math.random()*2)+1)==1) {
				al.add("Si");
			}else {
				al.add("No");
			}
		}
		
		area1 = new JTextArea(10, 10);
		area1.setLineWrap(true);
    	area1.setWrapStyleWord(true);
    	
		area2 = new JTextArea(10, 10);
		area2.setLineWrap(true);
    	area2.setWrapStyleWord(true);
    	
		area1.setBackground(new Color(171,219,227));
		area1.setForeground(new Color(33,19,13));
		area2.setBackground(new Color(135,62,35));
		area2.setForeground(new Color(171,219,227));
		
		area1.setEditable(false);
		area2.setEditable(false);
		
		sp1 = new JScrollPane(area1);
		sp2 = new JScrollPane(area2);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(sp1);
		panel.setBorder(BorderFactory.createTitledBorder("Si"));
		add(panel);
		
		JLabel lbl = new JLabel("   ");
		
		add(lbl);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(sp2);
		panel2.setBorder(BorderFactory.createTitledBorder("No"));
		add(panel2);
		
		
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
