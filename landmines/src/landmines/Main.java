package landmines;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Frame frame = new Frame();

		// 若關閉視窗則停止應用程式
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 視窗最大化
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// 使視窗可以看見
		frame.setVisible(true);
	}

}