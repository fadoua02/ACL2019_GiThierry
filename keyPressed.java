import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyPressed implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		int touche = arg0.getKeyCode();
		switch (touche) 
		{
		case KeyEvent.VK_UP: 
			Heros.dy=1;
			break;
		case KeyEvent.VK_LEFT: 
			Heros.dx=-1;
			break;
		case KeyEvent.VK_RIGHT: 
			Heros.dx=1;
			break;
		case KeyEvent.VK_DOWN: 
			Heros.dy=-1;
			break;
		
		case KeyEvent.VK_SPACE:
			if (Labyrinthe.play==false) {
				Labyrinthe.play=true;
				Principale.level=1;
			}
			if (Principale.map ==1) {
				Labyrinthe.tir = true;
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}