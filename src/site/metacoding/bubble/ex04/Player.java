package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin 플레이어는 좌우 이동이 가능하다 : x 좌표 있음 점프가 가능하다 : y 좌표 있음 방울 발사 : 나중에
 *         생각하자
 * 
 *         플레이어는 Label이다.
 */

public class Player extends JLabel {
	private int x;
	private int y;

	private ImageIcon playerR, playerL; // 우측 보고 있는 플레이어

	private boolean isRight;
	private boolean isLeft;

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
		y = 535;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent호출해줌 : 얘는 label 다시 그려줌

		isRight = false; // 디폴트는 false, 키보드 누르는 순간 true
		isLeft = false;
	}

	public void left() {
		isLeft = true;
		setIcon(playerL); // 바꿔끼우기
		System.out.println("왼쪽 이동");

		new Thread(() -> {
			while (isLeft) {
				x = x - 3;
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
				x = x + 3;
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
}