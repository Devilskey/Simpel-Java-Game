package engine.Audio;

import javax.print.attribute.standard.Media;
import javax.sound.midi.MidiSystem;
import java.util.HashMap;
import java.util.Map;

public class AudioHandler {
    Map<String, AudioObject> AudioDictionary = new HashMap<String, AudioObject>();

    public void Add(String Name, AudioObject sound){
        AudioDictionary.put(Name, sound);
    }

    public void Remove(String Name){
        AudioDictionary.remove(Name);
    }

    public AudioObject Get(String Name){
        return AudioDictionary.get(Name);
    }

    public void Set(String Name, AudioObject sound){
        AudioDictionary.replace(Name, sound);
    }
}
