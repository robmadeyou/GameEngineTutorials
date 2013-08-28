package Tutorial_0_2_EnemyAI;

import com.gmail.robmadeyou.Engine;
import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Screen.GameType;
import com.gmail.robmadeyou.Entity.Npc;
import com.gmail.robmadeyou.Entity.Player;

public class Simple_AI_Pathfinding {

	/*
	 * Algorithm isn't perfected yet with the current Engine (as of v0.1.2)
	 * The path finding works a lot better in RPG mode as it was intended to be
	 * used on that game type
	 */
	public static void main(String[] args) {

		Screen.create(640, 640, "AI_Demo", GameType.SIDE_SCROLLER, false);
		
		Player player = new Player(40, 40, 32, 64);
		Engine.addEntity(player);
		
		Npc enemy = new Npc(40,40, 20, 40);
		/*
		 * Here we tell the enemy that it's going to be following the Entity Player
		 */
		enemy.setLogic(true);
		/*
		 * For the A star algorithm we tell the enemy who to target, in this case it's going
		 * to be player
		 */
        enemy.setTargetPlayer(player);
        /*
         * Here we actually enable the A star algorithm for enemy to make sure it follows player
         */
		enemy.setAStar(true);
		
		Engine.addEntity(enemy);
		Screen.setUpWorld();
		
		
		while(!Screen.isAskedToClose()){
			Screen.update(60);
			/*
			 * Nothing really needed in the loop as path finding is being run with the Engine
			 */
			Screen.refresh();
		}
		Screen.destroy();
	}
}
