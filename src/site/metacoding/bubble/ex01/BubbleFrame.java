package site.metacoding.bubble.ex01;

import javax.swing.JFrame;

/**
 * 
 * @author kimjungmin
 *
 */

public class BubbleFrame extends JFrame {

	public BubbleFrame() {
	initObject();
	initSetting();
	setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.
	}
	
	// new 하는 것
	private void initObject() {
				
	}
	// 각종 모든 세트
	private void initSetting() {
		
	}
	public static void main(String[] args) {
		new BubbleFrame();
	}

}
