package Tutorial_0_2_EnemyAI;

import com.gmail.robmadeyou.Engine;
import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Screen.GameType;
import com.gmail.robmadeyou.Effects.Color;
import com.gmail.robmadeyou.Effects.Emitter;
import com.gmail.robmadeyou.Entity.Npc;
import com.gmail.robmadeyou.Entity.Player;
import com.gmail.robmadeyou.Entity.Npc.EnemyMovement;
import com.gmail.robmadeyou.Input.Mouse;

public class Simple_AI_Demo {

	public static void main(String[] args) {

		Screen.create(640, 640, "AI_Demo", GameType.SIDE_SCROLLER, false);
		
		Player player = new Player(40, 40, 32, 64);
		Engine.addEntity(player);
		
		Npc enemy = new Npc(40,40, 20, 40);
		Engine.addEntity(enemy);
		Screen.setUpWorld();
		
		/*
		 * Giving the enemy orders on movement
		 */
		enemy.orders(EnemyMovement.RIGHT, 20);
		enemy.orders(EnemyMovement.WAIT, 40);
		enemy.orders(EnemyMovement.LEFT, 10);
		enemy.orders(EnemyMovement.JUMP, 20);
		
		while(!Screen.isAskedToClose()){
			Screen.update(60);
			
			
			if(Mouse.leftMouseButtonPressed){
				Engine.addNewEmitter(new Emitter(Mouse.getX(), Mouse.getY(), 2000, 0.02f, 0.2f, 2, Color.Blue));
			}
			
			Screen.refresh();
		}
		Screen.destroy();
	}
}
