import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/*
	Encuentra el tesoro
	Author: Yamir Gudino


*/
public class Gudino implements ActionListener
{
   int usu, com, aux;
   JFrame ventana;
   JButton btn_boton, btn_tmp, btn_iniciar;
   JTextField tf_valor, tf_intentos;
   JLabel l_numeros, l_norte, l_sur, l_este, l_oeste, l_intentos, l_encuentra, l_pro;
   public static void main(String[] args)
   {
      new Gudino();
   }
   Gudino()
   {
      ventana = new JFrame("Proyecto");
      ventana.setBounds(50,5,850,700);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(null);
      
	  btn_iniciar = new JButton("Iniciar");
      btn_iniciar.setBounds(600,5,150,40);
	  btn_iniciar.setFont(new java.awt.Font("Tahoma", 0, 26));
      btn_iniciar.addActionListener(this);
      ventana.add(btn_iniciar);
	  
	  l_encuentra = new JLabel("Encuentra el tesoro");
      l_encuentra.setBounds(100,5,450,40);
	  l_encuentra.setFont(new java.awt.Font("Tahoma", 0, 36)); 
      ventana.add(l_encuentra);
	  
	  l_pro = new JLabel("Yamir Gudino 8-905-48 1ls221");
      l_pro.setBounds(10,580,450,40);
	  l_pro.setFont(new java.awt.Font("Tahoma", 0, 10)); 
      ventana.add(l_pro);
	  
	  
		
	  
      ventana.setVisible(true);
      
   }
   
  public void actionPerformed(ActionEvent e)
  {
	  
	  if (e.getSource() == btn_iniciar)
	  {
		
		iniciar();
	  
		  
	  }
	  else
      {
		  
		 
         btn_tmp = (JButton)e.getSource();
		 usu = Integer.parseInt(btn_tmp.getActionCommand());
		 tf_intentos.setText(String.valueOf(Integer.parseInt(tf_intentos.getText())+1));
		 
		 if (usu > com)
		 {if((usu%10) == (com % 10))
               JOptionPane.showMessageDialog(null, "Ve hacia el Norte ^");
				else if(usu%10 > com %10){
					if(usu/10 == com/10)
				JOptionPane.showMessageDialog(null, "Ve hacia el oeste <");
					else
				JOptionPane.showMessageDialog(null, "Ve hacia el noroeste ^<");	}	
				else {
					if (usu/10 == com/10)
				JOptionPane.showMessageDialog(null, "Ve hacia el este >");  
					else
				JOptionPane.showMessageDialog(null, "Ve hacia el noreste ^>");}  	}
         else
            if (usu < com)
			{if((usu%10) == (com % 10))
               JOptionPane.showMessageDialog(null, "Ve hacia el Sur v");
				else if(usu%10 > com %10){
					if(usu/10 == com/10)
				JOptionPane.showMessageDialog(null, "Ve hacia el oeste <");
					else
				JOptionPane.showMessageDialog(null, "Ve hacia el suroeste v<");}		
				else {
					if (usu/10 == com/10)
				JOptionPane.showMessageDialog(null, "Ve hacia el este >");  
					else
				JOptionPane.showMessageDialog(null, "Ve hacia el sureste v>");}  	}
            else
			{JOptionPane.showMessageDialog(null, "has Ganado");
				int ax = JOptionPane.showConfirmDialog(null, "Jugar Otra Vez?");
        if(ax == JOptionPane.YES_OPTION)
            iniciar();
        else if(ax == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "hasta pronto");
			System.exit( 0 ); }
		else	
			System.exit( 0 ); }
			
            
      }
  }
   
   
   public void crearBotones()
   {
      int i;
      for (i=0;i<100;i++)
      {
         btn_boton = new JButton();
         btn_boton.setActionCommand(String.valueOf(i));
         btn_boton.setBounds(250+50*(i%10),100+50*(i/10),50,50);
         btn_boton.addActionListener(this);
         ventana.add(btn_boton);
      }
      ventana.repaint();
   }
   
   public void numerosx()
   {
      int i;
      for (i=0;i<10;i++)
      {
         l_numeros = new JLabel();
         l_numeros.setText(String.valueOf(i+1));
         l_numeros.setBounds(271+50*(i%10),600,50,50);
         ventana.add(l_numeros);
      }
   }
   public void numerosy()
   {
      int i;
      for (i=0;i<10;i++)
      {
         l_numeros = new JLabel();
         l_numeros.setText(String.valueOf(i+1));
         l_numeros.setBounds(220,550-50*i,50,50);
         ventana.add(l_numeros);
      }
   }
	public void iniciar(){
		btn_iniciar.setVisible(false);
		Random rnd = new Random();
		crearBotones();
		numerosx();
		numerosy();
		
	  l_intentos = new JLabel("Intentos");
      l_intentos.setBounds(50,200,80,22);
	  l_intentos.setFont(new java.awt.Font("Tahoma", 0, 20));
      ventana.add(l_intentos);
	  
	  tf_intentos = new JTextField("0");
      tf_intentos.setBounds(73,240,30,20);
	  tf_intentos.setFont(new java.awt.Font("Tahoma", 0, 18));
      ventana.add(tf_intentos);
		
	  l_norte = new JLabel("Norte");
      l_norte.setBounds(480,50,50,50);
      ventana.add(l_norte);
	  
	  l_sur = new JLabel("Sur");
      l_sur.setBounds(500,625,50,50);
      ventana.add(l_sur);
	  
	  l_oeste = new JLabel("Oeste");
      l_oeste.setBounds(170,325,50,50);
      ventana.add(l_oeste);
      
	  l_este = new JLabel("Este");
      l_este.setBounds(760,325,50,50);
      ventana.add(l_este);
	  
	  
	  
	  
	  com = rnd.nextInt(100);
	  System.out.println(com);
	  
	  ventana.repaint();
	}
}






