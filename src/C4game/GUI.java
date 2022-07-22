package C4game;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class GUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int rows = 6;
	private static final int cols = 7;
	
	//Whos Turn
	boolean IsRedTurn;
	
	Container display;
	
	Board boardmap;
	
	ImageIcon red = null;
	ImageIcon yellow = null;
	ImageIcon empty = null;
	
	
	public GUI(ImageIcon red,ImageIcon yellow,ImageIcon gray, Board boardmap) {
		//Who starts
		IsRedTurn = true;
		
		//Icons
		this.red = red;
		this.yellow = yellow;
		empty = gray;
		
		//BoardMap
		this.boardmap = boardmap;
		
		//Window
		setTitle("Connect 4");
		setSize(800,650);
		
		// Create JButton and JPanel
        display = getContentPane();
        display.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        
        for(int x = 0; x<rows;x++) {
        	for(int y = 0;y<cols;y++) {
        		
        		JButton button = new JButton();
        		button.setIcon(empty);
        		button.setPreferredSize(new Dimension(100,100));
        		button.setName(""+(x*10 + y));
        		
        		button.addActionListener(new ActionListener() {
        	         public void actionPerformed(ActionEvent e) {
        	        	
        	        	 int rows10pluscol = Integer.parseInt(((JButton)(e.getSource())).getName());
        	        	 int row = rows10pluscol/10;
        	        	 int col = rows10pluscol % 10;
        	        	 Updater(row,col);
        	        	 
        	          }
        	       });
        		display.add(button);
        	}
        	
        }

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	 
	public void Reset() {
		int row7pluscol;
		 for(int x = 0; x<rows;x++) {
	        	for(int y = 0;y<cols;y++) {
	        		row7pluscol = (x*7) + y;
	        		((JButton)display.getComponent(row7pluscol)).setIcon(empty);
	        	}	
		 }
	}
	
	 public void Updater(int row,int col) {
		
		 if(!(boardmap.CheckWinner())) {
		 	if(boardmap.IsThereAnEmptySpot(col)) {
			 
		 		row = boardmap.FindRow(col,IsRedTurn);
			 
		 		boardmap.AddPiece(row-1,col,IsRedTurn);
			 
		 		int row7pluscol = (row-1) * 7 + col;
			 
		 		if(IsRedTurn) {
		 			((JButton)display.getComponent(row7pluscol)).setIcon(red);
		 		
		 		}else {
		 			((JButton)display.getComponent(row7pluscol)).setIcon(yellow);
			 	
		 		}

		 		IsRedTurn = !IsRedTurn;
		 	}else {
		 		System.err.println("Invalid");
		 	}
	 	} else {
	 		System.out.println("Red: " + boardmap.GetRedwins() + " Yellow: " + boardmap.GetYellowdwins() );
	 		Reset();
	 		boardmap.Init();
	 	}
		
	 }
}
