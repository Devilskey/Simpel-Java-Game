package engine.Handlers;

import engine.abstractions.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EntityHandler {

    private final Map<String, Entity> EntityDictionary = new HashMap<String, Entity>();

    public ArrayList<Entity> GetList(){
        return new ArrayList<>(EntityDictionary.values());
    }

    public void add(String Name, Entity entity){
        EntityDictionary.put(Name, entity);
    }

    public void remove(String Name){
        EntityDictionary.remove(Name);
    }

    public Entity get(String Name){
        return EntityDictionary.get(Name);
    }

    public void Initiate(String Name, Entity entity){
        EntityDictionary.put(Name, entity);
    }
}
