package landmines;

import java.awt.Color;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public void  open(int i,int j,boolean tag[][]) {
		if(Frame.button[i][j].getText().equals("0")) {
			if(i != 0 && j != 0) {//up left 1
				if(Frame.button[i-1][j-1].isEnabled()) {
					Frame.button[i-1][j-1].setEnabled(false);
					Frame.button[i-1][j-1].setText(Integer.toString(calculate(i-1,j-1,tag)));
					Frame.pressed++;
					open(i-1,j-1,tag);
				}
			}
			if(i != 0) {//up 2
				if(Frame.button[i-1][j].isEnabled()) {
					Frame.button[i-1][j].setEnabled(false);
					Frame.button[i-1][j].setText(Integer.toString(calculate(i-1,j,tag)));
					Frame.pressed++;
					open(i-1,j,tag);
				}
			}
			if(i != 0 && j != Frame.button[i].length-1) {//up right 3
				if(Frame.button[i-1][j+1].isEnabled()) {
					Frame.button[i-1][j+1].setEnabled(false);
					Frame.button[i-1][j+1].setText(Integer.toString(calculate(i-1,j+1,tag)));
					Frame.pressed++;
					open(i-1,j+1,tag);
				}
			}
			if(j != 0) {//left 4
				if(Frame.button[i][j-1].isEnabled()) {
					Frame.button[i][j-1].setEnabled(false);
					Frame.button[i][j-1].setText(Integer.toString(calculate(i,j-1,tag)));
					Frame.pressed++;
					open(i,j-1,tag);
				}
			}
			if(j != Frame.button[i].length-1) {//right 6
				if(Frame.button[i][j+1].isEnabled()) {
					Frame.button[i][j+1].setEnabled(false);
					Frame.button[i][j+1].setText(Integer.toString(calculate(i,j+1,tag)));
					Frame.pressed++;
					open(i,j+1,tag);
				}
			}
			if(i != Frame.button.length-1 && j != 0) {//down left 7
				if(Frame.button[i+1][j-1].isEnabled()) {
					//down
					Frame.button[i+1][j-1].setEnabled(false);
					Frame.button[i+1][j-1].setText(Integer.toString(calculate(i+1,j-1,tag)));
					Frame.pressed++;
					open(i+1,j-1,tag);
				}
			}
			if(i != Frame.button.length-1) {//down 8
				if(Frame.button[i+1][j].isEnabled()) {
					Frame.button[i+1][j].setEnabled(false);
					Frame.button[i+1][j].setText(Integer.toString(calculate(i+1,j,tag)));
					Frame.pressed++;
					open(i+1,j,tag);
				}
			}
			if(i != Frame.button.length-1 && j != Frame.button[i].length-1) {//down right 9
				if(Frame.button[i+1][j+1].isEnabled()) {
					Frame.button[i+1][j+1].setEnabled(false);
					Frame.button[i+1][j+1].setText(Integer.toString(calculate(i+1,j+1,tag)));
					Frame.pressed++;
					open(i+1,j+1,tag);
				}
			}
			

		}
	}
	public int calculate(int i,int j,boolean tag[][]) {
		int tmp = 0;
		
		try { if(tag[i-1][j-1]) tmp++; }
		catch(ArrayIndexOutOfBoundsException e){}
		try { if(tag[i-1][j]) tmp++; }
		catch(ArrayIndexOutOfBoundsException e){}
		try { if(tag[i-1][j+1]) tmp++; }
		catch(ArrayIndexOutOfBoundsException e){}
		try { if(tag[i][j-1]) tmp++; }
		catch(ArrayIndexOutOfBoundsException e){}
		try { if(tag[i][j+1]) tmp++; }
		catch(ArrayIndexOutOfBoundsException e){}
		try { if(tag[i+1][j-1]) tmp++; }
		catch(ArrayIndexOutOfBoundsException e){}
		try { if(tag[i+1][j]) tmp++; }
		catch(ArrayIndexOutOfBoundsException e){}
		try { if(tag[i+1][j+1]) tmp++; }
		catch(ArrayIndexOutOfBoundsException e){}
		
		if(tmp == 0)
			Frame.button[i][j].setBackground(Color.lightGray);
		else if(tmp == 1)
			Frame.button[i][j].setBackground(Color.cyan);
		else if(tmp == 2)
			Frame.button[i][j].setBackground(Color.green);
		else if(tmp == 3)
			Frame.button[i][j].setBackground(Color.orange);
		else
			Frame.button[i][j].setBackground(Color.yellow);
		return tmp;
	}

}