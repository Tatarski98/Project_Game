import javax.swing.JFrame;

public class Main 
{
	
	public static void main(String[]args)        
	{
		
	Mechanics game = new Mechanics();
	JFrame frame = new JFrame("Game");
	
	
	frame.setVisible(true);
	frame.setSize(700,700);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.add(game);

	}
	
}


