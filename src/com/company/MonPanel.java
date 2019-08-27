package com.company;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.util.Locale;


public class MonPanel extends JPanel implements Runnable 
 {
  private String toPrint = new String();
  private int h;
  private int m;
  private int s;
  private Thread thread;
	
  public void paint(Graphics g)
   {	    
    g.setColor(Color.WHITE);
    g.fillRect (0,0,500, 500);

    g.setColor(Color.BLACK);
    g.drawString("Heure : " + toPrint, 230, 30);
    g.drawOval(10, 10, 110, 110);
    g.setColor(Color.BLUE);
    g.drawLine(65, 65, (int)(65+50*Math.sin(s*Math.PI/30)), (int)(65-50*Math.cos(s*Math.PI/30)));
    g.setColor(Color.RED);
    g.drawLine(65, 65, (int)(65+40*Math.sin(m*Math.PI/30)), (int)(65-40*Math.cos(m*Math.PI/30)));
    g.setColor(Color.GREEN);
    g.drawLine(65, 65, (int)(65+20*Math.sin(h*Math.PI/6)), (int)(65-20*Math.cos(h*Math.PI/6)));
   }

  public void init()
   {
    thread = new Thread(this);
    thread.start();
   }
	   
  public void run() 
   {
    while (true) 
     { 
      Calendar c = Calendar.getInstance(Locale.FRANCE);
      h = c.get(Calendar.HOUR_OF_DAY);
      m = c.get(Calendar.MINUTE);
      s = c.get(Calendar.SECOND);
				
      toPrint = (h<10?"0":"")+h + ":" + (m<10?"0":"")+m + ":" + (s<10?"0":"")+s;
								
      try
       {
        Thread.sleep(1000);
       } 
      catch (InterruptedException e) 
       {
        e.printStackTrace();
       }
	
      repaint();
     }
   }
 }
