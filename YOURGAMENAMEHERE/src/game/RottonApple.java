package game;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RottonApple extends Polygon implements ApplesInt{
	 Random random = new Random();
	 Color color;
	 int timer;
	 int count;

  public RottonApple(Point[] inShape, Point inPosition, double inRotation, int timer, int count) {
	  super(inShape, inPosition, inRotation);
	  this.color = Color.black;
	  this.timer = timer;
	  this.count = count;
  }

  public void randomSpawn() {
	  
  }
  /**
   * 
   * @param brush
   * get the points of the apple object from the inShape array and uses it to 
   * paint a apple on the board
   */
  private void paint(Graphics brush) {
		Point[] rottenApple = getPoints();
		
		int[] xCoord = new int[rottenApple.length];
		int[] yCoord = new int[rottenApple.length];
		
		for(int i = 0; i < rottenApple.length; i++) {
			xCoord[i] =  (int) rottenApple[i].getX();
			yCoord[i] = (int) rottenApple[i].getY();
		}
		
		brush.fillPolygon(xCoord, yCoord, rottenApple.length);
	  }
    
}
