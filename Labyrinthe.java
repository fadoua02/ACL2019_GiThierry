import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.ArrayList;
public class Labyrinthe extends JPanel implements ActionListener{
	private int longueur = 25;
	private int nombre_carre = 15;
	private int taille_fenetre = nombre_carre * longueur;
	private Timer timer = new Timer(25, (ActionListener) this);
	private Color black = new Color(0, 0, 0);
	Heros h = new Heros();
	Monstre m = new Monstre();
	Fantome f = new Fantome();
	Monstre m1 = new Monstre();
	Monstre m2 = new Monstre();
	Monstre m3 = new Monstre();
	Monstre m4 = new Monstre();
	Portal p = new Portal();
	ArrayList<Monstre> Monstres = new ArrayList();
	Boolean chargementVie = false;
	static Boolean tir = false;

	Boolean chevre = true;
	private boolean clef=false;
	static Boolean play = false;
	static Boolean replay = false;

	static int[] lab;

	private void remplirListeMonstres() {
		Monstres = new ArrayList();
		Monstres.add(m1);
		Monstres.add(m2);
		Monstres.add(m3);
		Monstres.add(m4);
	}

	private void genererLabyrinthe(Graphics2D g2d,int map) {
		String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
		g2d.setColor(black);
		if (map==1) {
			lab=ReadFile.read("lab.txt");
		}
		int i = 0;
		for (int y = 0; y < taille_fenetre; y += longueur) {
			for (int x = 0; x < taille_fenetre; x += longueur) {
				if ((lab[i] & 1) != 0) { 
					g2d.drawLine(x,y,x,y+longueur-1);
				}
				if ((lab[i] & 2) != 0) { 
					g2d.drawLine(x,y,x+longueur-1,y);
				}
				if ((lab[i] & 4) != 0) { 
					g2d.drawLine(x+longueur-1,y,x+longueur-1,y+longueur-1);
				}
				if ((lab[i] & 8) != 0) { 
					g2d.drawLine(x, y+longueur-1,x+longueur-1,y+longueur-1);
				}
				i++;
			}
		}
		if (play==false) {
			g2d.setColor(Color.black);
			try {
				File intro = new File(adressedufichier + "ecranPrincipal.png");
				g2d.drawImage(ImageIO.read(intro), 0, 0, 388, 420, null);
			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
			for (Monstre m : Monstres) {
				m.reset();
			}
			f.reset();
		}
	}


	public void life(Graphics g2d) {
		boolean attacked=false;
		if (play==true){
			for (int i=0; i<Monstres.size(); i++) {
				if ((Monstres.get(i).x == h.x && Monstres.get(i).y == h.y) 
//						|| (Monstres.get(i).x+25 == h.x && Monstres.get(i).y == h.y)
						//						|| (Monstres.get(i).x == h.x && Monstres.get(i).y+25 == h.y)
						//						|| (Monstres.get(i).x == h.x && Monstres.get(i).y == h.y+25)
						|| (f.x +25== h.x && f.y == h.y)
						//						|| (f.x == h.x+25 && f.y == h.y)
						//						|| (f.x == h.x && f.y+25 == h.y)
						//						|| (f.x == h.x && f.y == h.y+25)
						) {
					attacked = true;
					h.life--;
				}
			}
		}
	}

	public void chargerImage(Graphics2D g2d,int dxx, int dyy) {
		String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
		try {
			File input_bg = new File(adressedufichier + "space.jpg");
			g2d.drawImage(ImageIO.read(input_bg),0*0,0*0,380,420, null);
			File input_g1 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_g1), 0, 2*25-1, 2*25, 8*25+1, null);
			File input_g2 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_g2), 2*25, 5*25-1, 2*25, 4*25+1, null);

			File input_h1 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_h1), 3*25-1, 0, 7*25+1, 25, null);
			File input_h2 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_h2), 3*25-1, 25-1, 3*25+1, 25+1, null);
			File input_h3 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_h3), 4*25, 2*25-1, 2*25, 25+1, null);

			File input_b1 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_b1), 6*25, 10*25-1,3*25, 2*25+1, null);
			File input_b2 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_b2), 6*25, 12*25-1, 4*25, 25+1, null);
			File input_b3 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_b3), 3*25-1, 13*25, 7*25+1, 2*25-1, null);

			File input_d1 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_d1), 14*25, 3*25, 25, 8*25, null);
			File input_d2 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_d2), 12*25, 6*25-1, 2*25, 2*25+1, null);

			File input_m = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_m), 6*25, 6*25-1, 3*25, 2*25+1, null);

			File input_m1 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_m1), 9*25-1, 2*25-1, 25+1, 25+1, null);
			File input_m2 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_m2), 9*25-1, 3*25-1, 3*25+1, 25+1, null);
			File input_m3 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_m3), 7*25-1, 4*25-1, 5*25+1, 25+1, null);
			File input_m4 = new File(adressedufichier +"murs.png");
			g2d.drawImage(ImageIO.read(input_m4), 10*25-1, 5*25-1, 25+1, 5*25+1, null);

			File input1 = new File(adressedufichier + "taco.png");
			h.taco = ImageIO.read(input1);
			g2d.drawImage(h.taco, dxx, dyy, 25, 25,null);

			if (chevre==true) {
				File input3 = new File(adressedufichier + "chevre.png");
				g2d.drawImage(ImageIO.read(input3), 15, 12*27, 70,70, null);
			}
		} catch (IOException ie) {
			System.out.println("Erreur :"+ie.getMessage());
		}

	}


	public void chargerImageTresor(Graphics g2d) {
		if (play==true) {
			Tresor tresor = new Tresor();
			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
			try {
				File input = new File(adressedufichier + "frites.png");
				tresor.image_tresor=ImageIO.read(input);
				g2d.drawImage(tresor.image_tresor, tresor.x, tresor.y, 25, 25, null);
			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
		}
	}

	public void chargerImagePortal(Graphics g2d) {
			if (play==true) {
				String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
				try {
					File input = new File(adressedufichier + "portal.png");
					p.image_passage=ImageIO.read(input);
					g2d.drawImage(p.image_passage, p.x+5*25, p.y+12*25, 25, 25, null);
					g2d.drawImage(p.image_passage, p.x+10*25, p.y+25*2, 25, 25, null);
				} catch (IOException ie) {
					System.out.println("Erreur :"+ie.getMessage());
				}
		}
	}

	public void chargerImageMonstre(Graphics g2d, int x, int y, Monstre M) {
		if (play==true) {
			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
			try {		
				File input = new File(adressedufichier + "broccoli.png");
				M.image_monstre = ImageIO.read(input);
				g2d.drawImage(M.image_monstre, x, y, 25, 25, null);
			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
		}
	}

	public void chargerImageFantome(Graphics g2d, int x, int y) {
		if (play==true) {
			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
			try {		
				File input = new File(adressedufichier + "ghost.png");
				f.image_fantome = ImageIO.read(input);
				g2d.drawImage(f.image_fantome, x, y, 25, 25, null);

			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
		}
	}

	public void GameOver(Graphics g2d) {
		if (h.life<=0) {
			replay=true;
			play=false;
			for (int i=0; i<Monstres.size(); i++) {
				Monstres.get(i).enVie=false;
			}
			f.enVie=false;

			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
			try {
				File input1 = new File(adressedufichier + "gameover.png");
				g2d.drawImage(ImageIO.read(input1), 0, 0, 388, 420, null);

			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
		}
	}

	public void PartieGagnee(Graphics g2d) {
		if (h.x == 350 && h.y == 350 && clef==true) {
			play=false;
			replay=true;
			String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
			try {

				File input2 = new File(adressedufichier + "win.png");
				g2d.drawImage(ImageIO.read(input2), 0, 0, 388, 420, null);

			} catch (IOException ie) {
				System.out.println("Erreur :"+ie.getMessage());
			}
		}
	}

	public void deplacementMonstre(Graphics g2d, Monstre M) {
		M.move();
		M.setX(M.getX()+(M.dx*3));
		M.setY(M.getY()+(M.dy*3));
		chargerImageMonstre(g2d, M.getX(), M.getY(),M);
	}

	public void deplacementMonstres(Graphics g2d) {
		remplirListeMonstres(); 
		for (int i=0; i<Monstres.size(); i++) {
			if (Monstres.get(i).enVie == true) {
				deplacementMonstre(g2d,Monstres.get(i));
			}
		}
	}

	public void deplacementFantome(Graphics g2d) {
		f.move();
		f.setX(f.getX()+(f.dx*3));
		f.setY(f.getY()+(f.dy*3));
		if (f.enVie == true) {
			chargerImageFantome(g2d, f.getX(), f.getY());
		}
	}

	public void passagePortal(Graphics g2d) {
			if (h.x == p.x+5*25 && h.y == p.y+12*25 ) {
				h.setX(11*25);
				h.setY(25*2);
		}
			if (h.x == p.x+10*25 && h.y == p.y+2*25 ) {
				h.setX(4*25);
				h.setY(25*12);
		}
	}

	public void tirMonstre(Monstre m) {
		m.enVie=false;
	}

	public void tirFantome(Fantome f) {
		f.enVie=false;
		System.out.println("coucou");
	}

	public void clef(Graphics g2d) {
		if ((h.x==25 ||h.x==50) && h.y==13*25) {
			chevre=false;
			clef=true;
		}
	}

	public void tueMonstre(Graphics g2d) {
		if (tir==true) {
			for (int i=0; i<Monstres.size(); i++) {
				if ((Math.abs(h.y-Monstres.get(i).y))<30 && (Math.abs(h.x-Monstres.get(i).x))<30) {
					tirMonstre(Monstres.get(i));
					tir=false;
				}
				else {
					tir=false;
				}
			}
		}
	}

	public void tueFantome(Graphics g2d) {
		if (tir==true) {
			System.out.println("coucou");
			if ((Math.abs(h.y-f.y))<50 || (Math.abs(h.x-f.x))<50) {
				tirFantome(f);
				tir=false;
			}
			else {
				tir=false;
			}
		}
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		trace(g);
	}

	public void trace(Graphics g) {
		setBackground(new Color(0,0,0));
		timer.start();
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.white);
		g.fillRect(0,0,17*25,17*25);
		chargerImage(g2d,h.getX(),h.getY());
		genererLabyrinthe(g2d,Principale.map);
		GameOver(g2d);
		deplacementMonstres(g2d);
		deplacementFantome(g2d);
		life(g2d);
		tueMonstre(g2d);
		chargerImageTresor(g2d);
		clef(g2d);
		passagePortal(g2d);
		chargerImagePortal(g2d);
		PartieGagnee(g2d);

		repaint();
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		h.move2();
		repaint();
	}

}