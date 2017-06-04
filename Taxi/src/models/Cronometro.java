package models;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
   public class Cronometro  {
		
	    private static Timer timer = new Timer(); 
	    private static int segundos=0;
	    private static JLabel lblTiempo;
	    
	    //Clase interna que funciona como contador
	   static class Contador extends TimerTask {
	        public void run() {
	            segundos++;
	            
	            lblTiempo.setText(String.format("%d segundos", segundos));
	        }
	    }

	
	    //Crea un timer, inicia segundos a 0 y comienza a contar
	    public void Contar(JLabel lblTiempo)
	    {
	        segundos=0;
	        timer = new Timer();
	        timer.schedule(new Contador(), 0, 1000);
	        this.lblTiempo = lblTiempo;
	    }
	    //Detiene el contador
	    public void Detener() {
	        timer.cancel();
	    }
	    //Metodo que retorna los segundos transcurridos
	    public double getMin()
	    {
	        return segundos/60;
	    }
	    
	    public int getSegundos()
	    {
	        return segundos;
	    }
	}