package landmines;

import java.awt.Color;
import java.util.Random;

public class Game {
	private Random rand = new Random();
	public boolean bomb_tag[][] = new boolean[Frame.button.length][Frame.button[0].length];
	public Game() {
		for(int i=0;i<Frame.button.length;i++) {
			for(int j=0;j<Frame.button[i].length;j++) {
				bomb_tag[i][j] = false;
			}
		}
		
		//set landmines
		for(int c=0;c<Frame.bomb_num;c++) {
			int i= rand.nextInt(Frame.button.length);
			int j= rand.nextInt(Frame.button[i].length);
			if(bomb_tag[i][j] == false) {
				bomb_tag[i][j] = true;
			}
			else {
				c--;
			}
		}
	}
	
	public void end() {
		for(int i=0;i<Frame.button.length;i++) {
			for(int j=0;j<Frame.button[i].length;j++) {
				Frame.button[i][j].setEnabled(false);
				if(bomb_tag[i][j]) {
					Frame.button[i][j].setBackground(Color.RED);
				}
			}
		}
	}
	
	public void restsrt() {
		for(int i=0;i<Frame.button.length;i++) {
			for(int j=0;j<Frame.button[i].length;j++) {
				Frame.button[i][j].setEnabled(true);
				Frame.button[i][j].setBackground(null);
				Frame.button[i][j].setIcon(null);
				Frame.button[i][j].setText("");
			}
		}
		Frame.pressed = 0;
		Frame.flag_count = 0;
		Frame.flag_num.setText(Integer.toString(Frame.flag_count));
	}
	
	public void newgame() {	
		for(int i=0;i<Frame.button.length;i++) {
			for(int j=0;j<Frame.button[i].length;j++) {
				Frame.button[i][j].setEnabled(true);
				Frame.button[i][j].setText("");
				Frame.button[i][j].setBackground(null);
				Frame.button[i][j].setIcon(null);
				bomb_tag[i][j] = false;
			}
		}
		
		//set landmines
		for(int c=0;c<Frame.bomb_num;c++) {
			int i= rand.nextInt(Frame.button.length);
			int j= rand.nextInt(Frame.button[i].length);
			if(bomb_tag[i][j] == false) {
				bomb_tag[i][j] = true;
			}
			else {
				c--;
			}
		}
		Frame.pressed = 0;
		Frame.flag_count = 0;
		Frame.flag_num.setText(Integer.toString(Frame.flag_count));
	}
	
	public void win() {
		for(int i=0;i<Frame.button.length;i++) {
			for(int j=0;j<Frame.button[i].length;j++) {
				Frame.button[i][j].setEnabled(false);
				if(bomb_tag[i][j]) {
					Frame.button[i][j].setBackground(Color.PINK);
				}
			}
		}
	}

}