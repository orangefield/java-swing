package site.metacoding.bubble.ex03;

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
	}

	public void left() {
		setIcon(playerL); // �ٲ㳢���
		System.out.println("���� �̵�");
		x = x - 10;
		setLocation(x, y); // paintComponent
	}

	public void right() {
		// �޼��� ��� : ������ �ִ� �޼���
		setIcon(playerR);
		System.out.println("������ �̵�");
		x = x + 10; // ������ ���´ϱ� ���� �����̺� x�� ���� ����
		setLocation(x, y); // ���� �ٲٰ� ���� �� ���������
	}
}