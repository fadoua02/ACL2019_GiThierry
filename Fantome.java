import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Fantome {
	public int x=25*10;
	public int y=25*5;
	public Image image_fantome;
	static int dx=0;
	static int dy=0;
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
		if (x%25 == 0 && y%25 == 0) {
			Random random = new Random();
			ArrayList<String> choix = new ArrayList();
			choix.add("Left");
			choix.add("Right");
			choix.add("Up");
			choix.add("Down");
			String direction = choix.get(random.nextInt(choix.size()));
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
		if (x>25*14) {
			moveLeft();
		}
		if (x<0) {
			moveRight();
		}
		if (y<0) {
			moveDown();
		}
		if (y>25*14) {
			moveUp();
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
		x=25*9;
		y=25*5;
		enVie=true;
	}
}