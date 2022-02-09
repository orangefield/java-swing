package site.metacoding.bubble.ex05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin ���� : ����
 * 
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	int count = 0; // �� �޼��尡 �� �� ����Ǵ°� �ñ��� �� �̿�

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�.
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		// add(backgroundMap); �̰� ����
		setContentPane(backgroundMap);// �̰ŷ� ���ȭ�� ����

		player = new Player();

		add(player); // ����ȭ��
	}

	// ���� ��� ��Ʈ
	private void initSetting() {
		setSize(1000, 640);
		// getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� absolute layout ����
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X��ư Ŭ���� JVM ���� ����
	}

	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// ������ ����
				System.out.println("Ű���� ������");

				if (e.getKeyCode() == 39) {
					// isRight�� false
					// private�� ���� �� �� ������ ���ͼ���
					player.setRight(false);

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft�� false
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// ������
				// ���� 37, ������ 39, ���� 38, �Ʒ��� 40
				// System.out.println("Ű���� ������:" + e.getKeyCode());

				if (e.getKeyCode() == 39) {
					// Ű���� ������ ���� right �޼��带 �� ������ �� �� ���� �����ϰ� �ʹ�.
					// ������ �ִ��� �ƴ��� ���°� �ʿ��ϴ�.
					// �ȿ����̴°� �����̰� �ؾ� == false �� ��
					if (player.isRight() == false) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isLeft() == false) {
						player.left();
					}
				} else if (e.getKeyCode() == 38) { // �̰��� ������ �̺�Ʈ ���� ����� ���ϴ� �� -> �� ���´�
					if (player.isJump() == false) {
						System.out.println("ī��Ʈ : " + count);
						count++;
						player.jump(); // �޼��� ���ο��� if �б� ó���� �̺�Ʈ ������ ����� �Ǵµ� ������ �ȵǴ� ��
					}

				}

			}
		}); // Ű���� �̺�Ʈ�� ����� JFrame. Ŭ�� �ϳ����ϳ� ���� �׷� �� �ƴ϶�, JF~�� ����̴ϱ� �տ� �� �� �ʿ䰡 ����
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
