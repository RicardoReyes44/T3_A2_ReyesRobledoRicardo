import java.awt.FlowLayout;
import javax.swing.JFrame;


public class Ventana extends JFrame{

	public Ventana(){
		getContentPane().setLayout(new FlowLayout());
		setTitle("Tarea de concurrencia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
}
