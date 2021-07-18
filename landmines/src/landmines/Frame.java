package landmines;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Frame extends JFrame implements ActionListener{
	
	private JButton restart,newgame;
	public static JButton flag_num =  new JButton();
	public JButton flag_num_txt;
	public static JButton button[][]=new JButton[9][9];
	public static int bomb_num = 10;
	public Test test = new Test();
	public Game game = new Game();
	public static int pressed = 0,flag_count = 0,time_count = 0;
	public Frame() {
		
		JPanel mp = new JPanel(); 
		//把mp面板加入frame
		add(mp, BorderLayout.CENTER);
		mp.setLayout(new GridLayout(0,Frame.button.length,0,0));
		
		//creat landmines button[][]
		for(int i=0;i<button.length;i++) {
			int ii = i;
			for(int j=0;j<button[i].length;j++) {
				int jj = j;
				button[i][j]= new JButton("");
				button[i][j].addActionListener(this);
				button[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if ( e.getButton() == MouseEvent.BUTTON3 && button[ii][jj].isEnabled() ) {
							if(button[ii][jj].isBackgroundSet()) {
								flag_count--;
								flag_num.setText(Integer.toString(flag_count));
								button[ii][jj].setBackground(null);
								button[ii][jj].setIcon(null);
							}
							else {
								flag_count++;
								flag_num.setText(Integer.toString(flag_count));
								button[ii][jj].setBackground(Color.GRAY);
								ImageIcon icon = new ImageIcon(getClass().getResource("flag.png"));
								button[ii][jj].setIcon(icon);
							}
						}	
					}	
				});
				mp.add(button[i][j]);
			}
		}
		
		
		
		//creat restart button
		restart = new JButton("restart");
		restart.setBackground(Color.white);
		restart.addActionListener(this);
		mp.add(restart);
		
		//creat newgame button
		newgame = new JButton("new game");
		newgame.setBackground(Color.white);
		newgame.addActionListener(this);
		mp.add(newgame);
		
		
		JButton flag_num_txt = new JButton();
		flag_num_txt.setBackground(Color.white);
		flag_num_txt.setText("旗子數:");
		flag_num_txt.setEnabled(false);
		mp.add(flag_num_txt);
		
		flag_num.setBackground(Color.white);
		flag_num.setText(Integer.toString(flag_count));
		flag_num.setEnabled(false);
		mp.add(flag_num);
			
		game.restsrt();
			
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == restart) {
			int res = JOptionPane.showConfirmDialog(null, "確定要重新開始", "restart", JOptionPane.YES_NO_OPTION); 
			if(res == JOptionPane.YES_OPTION) {
				game.restsrt();
			}
				
		}
		else if (e.getSource() == newgame) {
			int res = JOptionPane.showConfirmDialog(null, "確定要開啟新遊戲", "newgame", JOptionPane.YES_NO_OPTION); 
			if(res == JOptionPane.YES_OPTION) {
				game.newgame();
			}
		}
		else {
			for(int i=0;i<button.length;i++) {
				for(int j=0;j<button[i].length;j++) {
					if(!Color.GRAY.equals(button[i][j].getBackground())) {
						if (e.getSource() == button[i][j]) {
							if(game.bomb_tag[i][j]) {
								JOptionPane.showMessageDialog(null, "!!BOMB!!", "!!BOMB!!", JOptionPane.ERROR_MESSAGE);
								game.end();
							}
							else {
								button[i][j].setEnabled(false);
								button[i][j].setText(Integer.toString(test.calculate(i,j,game.bomb_tag)));
								test.open(i, j, game.bomb_tag);
								pressed++;
								if(pressed == Frame.button.length*Frame.button[i].length - bomb_num) {
									JOptionPane.showMessageDialog(null, "YOU WIN", "!!WIN!!", JOptionPane.ERROR_MESSAGE);
									game.win();
								}
							}
						}
					}
				}
			}
		}	
	}
		
}