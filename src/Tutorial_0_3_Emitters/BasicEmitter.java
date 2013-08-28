package Tutorial_0_3_Emitters;

import com.gmail.robmadeyou.Engine;
import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Screen.GameType;
import com.gmail.robmadeyou.Effects.Color;
import com.gmail.robmadeyou.Effects.Emitter;
import com.gmail.robmadeyou.Input.Mouse;

public class BasicEmitter {
	public static void main(String[] args) {
		Screen.create(640, 640, "Emitters", GameType.SIDE_SCROLLER, false);
		while(!Screen.isAskedToClose()){
			Screen.update(60);
			/*
			 * When the left mouse button is pressed
			 * a new emitter is going to appear at the location
			 * of the mouse
			 */
			if(Mouse.leftMouseButtonPressed){
				Engine.addNewEmitter(new Emitter(Mouse.getX(), Mouse.getY(), 2000, 0.02f, 0.2f, 2, Color.Blue));
			}
			Screen.refresh();
		}
		Screen.destroy();
	}
}