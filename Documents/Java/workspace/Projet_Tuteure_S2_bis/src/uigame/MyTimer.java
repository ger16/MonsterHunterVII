package uigame;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import personnage.Niveaux;

public class MyTimer {

	Timer myTimer;
	TimerTask myTimerTask;
	Date myDate;
	String myDateString;
	int j,h,m,s;
	
	public MyTimer(){
		myTimer = new Timer();
		myDate = new Date();
		
		myTimerTask = new TimerTask(){
			public void run(){
				if (s < 59){
					s++;
				}
				else if (m < 59){
					s = 0;
					m++;
				}
				else if (h < 23){
					m = 0;
					h++;
				}
				else {
					h = 0;
					j++;
				}
				
				myDateString = "J : " + j + " H : " + h + " M : " + m + " S : " + s;
			}
		};
	}
	
	public MyTimer(String threadName){
		j = 0; h = 0; m = 0; s = 0;
		myTimer = new Timer(threadName);
		myDate = new Date();
		
		myTimerTask = new TimerTask(){
			public void run(){
				if (s < 59){
					s++;
				}
				else if (m < 59){
					s = 0;
					m++;
				}
				else if (h < 23){
					m = 0;
					h++;
				}
				else {
					h = 0;
					j++;
				}
				
				myDateString = "J : " + j + " H : " + h + " M : " + m + " S : " + s;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTimer time = new MyTimer("threadsd");
		time.time();
		while(true) {
		System.out.println(time.getTimer());
		}
	}
}
