package Tutorial_0_4_Layering;

import com.gmail.robmadeyou.Engine;
import com.gmail.robmadeyou.Layer;
import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Effects.Color;
import com.gmail.robmadeyou.Effects.Emitter;
import com.gmail.robmadeyou.Effects.TextureLoader;
import com.gmail.robmadeyou.Entity.Player;
import com.gmail.robmadeyou.Screen.GameType;

public class LayeringDemo {
	
	public static void main(String[] args) {

		Screen.create(640, 640, "AI_Demo", GameType.SIDE_SCROLLER, false);
		
		Player player = new Player(40, 40, 32, 64);
		Engine.addEntity(player);
		/*
		 * By default there are 2 layers at the start
		 * 0 and 1. 
		 * To add more layers do:
		 * Layer.add();
		 * 
		 * This will make the player be appear after the emitter is rendered
		 * as it is on a higher layer. The higher the layer the later it will
		 * be rendered (the more it stands above everyone else)
		 */
		player.setLayer(1);
		/*
		 * When creating a new texture, an integer is returned so we are able
		 * to assign it to an integer and name it (this is done so we can re-use the texture)
		 */
		int flame = TextureLoader.createTexture("flame.png");
		
		Emitter emitter = new Emitter(200, 600, 2000, 0.02f, 0.2f, 2, Color.White, flame);
		Engine.addNewEmitter(emitter);
		
		
		/*
		 * Setting custom particle sizes to make the particles being emitted actually display
		 * a texture
		 */
		emitter.setCustomParticleHeight(20);
		emitter.setCustomParticleWidth(20);
		
		/*
		 * Right now the flame emitter is behind the player, if you remove the "//" from the two
		 * lines of code under this, then you will see the flames now being rendered in front of the player.
		 */
		
		//emitter.setLayer(2);
		//Layer.addLayer();
		
		Screen.setUpWorld();
		while(!Screen.isAskedToClose()){
			Screen.update(60);
			
			emitter.setX(player.getX());
			emitter.setY(player.getY());
			
			Screen.refresh();
		}
		Screen.destroy();
	}
}
