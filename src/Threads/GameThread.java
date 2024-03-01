package Threads;

import Handlers.SceneManager;
import Statics.GameData;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameThread extends Thread{
    public void run(){
        while(true) {
            long timeLastFrame = System.nanoTime();

            System.out.println("FPS: " + GameData.fps);
            System.out.println("Graphics DeltaTime: " + GameData.DeltaTime);
            System.out.println("Game DeltaTime: " +  GameData.GameThreadDeltaTime);

            SceneManager.SceneLoaded.Update();

            GameData.GameThreadDeltaTime = (float) 1000 / (System.nanoTime() -  timeLastFrame);
        }
    }
}
