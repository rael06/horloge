package com.company;

import javax.swing.*;

public class Fenetre extends JFrame
 {
  MonPanel horloge;

  public Fenetre ()
   {
    horloge = new MonPanel ();
    getContentPane ().add (horloge);
    setBounds (50,50,500,500);
    setVisible (true);
   }

  public void demarrer()
   {
    horloge.init();
   }

  public static void main ( String args [] )
   {
    (new Fenetre()).demarrer ();
   }
 }
