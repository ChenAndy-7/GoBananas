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
	static int counter = 0;
	Point a1 = new Point(0,0);
	Point a2 = new Point(50,0);
	Point a3 = new Point(50,50);
	Point a4 = new Point(0,50);
	Point[] apple = {a1, a2, a3, a4};
	Point inPosition = new Point(900, 100);


  public Snake() {
    super("YourGameName!",800,600);
    this.setFocusable(true);
	this.requestFocus();
  }
  
	public void paint(Graphics brush) {
    	brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
    	
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	counter++;
    	brush.setColor(Color.white);
    	
    	
    	brush.drawString("Counter is " + counter,10,10);
    	Apple apple1 = new Apple(apple, inPosition, 0, 0 );
		apple1.paint(brush);
  }
  
	public static void main (String[] args) {
   		Snake a = new Snake();
		a.repaint();
	
  }
}
