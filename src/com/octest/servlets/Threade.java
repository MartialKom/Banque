package com.octest.servlets;
import java.util.Timer;
import java.util.TimerTask;
import com.octest.forms.TauxInteret;

public class Threade  implements Runnable{

int time;
public Threade() {
this.time=3000;
}


	@Override
	public void run() {
			
		Timer chrono = new Timer();
	 chrono.schedule(new TimerTask() {

		@Override
		public void run() {
			

		TauxInteret.main();
				
			
		}
		 
	 }, 10000,this.time);
		
		
	}
	
}
