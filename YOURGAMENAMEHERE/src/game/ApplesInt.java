package game;

import java.util.Random;

public interface ApplesInt{
  public static Point spawn() {
	  Random random = new Random(); 
		 double xpos = random.nextInt(600);
		 double ypos = random.nextInt(600);
		 Point pos = new Point(xpos, ypos);
		 return pos;
  }
}