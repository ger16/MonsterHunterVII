package uigame;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.Graphics;

import com.sun.prism.paint.Color;

public class MyTimer {
	


	public static final int PERIODE = 10;
	
	Timer myTimer;
	TimerTask myTimerTask;
	Date myDate;
	String myDateString;
	int s;
	
	public MyTimer(){
		s = 0;
		myTimer = new Timer();
		myDate = new Date();
		
		myTimerTask = new TimerTask(){
			
			public void run(){
				s += 1;
				myDateString = "Temps : " + s;
				
			}
		};
	}
	
	public MyTimer(String threadName){
		 s = 0;
		myTimer = new Timer(threadName);
		myDate = new Date();
		
		myTimerTask = new TimerTask(){
					
			public void run(){
				s += 1;
				myDateString = "Temps : " + s;
			}
		};
	}
	
	public void time(){
		long temps = 1000;
		long startTime = 0;
		
		myTimer.schedule(myTimerTask, startTime, temps);
	}
	
	public String getTimer(){
		return myDateString;
	}
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTimer time = new MyTimer("threadsd");
		time.time();
		while(true) {
		System.out.println(time.getTimer());
		}
	}*/

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}
}
