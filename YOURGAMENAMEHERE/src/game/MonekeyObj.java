package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MonekeyObj extends Polygon implements KeyListener {
	int length;
	Point[] array;
	static boolean up;
	static boolean down;
	static boolean left;
	static boolean right;
	int speed = 2;
	boolean spin;
	
	/**
	 * constructor for the Monkey object
	 * @param array
	 * @param inPosition
	 * @param inRotation
	 */
	public MonekeyObj(Point[] array, Point inPosition, double inRotation) {
		super(array, inPosition, inRotation);
		length = 1;
		
	}

	/**
	 * 
	 * @param brush get the points of the snake object from the inShape array
	 *              and uses it to paint a snake on the board
	 */
	void paint(Graphics brush) {
		Point[] snake = getPoints();

		int[] xCoord = new int[snake.length];
		int[] yCoord = new int[snake.length];

		for (int i = 0; i < snake.length; i++) {
			xCoord[i] = (int) snake[i].getX();
			yCoord[i] = (int) snake[i].getY();
		}

		brush.setColor(Color.getHSBColor(30, (float)0.8, (float)0.45));
		brush.fillPolygon(xCoord, yCoord, snake.length);
		
	}
/**
 * determines how to snake object moves depending on the boolean values
 */
	public void move() {
		
		if (up) {
			this.position.y -= speed * Math.cos(Math.toRadians(rotation));
			this.position.x -= speed * Math.sin(Math.toRadians(rotation));
			this.array = this.getPoints();
		}
		if (down) {
			this.position.y += speed * Math.cos(Math.toRadians(rotation));
			this.position.x += speed * Math.sin(Math.toRadians(rotation));
			this.array = this.getPoints();
		}
		if (left) {
			this.position.x -= speed * Math.cos(Math.toRadians(rotation));
			this.array = this.getPoints();
		}
		if (right) {
			this.position.x += speed * Math.cos(Math.toRadians(rotation));
			this.array = this.getPoints();
		}
		if (spin) {
			rotation += 5;
		}
	}
/**
 * detects which key is pressed and sets the corresponding boolean the true
 * as well as set all others to false
 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			up = true;
			down = false;
			left = false;
			right = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			up = false;
			down = true;
			left = false;
			right = false;
		}
		if (key == KeyEvent.VK_LEFT) {
			up = false;
			down = false;
			left = true;
			right = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			up = false;
			down = false;
			left = false;
			right = true;
		}
		if (key == KeyEvent.VK_SPACE) {
			spin = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			spin = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	

}