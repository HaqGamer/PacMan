package me.ihaq.pacman.desktop;

import me.ihaq.pacman.Main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main(), config);	
		config.width=1000;
		config.height=720;
		config.resizable=false;
	}
}
