import java.awt.Image;
import javax.swing.JPanel;

public class Heros extends JPanel {
	public int x;
	public int y;
	public Image taco;
	static int dx=0;
	static int dy=0;
	static int life=2;

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

	public void move() {
		if (dx==1) {
			setX(x+25);
		}
		if (dx==-1) {
			setX(x-25);
		}
		if (dy==-1) {
			setY(y+25);
		}
		if (dy==1) {
			setY(y-25);
		}
	}
	
	public void move2() {
		int pos = x/25+15*(int)y/25;
		int pos_ = Labyrinthe.lab[pos];
		if (dx==-1 && dy==0 && (pos_ & 1) != 0 || dx==1 && dy==0 && (pos_ & 4) != 0 ||
				dx==0 && dy==-1 && (pos_ & 8) != 0 || dx==0 && dy==1 && (pos_ & 2) != 0 ) {
			//System.out.println(h.dy);
			dx=0;
			dy=0;
		}
		else {
			move();
			dx=0;
			dy=0;
		}
	}

	public void reset() {
		x= 0;
		y= 0;
	}
}