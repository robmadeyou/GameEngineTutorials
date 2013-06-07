package Tutorial_0_2_EnemyAI;

import com.gmail.robmadeyou.Layer;
import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Screen.GameType;
import com.gmail.robmadeyou.Effects.Color;
import com.gmail.robmadeyou.Effects.Emitter;
import com.gmail.robmadeyou.Entity.Enemy;
import com.gmail.robmadeyou.Entity.Enemy.EnemyMovement;
import com.gmail.robmadeyou.Entity.EntityList;
import com.gmail.robmadeyou.Entity.Player;
import com.gmail.robmadeyou.Input.Mouse;

public class Simple_AI_Demo {

	public static void main(String[] args) {

		Screen.create(640, 640, "AI_Demo", GameType.RPG_STYLE, false);
		
		Player player = new Player(40, 40, 32, 64);
		Screen.setWorldDimensionsInBlocks(100, 20);
		EntityList.addEntity(player);
		
		Enemy enemy = new Enemy(40,40, 20, 40);
		EntityList.addEntity(enemy);
		Screen.setUpWorld();
		
		Layer.addLayer();
		player.setLayer(1);
		enemy.orders(EnemyMovement.RIGHT, 20);
		enemy.orders(EnemyMovement.WAIT, 100);
		enemy.orders(EnemyMovement.LEFT, 10);
		enemy.orders(EnemyMovement.RIGHT, 20);
		while(!Screen.isAskedToClose()){
			Screen.update(60);
			
			
			if(Mouse.leftMouseButtonPressed){
				Emitter.addNewEmitter(new Emitter(Mouse.getX(), Mouse.getY(), 2000, 0.02f, 0.2f, 2, Color.Blue));
			}
			
			Screen.refresh();
		}
		Screen.destroy();
	}
}
