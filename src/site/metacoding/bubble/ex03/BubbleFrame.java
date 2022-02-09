package site.metacoding.bubble.ex03;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin ���� : ĳ���� �¿� �̵�
 * 
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

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

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// ������
				// ���� 37, ������ 39, ���� 38, �Ʒ��� 40
				System.out.println("Ű���� ������:" + e.getKeyCode());

				if (e.getKeyCode() == 39) {
					player.right(); // �����ڿ��� right ��������� player�� ���� ������ ��
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.left();
				}

			}
		}); // Ű���� �̺�Ʈ�� ����� JFrame. Ŭ�� �ϳ����ϳ� ���� �׷� �� �ƴ϶�, JF~�� ����̴ϱ� �տ� �� �� �ʿ䰡 ����
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}