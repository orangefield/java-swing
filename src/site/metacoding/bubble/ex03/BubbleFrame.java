package site.metacoding.bubble.ex03;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin 목적 : 캐릭터 좌우 이동
 * 
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.
	}

	// new 하는 것
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		// add(backgroundMap); 이거 말고
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

	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// 누른걸 떼면
				System.out.println("키보드 릴리즈");

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// 눌리면
				// 왼쪽 37, 오른쪽 39, 위쪽 38, 아래쪽 40
				System.out.println("키보드 프레스:" + e.getKeyCode());

				if (e.getKeyCode() == 39) {
					player.right(); // 생성자에서 right 만들었으면 player에 접근 못했을 것
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.left();
				}

			}
		}); // 키보드 이벤트의 대상은 JFrame. 클릭 하나안하나 보는 그런 게 아니라, JF~이 대상이니까 앞에 뭘 쓸 필요가 없다
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
