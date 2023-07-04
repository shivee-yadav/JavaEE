package server;
import java.io.*;
import java.net.*;

import model.ClientData;
public class AppServer implements Runnable{

  Thread t1;
  ServerSocket ss;
  Socket s;
  public AppServer()
  {
  try
  {
    ss = new ServerSocket(8888);
    System.out.println("Server Started......");
    t1 = new Thread(this);
    t1.start();
        
  }
  catch(Exception ex)
  {
    
  }
  }
  
  public void run()
  {
    for(;;)
    {
      try {
        s=ss.accept();
        Connect cClient = new Connect(s);
      }
      catch(Exception ex)
      {
        
      }
    }
  }
  class Connect
  {
    Connect(Socket s)
    {
      try
      {
        ObjectInputStream oin =new ObjectInputStream(
            s.getInputStream());
        ClientData c =(ClientData)oin.readObject();
        System.out.println("Email :"+c.email);
        System.out.println("Name :"+c.name);
        System.out.println("Mobile :"+c.mobile);
        
      }
      catch(Exception ex)
      {
        
      }
    }
  }
  public static void main(String args[])
  {
    new AppServer();
  }
}
