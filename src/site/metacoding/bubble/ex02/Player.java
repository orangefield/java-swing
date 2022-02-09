package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author kimjungmin 
 * 플레이어는 좌우 이동이 가능하다 : x 좌표 있음 
 * 점프가 가능하다 : y 좌표 있음 
 * 방울 발사 : 나중에 생각하자
 *         
 *         플레이어는 Lable이다.
 */

public class Player extends JLabel {
	private int x;
	private int y;

	private ImageIcon playerR; // 우측 보고 있는 플레이어
	
	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		
		setIcon(playerR);
		setSize(50,50);
		setLocation(x, y); // paintComponent호출해줌 : 얘는 label 다시 그려줌
	}
}