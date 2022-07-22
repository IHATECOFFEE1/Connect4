package C4game;

import javax.swing.ImageIcon;

public class GameConnect4 {
	
	
	
	public static void main(String[] args ) {
		
		ImageIcon blue = null;
		ImageIcon gray = null;
		ImageIcon red = null;
		
		red = new ImageIcon("./red1.png");
		blue = new ImageIcon("./yellow.png");
		gray = new ImageIcon("./Empty.png");
		
		Board YourBoard = new Board();
		GUI frame = new GUI(red,blue,gray,YourBoard);
		
		//System.exit(0);
		
	}

}




