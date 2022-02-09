package site.metacoding.ex13;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyPanel extends JPanel {

	int x = 100;
	int y = 200;

	// JPanel 을 새로고침(다시 그린다)하는 것
	@Override
	protected void paintComponent(Graphics g) { // g는 붓이다.
		super.paintComponent(g);
		System.out.println("패널 다시 그려짐");

		g.drawLine(10, 20, x, y);
	}
}

public class EventEx02 extends JFrame implements UserInterface {

	MyPanel myPanel;
	JLabel labelText;
	JButton btn1, btn2; // 200, 300으로 변경

	public EventEx02() {
		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}

	@Override
	public void initSetting() {
		setSize(500, 500);
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void initObject() {
		myPanel = new MyPanel();
		labelText = new JLabel("첫글자");
		btn1 = new JButton("글자변경");
		btn2 = new JButton("그림변경");
	}

	@Override
	public void initAssign() {
		add(myPanel);
		myPanel.add(labelText);
		myPanel.add(btn1);
		myPanel.add(btn2);
	}

	@Override
	public void initListener() {
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//setText 메서드는 부분 변경 가능->화면을 바뀔 btn2를 위해 새로고침하기 위해서는 다른 방법을 써야 한다.
				labelText.setText("두번째글자"); // setText 메서드는 내부에 paintComponent를 F5한 것처럼재호출해준다. (setVisible을 재차 하는게 아니라)
											// myPanel이 전부 다시 그려졌음

			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.x = myPanel.x + 30;
				myPanel.y = myPanel.y + 30; // 여기까지하면 값은 바꼈지만 그림은 아직 안바꼈다.
			
				System.out.println(myPanel.x);
				System.out.println(myPanel.y);
				
				// repaint();  (this.가 생각되어 있으니까)JFrame의 그림을 다시 그려준다. 패널이 다시 그려진게 아니라
				myPanel.repaint(); // 이건 JFrame 안의 panel을 다시 그려주는거
			}
		});

	}

	public static void main(String[] args) {
		new EventEx02();
	}
}
