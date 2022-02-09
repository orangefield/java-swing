package site.metacoding.ex13;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx01 extends JFrame {

	JPanel myPanel;
	JButton btn1, btn2; // ctrl + shift + o : import
	// JButton btn2;
	JCheckBox checkBox1;
	JLabel labelText, labelImg; // div 같은거

	public EventEx01() {
		initSetting();
		initObject();
		initAssign();
		initListener();
		
		setVisible(true);
	}

	private void initSetting() {
		setSize(300, 300);
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initObject() {
		myPanel = new JPanel();
		btn1 = new JButton("클릭하세요");
		btn2 = new JButton("클릭해보시라우");
		checkBox1 = new JCheckBox();
		labelText = new JLabel("레이블1");
		//내 프로젝트 위치부터 상대경로가 지정되어 있다.
		labelImg = new JLabel(new ImageIcon("image/dog.jpg"));
	}

	private void initAssign() {
		add(myPanel); // JFrame이 갖고 있는 메서드 바로 쓰기, 패널을 myPanel로 변경했다. getcontentpane 안쓰고
//		myPanel.setLayout(new GridLayout());
		myPanel.add(btn1);
		myPanel.add(btn2);
		myPanel.add(checkBox1);
		myPanel.add(labelText);
		myPanel.add(labelImg);
		labelImg.setPreferredSize(new Dimension(200, 200));
	}

	private void initListener() {
		checkBox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.toString());
				System.out.println(e.getStateChange());

				if (e.getStateChange() == 1) {
					System.out.println("체크 되었심더");
				} else {
					System.out.println("체크 해제되었심더");
				}
			}
		});

		// 윈도우야 이 버튼 좀 지켜봐줘
		btn1.addActionListener(new ActionListener() {

			// 버튼이 클릭되면 윈도우가 해당 메서드를 콜백해준다.
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1이 클릭되었습니다.");

			}
		});

		// 윈도우야 이 버튼 좀 지켜봐줘
		btn2.addActionListener((ActionEvent e) -> {
			System.out.println("버튼2도 클릭했구나 키미쨩");
		});
	}

	public static void main(String[] args) {
		new EventEx01();

	}

}
