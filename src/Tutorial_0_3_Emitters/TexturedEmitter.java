package Tutorial_0_3_Emitters;

import com.gmail.robmadeyou.Layer;
import com.gmail.robmadeyou.Screen;
import com.gmail.robmadeyou.Effects.Color;
import com.gmail.robmadeyou.Effects.Emitter;
import com.gmail.robmadeyou.Effects.TextureLoader;
import com.gmail.robmadeyou.Entity.Enemy;
import com.gmail.robmadeyou.Entity.EntityList;
import com.gmail.robmadeyou.Entity.Player;
import com.gmail.robmadeyou.Screen.GameType;

public class TexturedEmitter {
	
	public static void main(String[] args) {

		Screen.create(640, 640, "AI_Demo", GameType.SIDE_SCROLLER, false);
		
		Player player = new Player(40, 40, 32, 64);
		EntityList.addEntity(player);
		
		/*
		 * When creating a new texture, an integer is returned so we are able
		 * to assign it to an integer and name it (this is done so we can re-use the texture)
		 */
		int flame = TextureLoader.createTexture("flame.png");
		
		Emitter emitter = new Emitter(200, 600, 2000, 0.02f, 0.2f, 2, Color.White, flame);
		Emitter.addNewEmitter(emitter);
		player.setLayer(1);
		/*
		 * Setting custom particle sizes to make the particles being emitted actually display
		 * a texture
		 */
		emitter.setCustomParticleHeight(20);
		emitter.setCustomParticleWidth(20);
		
		Screen.setUpWorld();
		while(!Screen.isAskedToClose()){
			Screen.update(60);
			
			
			
			Screen.refresh();
		}
		Screen.destroy();
	}
}
