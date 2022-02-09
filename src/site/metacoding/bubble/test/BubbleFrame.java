package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	// �����
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	// ������Ʈ ����
	private void initObject() {
		// 2. ��ȭ���� ����� ����.
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);

		player = new Player();

		add(player);
	}

	// ���� ����
	private void initSetting() {
		// 1. ���� ��ȭ���� ���
		setSize(1000, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ������
	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// ���� �� ����
				System.out.println("Ű���� ������");

				if (e.getKeyCode() == 39) {
					player.setRight(false);
				} else if (e.getKeyCode() == 37) {
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// ������
				// ���� 37, ������ 39, ���� 38, �Ʒ��� 40
				// System.out.println("Ű���� ������: " + e.getKeyCode());

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
