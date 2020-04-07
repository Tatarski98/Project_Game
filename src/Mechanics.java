import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;


import javax.swing.JPanel;


public class Mechanics  extends JPanel implements KeyListener,ActionListener {
	private int  score=0;
	private int player_posX = 300;
	private int player_posY = 660;
	private int	ballstart_posX = 350;
	private int	ballstart_posY = 500;
	private int	ballmove_posX = -1;
	private int	ballmove_posY = -1;
	private Timer time;
	ArrayList<Rectangle> list = new ArrayList();


	public void paint(Graphics g)
	{	 	

	
		g.setColor(Color.darkGray);
		g.fillRect(0,0, 700,700);
	
		g.setColor(Color.yellow);
		g.fillOval(ballstart_posX,ballstart_posY, 15, 15);
		
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD,25));
		g.drawString(""+score,570,30);
		
		g.setColor(Color.red);
		g.fillRect(player_posX,player_posY,100,10);

		
		int w1=random_number();
		int w2=random_number();
	
		Rectangle check = new Rectangle(w1,w2,80,50);
		if(verification(check)==true)
		{ 	
		list.add(check);
		}
		for(int i=0;i<list.size();i++)
		{
			g.setColor(Color.cyan);
			g.fillRect(list.get(i).x,list.get(i).y, 80, 50);
		}
		g.dispose();
		}
		
	
	Mechanics()
	{

	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
	time = new Timer(7, this);
	time.start();

	}

	public boolean verification(Rectangle check)
	{
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).intersects(check))
			{
				return false;
			}
		}
		
		return true;
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(player_posX>=600)
			{
				player_posX = 600;
			}
			else
			{
				moveright();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(player_posX<=0)
			{
				player_posX =0;
			}
			else
			{
				moveleft();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_F2)
		{
			
		}
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	time.start();
	if(new Rectangle(ballstart_posX,ballstart_posY,20,20).intersects(new Rectangle(player_posX,player_posY,100,8)))
	{
		ballmove_posY=-ballmove_posY;
		
	}
	for(int i=0;i<list.size();i++)
	{
		if(new Rectangle(ballstart_posX,ballstart_posY,20,20).intersects(new Rectangle(list.get(i).x,list.get(i).y,80,50)))
		{
			ballmove_posY=-ballmove_posY;
			list.remove(i);
			score = score +1;
		}
	}
		ballstart_posX += ballmove_posX;
		ballstart_posY += ballmove_posY;
		if(ballstart_posX < 0)
		{
			ballmove_posX=-ballmove_posX;
		}
		
		if(ballstart_posX > 670)
			
		{
			ballmove_posX = -ballmove_posX;
		}
		if(ballstart_posY < 0 )
		{
			ballmove_posY  =-ballmove_posY;
		}
		
		if(ballstart_posY > 700)
		{
			System.exit(0);
		}
		
		repaint();


	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	public void moveright()
	{
	
		player_posX+=10;
	}
	public void moveleft()
	{
	
		player_posX-=10;
	}
	public int random_number()
	{

		Random number = new Random();
		int low = 80;
		int high = 350;
		int s=number.nextInt(high-low) + low;

		return s;
	}
}






