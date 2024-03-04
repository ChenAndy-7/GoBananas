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

class GoBananas extends Game {
	static int score = 0;
	Random random;

	Point a1 = new Point(0, 0);
	Point a2 = new Point(25, 0);
	Point a3 = new Point(25, 50);
	Point a4 = new Point(0, 50);
	Point[] banana = { a1, a2, a3, a4 };
	
	/**
	 * lambda expression that uses the functional interface SpawnInt and spawns 
	 * the banana object at a random spot on the canvas
	 */
	SpawnInt bananaSpawn = () -> {
		Random random = new Random();
		double xpos = random.nextInt(540);
		double ypos = random.nextInt(540);
		Point pos = new Point(xpos, ypos);
		return pos;
	};
	Point posBanana = bananaSpawn.spawn();
	Banana banana1 = new Banana(banana, posBanana, 0);

	/**
	 * lambda expression that uses the functional interface SpawnInt and spawns 
	 * the rock object at a random spot on the canvas
	 */
	Point r1 = new Point(0, 0);
	Point r2 = new Point(50, 0);
	Point r3 = new Point(50, 50);
	Point r4 = new Point(0, 50);
	Point[] rock = { r1, r2, r3, r4 };
	SpawnInt rockSpawn = () -> {
		Random random = new Random();
		double xpos = random.nextInt(550);
		double ypos = random.nextInt(550);
		Point pos = new Point(xpos, ypos);
		return pos;
	};
	Point posRock = rockSpawn.spawn();
	Rock rock1 = new Rock(rock, posRock, 0, 4, 0);

	
	/**
	 * creates a monkey object
	 */
	Point s1 = new Point(0, 0);
	Point s2 = new Point(60, 0);
	Point s3 = new Point(60, 20);
	Point s4 = new Point(50, 20);
	Point s5 = new Point(50, 40);
	Point s6 = new Point(40, 40);
	Point s7 = new Point(40, 50);
	Point s8 = new Point(50, 50);
	Point s9 = new Point(50, 60);
	Point s10 = new Point(40, 60);
	Point s11 = new Point(40, 80);
	Point s12 = new Point(35, 80);
	Point s13 = new Point(35, 70);
	Point s14 = new Point(25, 70);
	Point s15 = new Point(25, 80);
	Point s16 = new Point(20, 80);
	Point s17 = new Point(20, 60);
	Point s18 = new Point(10, 60);
	Point s19 = new Point(10, 50);
	Point s20 = new Point(20, 50);
	Point s21 = new Point(20, 40);
	Point s22 = new Point(10, 40);
	Point s23 = new Point(10, 20);
	Point s24 = new Point(0, 20);

	Point[] monkey = { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13,
			s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24 };
	Point posMon = new Point(300, 300);
	MonekeyObj monkey1 = new MonekeyObj(monkey, posMon, 0);

	Polygon[] elements = { banana1, rock1 };

	/**
	 * initializes the GameLogic object for future use
	 */
	GameLogic gamelogic = new GameLogic();

	public GoBananas() {
		super("GoBananas!", 600, 600);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(monkey1);
	}

	/**
	 * paints and sets the canvas the the desired size as well as painting all
	 *  the object on the canvas. The scoreboard is also painted in the top right
	 *  corner. constantly updates all the objects to the correct coordinates.
	 */
	public void paint(Graphics brush) {
		brush.setColor(Color.GREEN);
		brush.fillRect(0, 0, width, height);
		brush.setColor(Color.WHITE);

		if (gamelogic.isGameOver()) {
			GameMessage anon = new GameMessage() {
				public String message(int score) {
					return "Game Over Score: " + score;
				}
			};
			brush.setColor(Color.BLACK);
			brush.drawString(anon.message(score), 225, 300);
		} else {
			brush.setColor(Color.BLACK);
			brush.drawString(scoreboard.getScore(score), 500, 10);
			gamelogic.update();
			banana1.paint(brush);
			rock1.paint(brush);
			monkey1.move();
			monkey1.paint(brush);

		}
	}

	/**
	 * inner class that stores all the gamelogic of this game
	 */
	public class GameLogic {

		/**
		 * constructor for the GameLogic object
		 */
		public GameLogic() {

		}

		/**
		 * checks to see if the game is over by checking if the x and y 
		 * coordinates of the monkey is out of bounds of the canvas or if the 
		 * monkey is on the rock. returns true if this is the case and false if 
		 * not.
		 * @return boolean
		 */
		public boolean isGameOver() {
			boolean answer = false;
			int xCoord1 = (int) monkey1.position.getX();
			int yCoord1 = (int) monkey1.position.getY();

			if (xCoord1 >= 600 || yCoord1 >= 600 || xCoord1 <= 0
					|| yCoord1 <= 0) {
				answer = true;
				return answer;
			}

			for (Polygon e : elements) {
				if (e instanceof Rock && monkey1.collides(e)) {
					answer = true;
					return answer;
				}
			}
			return answer;
		}

		/**
		 * checks to see if the rock is spawned on top of the apple. if it is
		 * the rock will respawn somewhere else.
		 */
		public void checkRockSpawn() {
			for (Polygon e : elements) {
				if (e instanceof Banana && rock1.collides(e)) {
					rock1.position = rockSpawn.spawn();
				}
			}
		}

		/**
		 * updates the game with all the necessary information including if the 
		 * monkey has collected another banana and the speed of the monkey. If 
		 * another banana has been collected, the banana and the rock will spawn 
		 * in a different position
		 */
		public void update() {
			for (Polygon e : elements) {
				if (e instanceof Banana && monkey1.collides(e)) {
					banana1.position = bananaSpawn.spawn();
					rock1.position = rockSpawn.spawn();
					score++;
					monkey1.speed *= 1.5;
				}
			}
		}

	}

	/**
	 *  object that is places on the top right corner of the canvas
	 */
	public class scoreboard {
		/**
		 * takes in the score parameter and uses it when displaying the score of
		 * the game
		 * @param score
		 * @return String
		 */
		public static String getScore(int score) {
			return "Score: " + score;
		}
	}

	public static void main(String[] args) {
		GoBananas a = new GoBananas();
		a.repaint();
	}

}