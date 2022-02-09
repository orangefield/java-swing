package site.metacoding.bubble.ex03;

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
	}

	public void left() {
		setIcon(playerL); // 바꿔끼우기
		System.out.println("왼쪽 이동");
		x = x - 10;
		setLocation(x, y); // paintComponent
	}

	public void right() {
		// 메서드 모듈 : 목적이 있는 메서드
		setIcon(playerR);
		System.out.println("오른쪽 이동");
		x = x + 10; // 본인의 상태니까 위의 프라이빗 x에 접근 가능
		setLocation(x, y); // 상태 바꾸고 나서 꼭 세팅해줘야
	}
}