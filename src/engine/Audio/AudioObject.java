package engine.Audio;

import engine.Debugger.Logger;
import engine.Enums.LogLevel;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioObject implements IAudioObject {
    protected final File AudioFile;
    protected Clip AudioClip;

    public AudioObject(String AudioFilePath) {
        AudioFile = new File(AudioFilePath);
        if(!AudioFile.exists()) {
            Logger.Log(LogLevel.Error, "AudioFile not found at path: " + AudioFilePath);
            return;
        }
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(AudioFile);
            AudioClip = AudioSystem.getClip();
            AudioClip.open(sound);

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            Logger.Log(LogLevel.Error, e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void PlaySound() {
        if(AudioClip == null){
            Logger.Log(LogLevel.Error, "Audio initialization failed");
            return;
        }

        AudioClip.stop();
        AudioClip.flush();
        AudioClip.setFramePosition(0);
        AudioClip.start();
    }

    @Override
    public void StopSound() {
        AudioClip.stop();

    }

}
