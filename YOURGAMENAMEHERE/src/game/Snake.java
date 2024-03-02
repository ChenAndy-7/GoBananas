package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

class Snake extends Game {
	int counter = 0;
	Point a1 = new Point(0, 0);
	Point a2 = new Point(50, 0);
	Point a3 = new Point(50, 50);
	Point a4 = new Point(0, 50);
	Point[] apple = { a1, a2, a3, a4 };
	Point ainPosition = Apple.spawn();
	Apple apple1 = new Apple(apple, ainPosition, 0, 0);


	Point r1 = new Point(0, 0);
	Point r2 = new Point(50, 0);
	Point r3 = new Point(50, 50);
	Point r4 = new Point(0, 50);
	Point[] rApple = { r1, r2, r3, r4 };
	Point rInPosition = RottonApple.spawn();
	RottonApple RApple = new RottonApple(rApple, rInPosition, 0, 4, 0);

	Point s1 = new Point(0, 0);
	Point s2 = new Point(50, 0);
	Point s3 = new Point(50, 50);
	Point s4 = new Point(0, 50);
	Point[] Ssnake = { s1, s2, s3, s4 };
	Point posSnake = new Point(400, 400);

	SnakeObj snake1 = new SnakeObj(Ssnake, posSnake, 0);
	

	public Snake() {
		super("YourGameName!", 800, 800);
		this.setFocusable(true);
		this.requestFocus();
		addKeyListener(snake1);
		setFocusTraversalKeysEnabled(false);
	}

	public void paint(Graphics brush) {
		brush.setColor(Color.GREEN);
		brush.fillRect(0, 0, width, height);

		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		counter++;
		brush.setColor(Color.white);
		brush.drawString("Counter is " + counter, 10, 10);


		apple1.paint(brush);
		
		RApple.paint(brush);

		snake1.move();
		snake1.paint(brush);
		
		eaten();

		
		if (isGameOver()) {
			brush.drawString("Game Over, Score: " + counter, 400, 400);
			
		}
	}
	public void eaten( ) {
		if (snake1.collides(apple1)) {
			Apple.spawn();
			counter++;
			System.out.println("true");
		} else System.out.println("fasle");
	}
	
	public boolean isGameOver() {
		boolean body = false;
		boolean rApple = false;
		boolean border = false;
		
		if (body == true || rApple == true || border == true) {
			return true;
		}
		return false;
	}
	
	
	

	public static void main(String[] args) {
		Snake a = new Snake();
		a.repaint();

	}

}
