package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin ���� : ���ȭ�� ����, ĳ���� �߰�
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�.
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		//add(backgroundMap); �̰� ����
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

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
