package uigame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import personnage.Monstre;
import personnage.PJ;
import personnage.Personnage;

public class PlayerController implements MouseListener {
	
	private PJ player;
	private Monstre monster;
	private Input input;
	
	public PlayerController(PJ player, Monstre monster, GameContainer gc){
		this.player = player;
		this.monster = monster;
		input = gc.getInput();
	}
	
	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(int button, int x, int y, int arg3) {
		
		
		
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int button, int x, int y) {
				//Nord
		if(input.isMousePressed(0)){
				if (mouseZoneInput(x,y,new Point(44,244), new Point(143,223))){
					player.setMoving(true);
					player.setDirection(4);
				}
				//Est
				if (mouseZoneInput(x,y,new Point(44,194), new Point(143,173))){
					player.setMoving(true);
					player.setDirection(7);
				}
				//Ouest
				if (mouseZoneInput(x,y,new Point(44,143), new Point(143,122))){
					player.setMoving(true);
					player.setDirection(5);
				}
				//Sud
				if (mouseZoneInput(x,y,new Point(44,92), new Point(143,73))){
					player.setMoving(true);
					player.setDirection(6);
				}
				
				
				//Attack
				if (mouseZoneInput(x,y,new Point(275,200), new Point(360,100))){
					player.attaquer(monster);
					System.out.println(monster.getPV());
				}
		}
	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean mouseZoneInput(int xMousePos, int yMousePos, Point a, Point b) {
		if (xMousePos > a.getX() && xMousePos < b.getX() && yMousePos > b.getY() && yMousePos < a.getY()){
			return true;
		}
		return false;
	}
	
}
