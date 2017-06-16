package me.ihaq.pacman.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import me.ihaq.pacman.Main;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "PacMan";
		config.width = 1000;
		config.height = 720;
		config.resizable = false;
		config.addIcon("logo-16.png", FileType.Internal);
		config.addIcon("logo-32.png", FileType.Internal);
		config.addIcon("logo-128.png", FileType.Internal);
		new LwjglApplication(new Main(), config);
	}
}
