import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Principale extends JFrame {
	
	static int map=1;
	static boolean changement=false;
	static boolean on=false;
	static int level=0;

    public Principale() {
        
        initUI();
    }
    
    private void initUI() {
        add(new Labyrinthe());
        addKeyListener(new keyPressed());
        setTitle("Space Taclard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(389, 410);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Principale Jeu = new Principale();
            Jeu.setVisible(true);
        });
    }



}