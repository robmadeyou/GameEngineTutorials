package Tutorial_0_3_Emitters;

import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Screen.GameType;
import com.gmail.robmadeyou.Effects.Color;
import com.gmail.robmadeyou.Effects.Emitter;
import com.gmail.robmadeyou.Entity.EntityList;
import com.gmail.robmadeyou.Entity.Player;
import com.gmail.robmadeyou.Input.Mouse;

public class BasicEmitter {

	public static void main(String[] args) {

		Screen.create(640, 640, "AI_Demo", GameType.SIDE_SCROLLER, false);
		
		Player player = new Player(40, 40, 32, 64);
		EntityList.addEntity(player);
		
		Screen.setUpWorld();
		while(!Screen.isAskedToClose()){
			Screen.update(60);
			
			
			/*
			 * When the left mouse button is pressed
			 * a new emitter is going to appear at the location
			 * of the mouse
			 */
			if(Mouse.leftMouseButtonPressed){
				Emitter.addNewEmitter(new Emitter(Mouse.getX(), Mouse.getY(), 2000, 0.02f, 0.2f, 2, Color.Blue));
			}
			
			Screen.refresh();
		}
		Screen.destroy();
	}
}