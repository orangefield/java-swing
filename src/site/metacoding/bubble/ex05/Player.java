package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin ���� : ����!
 */

public class Player extends JLabel {
	private int x;
	private int y;

	private ImageIcon playerR, playerL; // ���� ���� �ִ� �÷��̾�

	private boolean isRight;
	private boolean isLeft;
	private boolean isJump; // ���� ����(up, down�� ��� ����)

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
		setLocation(x, y); // paintComponentȣ������ : ��� label �ٽ� �׷���

		isRight = false; // ����Ʈ�� false, Ű���� ������ ���� true
		isLeft = false;
		isJump = false;
	}

	public void left() {
		isLeft = true;
		setIcon(playerL); // �ٲ㳢���
		System.out.println("���� �̵�");

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
		// �޼��� ��� : ������ �ִ� �޼���
		isRight = true; // Ű���带 �� �� �ٽ� false
		setIcon(playerR);
		System.out.println("������ �̵�");

		new Thread(() -> {
			while (isRight) {
				// �ߴ��� ������ȴ� ���̰� -> �۾������ڿ��� ���ͷ�Ʈ
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(15);
					// �ߴµ��� �� ������ -> while�� ������ ������
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		; // ������ ��ü ���� ��Ÿ��

	}

	public void jump() {
		System.out.println("���� ����");
		isJump = true;
		// up ���� : sleep(5) -> for

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
					// �� �ڴϱ� �� ���� ��������
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