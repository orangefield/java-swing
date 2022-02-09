package site.metacoding.bubble.ex05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin 목적 : 쟘프
 * 
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	int count = 0; // 이 메서드가 몇 번 실행되는가 궁금할 때 이용

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

				if (e.getKeyCode() == 39) {
					// isRight를 false
					// private에 접근 할 수 없으니 게터세터
					player.setRight(false);

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft를 false
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// 눌리면
				// 왼쪽 37, 오른쪽 39, 위쪽 38, 아래쪽 40
				// System.out.println("키보드 프레스:" + e.getKeyCode());

				if (e.getKeyCode() == 39) {
					// 키보드 누르는 동안 right 메서드를 뗄 때까지 딱 한 번만 실행하고 싶다.
					// 누르고 있는지 아닌지 상태가 필요하다.
					// 안움직이는걸 움직이게 해야 == false 일 때
					if (player.isRight() == false) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isLeft() == false) {
						player.left();
					}
				} else if (e.getKeyCode() == 38) { // 이것을 막으면 이벤트 루프 등록을 안하는 것 -> 못 막는다
					if (player.isJump() == false) {
						System.out.println("카운트 : " + count);
						count++;
						player.jump(); // 메서드 내부에서 if 분기 처리는 이벤트 루프에 등록은 되는데 실행이 안되는 것
					}

				}

			}
		}); // 키보드 이벤트의 대상은 JFrame. 클릭 하나안하나 보는 그런 게 아니라, JF~이 대상이니까 앞에 뭘 쓸 필요가 없다
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
