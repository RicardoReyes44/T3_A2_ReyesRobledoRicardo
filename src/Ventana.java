import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


class Contenedor implements Runnable{
	
	ArrayList<String> al;
	JTextArea area1;
	JTextArea area2; 
	JProgressBar pg;
	JProgressBar pg1;

	
	public Contenedor(JProgressBar pg, JProgressBar pg1, ArrayList<String> al, JTextArea area1, JTextArea area2){
		this.al=al;
		this.area1=area1;
		this.area2=area2;
		this.pg=pg;
		this.pg1=pg1;
	}
	

	@Override
	public void run() {
		
		int i=0, j=0;
		for(String a: al) {
			if(a.equals("Si")) {
				area1.append((i++)+" "+a+"\n");
			}else {
				area2.append((j++)+" "+a+"\n");
			}
				
		}
		
		Thread t = new Thread(new ProgressBar(pg, i, 1));
		t.start();
		
		Thread t2 = new Thread(new ProgressBar(pg1, j, 2));
		t2.start();
		
	}
}


class ProgressBar implements Runnable{
	
	JProgressBar pg;
	int cantidad;
	int opcion;
	
	public ProgressBar(JProgressBar pg, int cantidad, int opcion){
		this.pg = pg;
		this.cantidad = cantidad;
		this.opcion=opcion;
		pg.setMaximum(30000);
	}

	@Override
	public void run() {
		
		pg.setValue(cantidad);
		
		if(opcion==1)
		    pg.setString("SI: "+cantidad);
		else
			pg.setString("NO: "+cantidad);
       	
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

		//10000000
		for(int i=0; i<30000; i++) {
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
		
		JProgressBar pg = new JProgressBar(0, 2);
		pg.setValue(0);
		pg.setStringPainted(true);
		pg.setString("Cargando datos... de SI");
		
		JProgressBar pg1 = new JProgressBar(0, 2);
		pg1.setValue(0);
		pg1.setStringPainted(true);
		pg1.setString("Cargando datos... de NO");
		
		// ------------------------------------------------
		
        Contenedor c = new Contenedor(pg, pg1, al, area1, area2);
		
		Thread t = new Thread(c);
		t.start();
		
		// ------------------------------------------------
		
		add(pg);
		add(pg1);
		
		
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
