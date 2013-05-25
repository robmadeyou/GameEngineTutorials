package Tutorial_0_0;

import com.gmail.robmadeyou.Screen;

//All code in Java is held in classes
public class Main {
	/* In Java the main class is always called main with the arguments String[]args. This is the first 
	 * method Java will look for
	 */
	public static void main (String []args){
	/*Creates a screen with 800 Width, 600 Height, Title being: “Our Screen”, The game mode      
 	* being SIDE_SCROLLER, and in non minimalist mode (Minimilistic mode you set your own 
	* OpenGL parameters, for more customization)
		*/
		Screen.create(800, 600, "Our Screen", Screen.GameType.SIDE_SCROLLER, false);
		/*A while statement to make sure the screen doesn’t just close after being created
		* It’s going to repeat for ever while the boolean isAskedToClose() in the class Screen isn’t 
		* true
		*/
		while(!Screen.isAskedToClose()){
			//Updating the screen. the maximum frame rate is 60.
			Screen.update(60);
			//Refreshing the screen
			Screen.refresh();
		}
	}
}
