package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	// 실행용
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	// 오브젝트 관련
	private void initObject() {
		// 2. 도화지에 배경을 띄운다.
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);

		player = new Player();

		add(player);
	}

	// 세팅 관련
	private void initSetting() {
		// 1. 먼저 도화지를 깔고
		setSize(1000, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 리스너
	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// 누른 걸 떼면
				System.out.println("키보드 릴리즈");

				if (e.getKeyCode() == 39) {
					player.setRight(false);
				} else if (e.getKeyCode() == 37) {
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// 누르면
				// 왼쪽 37, 오른쪽 39, 위쪽 38, 아래쪽 40
				// System.out.println("키보드 프레스: " + e.getKeyCode());

				if (e.getKeyCode() == 39) {
					if (player.isRight() == false) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isLeft() == false) {
						player.left();
					}

				} else if (e.getKeyCode() == 38) {
					if(player.isJump() == false) {
						player.jump();
					}
				}

			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
