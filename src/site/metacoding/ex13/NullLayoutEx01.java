package site.metacoding.ex13;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NullLayoutEx01 extends MyFrame {

	public NullLayoutEx01() {
		super(300, 300);

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(null);

		JButton btn1 = new JButton("버튼1");
		panel.add(btn1); // null 레이아웃일 때는 위치를 잡아줘야 보인다
		btn1.setSize(100, 50);
		btn1.setLocation(0,0);
				

		setVisible(true);
	}

	public static void main(String[] args) {
		new NullLayoutEx01();
		
		
	}
}
