package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class SnakeGame extends Game{
	static int counter = 0;
	Random random;

	Point a1 = new Point(0, 0);
	Point a2 = new Point(50, 0);
	Point a3 = new Point(50, 50);
	Point a4 = new Point(0, 50);
	Point[] apple = { a1, a2, a3, a4 };
	Point posApp = Apple.spawn();
	Apple apple1 = new Apple(apple, posApp, 0, 0);
	// Point inPositionA = getRandomSpawn();

	Point r1 = new Point(0, 0);
	Point r2 = new Point(50, 0);
	Point r3 = new Point(50, 50);
	Point r4 = new Point(0, 50);
	Point[] rottenApple = { r1, r2, r3, r4 };
	Point posRot = RottonApple.spawn();
	RottonApple rotten1 = new RottonApple(rottenApple, posRot, 0, 4, 0);
	// Point inPositionR = getRandomSpawn();

	Point s1 = new Point(0, 0);
	Point s2 = new Point(50, 0);
	Point s3 = new Point(50, 50);
	Point s4 = new Point(0, 50);
	Point[] snake = { s1, s2, s3, s4 };
	Point posSnake = new Point(300, 300);
	SnakeObj snake1 = new SnakeObj(snake, posSnake, 0);
	
	Polygon[] elements = {apple1, rotten1}; 
	

	public SnakeGame() {
		super("Snake!", 600, 600);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(snake1); 
	}
	


	public void paint(Graphics brush) {
		brush.setColor(Color.GREEN);
		brush.fillRect(0, 0, width, height);
		brush.setColor(Color.WHITE);
		for(int i = 0; i < 600/50; i++) {
			brush.drawLine(i * 50, 0, i * 50, 600);
			brush.drawLine(0, i * 50, 600, i * 50);
		}

		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		counter++;
		brush.setColor(Color.white);
		brush.drawString("Counter is " + counter, 10, 10);
		for(Polygon e : elements) {
			if (snake1.collides(e)) {
				System.out.println("true");
			}
			System.out.println("false");
		}
		apple1.paint(brush);
		rotten1.paint(brush);
		snake1.move();
		snake1.paint(brush);
	}

	public static void main(String[] args) {
		SnakeGame a = new SnakeGame();
		a.repaint();
	}

}