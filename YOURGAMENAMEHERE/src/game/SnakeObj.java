package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakeObj extends Polygon implements KeyListener {
	int length;
	Color color;
	Point[] array;
	static boolean up;
	static boolean down;
	static boolean left;
	static boolean right;

	public SnakeObj(Point[] array, Point inPosition, double inRotation) {
		super(array, inPosition, inRotation);
		length = 1;
		color = Color.BLUE;
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
		brush.setColor(Color.BLUE);
		brush.fillPolygon(xCoord, yCoord, snake.length);
	}

	public void move() {
		if (up) {
			this.position.y -= 5 * Math.cos(Math.toRadians(rotation));
			this.position.x -= 5 * Math.sin(Math.toRadians(rotation));
			this.array = this.getPoints();
		}
		if (down) {
			this.position.y += 5 * Math.cos(Math.toRadians(rotation));
			this.position.x += 5 * Math.sin(Math.toRadians(rotation));
			this.array = this.getPoints();
		}
		if (left) {
			this.position.x -= 5 * Math.cos(Math.toRadians(rotation));
			this.array = this.getPoints();
		}
		if (right) {
			this.position.x += 5 * Math.cos(Math.toRadians(rotation));
			this.array = this.getPoints();
		}
	}

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

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
