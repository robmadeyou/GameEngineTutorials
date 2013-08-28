package Tutorial_0_1_Entities;

import com.gmail.robmadeyou.Engine;
import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Screen.GameType;
import com.gmail.robmadeyou.Entity.Npc;
import com.gmail.robmadeyou.Entity.Player;
import com.gmail.robmadeyou.Input.Keyboard;
import com.gmail.robmadeyou.Input.Mouse;

public class B_EnemiesExamle {

	public static void main(String[] args) {

		Screen.setWorldBlockSizeInPixels(32);
		Screen.create(640, 640, "Enemy Example", GameType.SIDE_SCROLLER, false);
		
		Player player = new Player(40, 40, 32, 64);
		Engine.addEntity(player);
		
		/*
		 * Just the same way we created the player entity, but now we create an
		 * enemy entity along with a player entity. By default the enemy will not
		 * do anything
		 */
		Npc enemy = new Npc(40, 40, 20, 40);
		Engine.addEntity(enemy);
		
		Screen.setUpWorld();
		while(!Screen.isAskedToClose()){
			/*
			 * This will create npc's at your mouse location, every tick that the key E is down.
			 *  Try it, it's fun!
			 */
			if(Keyboard.isKeyDown(Keyboard.Key.E)){
				Engine.addEntity(new Npc(Mouse.getX(), Mouse.getY(), 20, 40));
			}
			if(Keyboard.isKeyDown(Keyboard.Key.T)){
				if(enemy.isAStarActive()){
					enemy.setAStar(false);
				}else{
					enemy.setAStar(true);
				}
			}
			Screen.update(60);
			Screen.refresh();
		}
		Screen.destroy();
	}
}
