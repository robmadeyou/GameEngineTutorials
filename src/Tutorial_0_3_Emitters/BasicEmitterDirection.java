package Tutorial_0_3_Emitters;

import com.gmail.robmadeyou.Engine;
import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Screen.GameType;
import com.gmail.robmadeyou.Effects.Color;
import com.gmail.robmadeyou.Effects.Emitter;
import com.gmail.robmadeyou.Effects.Emitter.MovementDirection;
import com.gmail.robmadeyou.Input.Mouse;

public class BasicEmitterDirection {
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
				/*
				 * We can declare an emitter type like this as the method
				 * Engine.addNewEmitter returns the emitter created, thus allowing us to set properties
				 * to the emitter
				 * 
				 * Parameters are:(double) x location,(double) y location, (int) number of particles in emitter,
				 * 				(float) decrease speed, (float) movement speed, 
				 */
				Emitter em = Engine.addNewEmitter(new Emitter(Mouse.getX(), Mouse.getY(), 40, 0.02f, 0.5f, 2, Color.Yellow));
				/*
				 * This will tell the emitter how it should emit particles, options are: UP, DOWN, LEFT, RIGHT, OUT.
				 */
				em.setMovementDirection(MovementDirection.DOWN);
			}
			Screen.refresh();
		}
		Screen.destroy();
	}
}
