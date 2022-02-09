package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin �÷��̾�� �¿� �̵��� �����ϴ� : x ��ǥ ���� ������ �����ϴ� : y ��ǥ ���� ��� �߻� : ���߿�
 *         ��������
 * 
 *         �÷��̾�� Label�̴�.
 */

public class Player extends JLabel {
	private int x;
	private int y;

	private ImageIcon playerR, playerL; // ���� ���� �ִ� �÷��̾�

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
		setLocation(x, y); // paintComponentȣ������ : ��� label �ٽ� �׷���

		isRight = false; // ����Ʈ�� false, Ű���� ������ ���� true
		isLeft = false;
	}

	public void left() {
		isLeft = true;
		setIcon(playerL); // �ٲ㳢���
		System.out.println("���� �̵�");

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
		// �޼��� ��� : ������ �ִ� �޼���
		isRight = true; // Ű���带 �� �� �ٽ� false
		setIcon(playerR);
		System.out.println("������ �̵�");

		new Thread(() -> {
			while (isRight) {
				// �ߴ��� ������ȴ� ���̰� -> �۾������ڿ��� ���ͷ�Ʈ
				x = x + 3;
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
}