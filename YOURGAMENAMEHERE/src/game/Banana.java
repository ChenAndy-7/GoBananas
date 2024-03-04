package game;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class Banana extends Polygon {
  int count;
  Random random = new Random();

  public Banana(Point[] inShape, Point inPosition, double inRotation) {
	  super(inShape, inPosition, inRotation);
  }
 
  
  /**
   * 
   * @param brush
   * get the points of the apple object from the inShape array and uses it to 
   * paint a apple on the board
   */
  void paint(Graphics brush) {
	Point[] apple = getPoints();
	
	int[] xCoord = new int[apple.length];
	int[] yCoord = new int[apple.length];
	
	for(int i = 0; i < apple.length; i++) {
		xCoord[i] =  (int) apple[i].getX();
		yCoord[i] = (int) apple[i].getY();
	}
	brush.setColor(Color.YELLOW);
	brush.fillPolygon(xCoord, yCoord, apple.length);
  }
  
    
}
  