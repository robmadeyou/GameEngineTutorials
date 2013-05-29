package Tutorial_0_2_EnemyAI;

import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Screen.GameType;
import com.gmail.robmadeyou.Entity.Enemy;
import com.gmail.robmadeyou.Entity.EntityList;
import com.gmail.robmadeyou.Entity.Player;

public class Simple_AI_Demo {

	public static void main(String[] args) {

		Screen.create(640, 640, "Name", GameType.SIDE_SCROLLER, false);
		
		Player player = new Player(40, 40, 32, 64);
		EntityList.addEntity(player);
		
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
