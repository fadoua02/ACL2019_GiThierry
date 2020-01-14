import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Monstre extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x=25;
	public int y=25;
	public Image image_monstre;
	public int dx=0;
	public int dy=0;
	public boolean enVie=true;
		
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	void move() {
		Random random = new Random();
		ArrayList<String> choix = new ArrayList();
		if (x % 25 == 0 && y % 25 ==0) {
			int position = x/25 + 15 * (int)(y/25);
			if ((Labyrinthe.lab[position] & 1) ==0 && dx != 1) {
				choix.add("Left");
			}
			if ((Labyrinthe.lab[position] & 2) ==0 && dy != 1) {
				choix.add("Up");
			}
			if ((Labyrinthe.lab[position] & 4) ==0 && dx != -1) {
				choix.add("Right");
			}
			if ((Labyrinthe.lab[position] & 8) ==0 && dy != -1) {
				choix.add("Down");
			}
			if (choix.size()!=0) {
				int nombreAleatoire = random.nextInt(choix.size());
				String direction = choix.get(nombreAleatoire);
				switch (direction) {
				case "Left":
					moveLeft();
					break;
				case "Right":
					moveRight();
					break;
				case "Up":
					moveUp();
					break;
				case "Down":
					moveDown();
					break;
				}
			}
			else {
				dx=-dx;
				dy=-dy;
			}
		}
	}
	
	void moveRight() {
		// TODO Auto-generated method stub
		setX(x+1);
		dx=1;
		dy=0;
	}

	 void moveLeft() {
		// TODO Auto-generated method stub
		setX(x-1);
		dx=-1;
		dy=0;
	}

	void moveDown() {
		// TODO Auto-generated method stub
		setY(y+1);
		dx=0;
		dy=1;
	}

	void moveUp() {
		// TODO Auto-generated method stub
		setY(y-1);
		dx=0;
		dy=-1;
	}
	
	void reset() {
		x = 25*10;
		y = 25*5;
		enVie=true;
	}
}