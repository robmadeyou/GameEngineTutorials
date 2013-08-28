package Tutorial_0_3_Emitters;

import com.gmail.robmadeyou.Engine;
import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Effects.Color;
import com.gmail.robmadeyou.Effects.Emitter;
import com.gmail.robmadeyou.Entity.Player;
import com.gmail.robmadeyou.Input.Mouse;
import com.gmail.robmadeyou.Screen.GameType;

public class FollowingEmitter {
	public static void main(String[] args) {
		Screen.create(640, 640, "AI_Demo", GameType.SIDE_SCROLLER, false);
		Emitter emitter = new Emitter(Mouse.getX(), Mouse.getY(), 2000, 0.02f, 0.2f, 2, Color.Yellow);
		/*
		 * As most objects in the game engine, they have to be added to the update 
		 * list, without this the emitter would be created but nothing would get
		 * rendered
		 */
		Engine.addNewEmitter(emitter);
		while(!Screen.isAskedToClose()){
			Screen.update(60);
			/*
			 * Here we set the location of the emitter to the location of the mouse
			 * this way it looks like the mouse has a trail following it
			 */
			emitter.setX(Mouse.getX());
			emitter.setY(Mouse.getY());
			Screen.refresh();
		}
		Screen.destroy();
	}
}
