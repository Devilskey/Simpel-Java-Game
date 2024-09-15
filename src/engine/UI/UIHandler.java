package engine.UI;

import engine.abstractions.UserInterface;

import java.util.ArrayList;
import java.util.Optional;

public class UIHandler {
    public ArrayList<UserInterface> UI = new ArrayList<UserInterface>();

    public void add(UserInterface UIElement){
        UI.add(UIElement);
    }

    public Optional<UserInterface> getElementByName(String Name){
        return UI.stream().filter(UserInterface -> UserInterface.Name.equals(Name)).findAny();
    }

    public void Update(){
        for(UserInterface UI: UI){
            UI.Update();
        }
    }

    public void updateElementByName(String Name, UserInterface UpdatedUI){
        Optional<UserInterface> element = getElementByName(Name);
        element.ifPresent(UIelement -> {
            int IndexOfElement = UI.indexOf(UIelement);
            UI.set(IndexOfElement, UpdatedUI);
        });
        }
}
