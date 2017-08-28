package org.bihe.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JComponent;

public class LineComponent extends JComponent 
{
	private static final long serialVersionUID = 1L;
	//---------------------------------------------------------
	private int lastPosition = 0;
	private int lastColor = 255;
	private int HEIGHT = 10;
	//---------------------------------------------------------
	class MyRunnable implements Runnable
	{
		@Override
		public void run() 
		{
			while (true) 
			{
				repaint();
				Toolkit.getDefaultToolkit().sync();
				try {
					Thread.sleep(10);
				}catch (Exception e){
					Thread.currentThread().interrupt();
				}
			}
		}	
	}
	//--------------------------------------------------------
	public LineComponent() 
	{
		Runnable r = new MyRunnable(); 
        Thread thread = new Thread(r);
        thread.start();
    }	
	//---------------------------------------------------------
	@Override
	protected void paintComponent(Graphics arg0) 
	{
        Graphics2D g = (Graphics2D)arg0;
        
        int x= lastPosition+ 5;
        int c= lastColor- 2;
        //
        if(c< 50)
        	c= 255;
        
        if (x> getWidth()+ 100) 
        {
            x= -100;
        	HEIGHT= HEIGHT+20;
        	if(HEIGHT> getHeight())
        	{
        		HEIGHT= 10;
        	}
        }
        //
        g.setColor(new Color(c, c, c));
        g.fillRect(x, HEIGHT, 100, 5);
        //
        lastPosition= x;
        lastColor= c;
    }
}
