package client;
import javax.swing.*;

import model.ClientData;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class Clientform extends JFrame implements ActionListener{

  JLabel L1,L2,L3;
  JTextField t1,t2,t3;
  JButton b1,b2;
  JPanel p1;
  public Clientform()
  {
    this.setVisible(true);
    this.setSize(300,300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    L1 = new JLabel("Email:");
    L2 = new JLabel("Name:");
    L3 = new JLabel("Mobile:");
    t1 = new JTextField(20);
    t2 = new JTextField(20);
    t3 = new JTextField(20);
    p1 = new JPanel();
    b1 = new JButton("Submit to server");
    b2 = new JButton("Close");
    p1.add(L1);p1.add(t1);
    p1.add(L2);p1.add(t2);
    p1.add(L3);p1.add(t3);
    p1.add(b1);p1.add(b2);
    this.add(p1);
    b1.addActionListener(this);
    b2.addActionListener(this);
    this.setSize(301,180);
    this.setTitle("Client Form");
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==b1)
    {
      ClientData c = new ClientData();
      c.email =t1.getText();
      c.name =t2.getText();
      c.mobile =t3.getText();
      
      try {
      Socket s = new Socket("localhost",8888);
      ObjectOutputStream out = new ObjectOutputStream
          (s.getOutputStream());
      out.writeObject(c);
      out.flush();
      s.close();
      
      }
      catch(Exception ex)
      {
        
      }
    }
    else
    {
      System.exit(0);
    }
  }
  public static void main(String args[])
  {
    new Clientform();
  }
}
