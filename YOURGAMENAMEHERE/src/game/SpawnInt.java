package game;

import java.util.Random;

@FunctionalInterface

public interface SpawnInt{
	/**
	 * used later in the lambda expression. Spawns objects in random positions
	 * @return
	 */
   Point spawn() ;

}