package Tutorial_0_1_Entities;

import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Screen.GameType;
import com.gmail.robmadeyou.Entity.Enemy;
import com.gmail.robmadeyou.Entity.EntityList;
import com.gmail.robmadeyou.Entity.Player;

public class EnemiesExamle {

	public static void main(String[] args) {

		Screen.create(640, 640, "Name", GameType.SIDE_SCROLLER, false);
		
		Player player = new Player(40, 40, 32, 64);
		EntityList.addEntity(player);
		
		/*
		 * Just the same way we created the player entity, but now we create an
		 * enemy entity along with a player entity. By default the enemy will not
		 * do anything
		 */
		Enemy enemy = new Enemy(40,40, 20, 40);
		EntityList.addEntity(enemy);
		
		Screen.setUpWorld();
		while(!Screen.isAskedToClose()){
			Screen.update(60);
			Screen.refresh();
		}
		Screen.destroy();
	}
}
