package C4game;

public class Board {
	
	private static final int rows = 6;
	private static final int cols = 7;
	// Red 1
	// Yellow -1
	// Empty 0
	
	int[][] BoardMap = new int[rows][cols];
	
	int RedWins = 0;
	int YellowWins = 0;
	
	public void Init() {
		for(int i = 0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				BoardMap[i][j] = 0;
			}
			
		}
		
	}
	
	public Board() {
		Init();
	}
	
	
	public boolean IsThereAnEmptySpot(int collum) {
		
		if(BoardMap[0][collum] != 0) {
			return false;
		}
		
		return true;
	}
	
	
	public int FindRow(int col, boolean Color /* true red, false yellow */ ) {
			int row;
			
			// We dont need to check the first row cuz IsThereAnEmptySpot function does that
			for(row = 1;row <rows;row++) {
				if(BoardMap[row][col] != 0) {
					return row;
				}
			}
			return row;
		}
	
	public void AddPiece(int row,int col, boolean IsRed) {
		if(IsRed) {
			BoardMap[row][col] = 1;
		}else {
			BoardMap[row][col] = -1;
		}
	}
			
	public boolean Check4horizontal() {
		int count;
		int temp = 0;
		
		for(int row = 0;row < rows;row++) {
			count = 0;
			
			for(int col = 0;col <cols;col++) {
				
				if(temp != BoardMap[row][col]) {
					temp = BoardMap[row][col];
					count = 1;
				}else {
					if(temp != 0) {
						count++;
					}
				}
				if(count == 4) {
					
					if(temp > 0) {
						RedWins++;
					} else {
						YellowWins++;
					}
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean Check4vertical() {
		int count;
		int temp = 0;
		
		for(int col = 0;col <cols;col++) {
			count = 0;
			
			for(int row = 0;row < rows;row++) {
				
				if(temp != BoardMap[row][col]) {
					temp = BoardMap[row][col];
					count = 1;
				}else {
					if(temp != 0) {
						count++;
					}
				}
				
				if(count == 4) {
					
					if(temp > 0) {
						RedWins++;
					} else {
						YellowWins++;
					}
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public boolean CheckDiagonalLtoR() {
		int temp = 0;
		int count;
		
		for(int row = rows - 1;row >= 3; row--) {
			for(int col = 0;col < cols - 3;col++) {
					count = 0;
				for(int x = col, y = row; x< cols && y >= 0;x++,y--) {
					
					if(temp != BoardMap[y][x]) {
						temp = BoardMap[y][x];
						count = 1;
					}else {
						if(temp != 0) {
							count++;
						}
					}
					
					if(count == 4) {
						
						if(temp > 0) {
							RedWins++;
						} else {
							YellowWins++;
						}
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean CheckDiagonalRtoL() {
		int temp = 0;
		int count;
		
		for(int row = 0;row < rows -3; row++) {
			for(int col = 0;col < cols- 3;col++) {
					count = 0;
				for(int x = col, y = row; x< cols && y < rows;x++,y++) {
					
					if(temp != BoardMap[y][x]) {
						temp = BoardMap[y][x];
						count = 1;
					}else {
						if(temp != 0) {
							count++;
						}
					}
					
					if(count == 4) {
						
						if(temp == 1) {
							RedWins++;
						}
						if(temp == -1){
							YellowWins++;
						}
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	
	
	public void printBoard() {
		
		System.out.println();
		System.out.println();
		
		for(int x = 0;x<rows;x++) {
			for(int y = 0; y<cols;y++) {
				System.out.print(BoardMap[x][y]+ "  ");
			}
			System.out.println();
		}
	}
	
	public int GetRedwins() {
		return RedWins;
	}
	
	public int GetYellowdwins() {
		return YellowWins;
	}
	
	public boolean CheckWinner(){
		
		if(this.Check4vertical()) {
			return true;
		}
		if(Check4horizontal()) {
			return true;
		}
		if(CheckDiagonalLtoR()) {
			return true;
		}
		if(CheckDiagonalRtoL()) {
			return true;
		}
		
		return false;
	}
}

