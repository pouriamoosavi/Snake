package org.bihe.gui;

import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends javax.swing.JFrame
{
	private static final long serialVersionUID = 1L;
	//---------------------------------------------------------
	public MyFrame() 
	{
		setTitle("Appropriate Title!");
        setSize(600, 260);
        getContentPane().setBackground(new Color(30, 30, 30));
        setLocationRelativeTo(null);
        add(new LineComponent());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
