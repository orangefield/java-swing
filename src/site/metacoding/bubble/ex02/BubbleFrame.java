package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin 목적 : 배경화면 설정, 캐릭터 추가
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.
	}

	// new 하는 것
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		//add(backgroundMap); 이거 말고
		setContentPane(backgroundMap);// 이거로 배경화면 설정
		
		player = new Player();
		
		
		
		add(player); // 형상화됨
	}

	// 각종 모든 세트
	private void initSetting() {
		setSize(1000, 640);
		// getContentPane().setLayout(null); // JFrame의 기본 JPanel의 absolute layout 설정
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼 클릭시 JVM 같이 종료
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
