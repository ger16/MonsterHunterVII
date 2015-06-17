package uigame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import personnage.Monstre;
import personnage.PJ;
import personnage.Personnage;

public class PlayerController implements MouseListener {
	
	private PJ player;
	private Monstre monsterTab[];
	private Input input;
	
	public PlayerController(PJ player, Monstre monsterTab[], GameContainer gc){
		this.player = player;
		this.monsterTab = monsterTab;
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
				if (mouseZoneInput(x,y,new Point(125,225), new Point(222,201))){
					if (player.getPA() >= 2){
					player.deplacement();
					player.setMoving(true);
					player.setDirection(4);
					}
				}
				//Est
				if (mouseZoneInput(x,y,new Point(216,153), new Point(312,132))){
					if (player.getPA() >= 2){
						player.deplacement();
						player.setMoving(true);
						player.setDirection(7);
						}
					
				}
				//Ouest
				if (mouseZoneInput(x,y,new Point(44,153), new Point(143,132))){
					if (player.getPA() >= 2){
						player.deplacement();
						player.setMoving(true);
						player.setDirection(5);
						}
					
				}
				//Sud
				if (mouseZoneInput(x,y,new Point(123,83), new Point(224,62))){
					if (player.getPA() >= 2){
						player.deplacement();
						player.setMoving(true);
						player.setDirection(6);
						}
					
				}
				
				
				//Attack
				if (mouseZoneInput(x,y,new Point(294,93), new Point(378,9))){
					for (int i =0; i<monsterTab.length;i++){
						player.attaquer(monsterTab[i]);
					}
				}
				
				if (mouseZoneInput(x,y,new Point(430,230), new Point(495,190))){
					if (player.getPalier() > 0){
					player.setForce(player.getForce()+1);
					player.setPalier(player.getPalier()-1);
					}
				}
				
				if (mouseZoneInput(x,y,new Point(430,150), new Point(495,110))){
					if (player.getPalier() > 0){
					player.setAdresse(player.getAdresse()+1);
					player.setPalier(player.getPalier()-1);
					}
				}
				
				if (mouseZoneInput(x,y,new Point(430,70), new Point(495,30))){
					if (player.getPalier() > 0){
					player.setResistance(player.getResistance()+1);
					player.setPalier(player.getPalier()-1);
					}
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
