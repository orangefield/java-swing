package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin 목적 : 점프!
 */

public class Player extends JLabel {
	private int x;
	private int y;

	private ImageIcon playerR, playerL; // 우측 보고 있는 플레이어

	private boolean isRight;
	private boolean isLeft;
	private boolean isJump; // 점프 상태(up, down을 모두 포함)

	private static final int JUMPSPEED = 2;
	private static final int SPEED = 3;

	
	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 537;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent호출해줌 : 얘는 label 다시 그려줌

		isRight = false; // 디폴트는 false, 키보드 누르는 순간 true
		isLeft = false;
		isJump = false;
	}

	public void left() {
		isLeft = true;
		setIcon(playerL); // 바꿔끼우기
		System.out.println("왼쪽 이동");

		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y); // paintComponent
				try {
					Thread.sleep(15);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		;

	}

	public void right() {
		// 메서드 모듈 : 목적이 있는 메서드
		isRight = true; // 키보드를 뗄 때 다시 false
		setIcon(playerR);
		System.out.println("오른쪽 이동");

		new Thread(() -> {
			while (isRight) {
				// 했더니 뻗어버렸다 아이고 -> 작업관리자에서 인터럽트
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(15);
					// 했는데도 또 뻗었다 -> while을 스레드 돌리자
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		; // 스레드 객체 만들어서 스타또

	}

	public void jump() {
		System.out.println("위로 점프");
		isJump = true;
		// up 상태 : sleep(5) -> for

		new Thread(() -> {
			//UP
			for (int i = 0; i < 130/JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//DOWN
			for (int i = 0; i < 130/JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y);

				try {
					// 덜 자니까 더 빨리 떨어진다
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isJump = false;
		}).start();

//		new Thread(() -> {
//			for (int i = 0; i <= 65; i++) {
//				y = y - JUMPSPEED;
//				setLocation(x, y);
//				try {
//					Thread.sleep(5);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			
//			}
//			
//			for (int i = 65; i > 0; i--) {
//				y = y + JUMPSPEED;
//				setLocation(x, y);
//				try {
//					Thread.sleep(3);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();

	}
}