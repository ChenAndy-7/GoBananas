
public class RottonApple extends Snake{

package game;
import java.awt.Color;

public class RottonApple extends Snake implements ApplesInt{

  Color color;
  int timer;
  int count;

  public RottonApple(int timer, int count) {
    this.color = Color.black;
    this.timer = timer;
    this.count = count;
  }

  public void randomSpawn() {

  }
    
}
