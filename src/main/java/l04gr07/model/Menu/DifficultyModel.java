package l04gr07.model.Menu;

import l04gr07.model.Model;

import java.util.Arrays;
import java.util.List;

public class DifficultyModel implements Model {
    private final List<String> options;
    private Boolean running;
    private int currentOption=0;
    public DifficultyModel(){
        this.options= Arrays.asList("Easy", "Medium", "Hard", "Go back");
    }
    public void nextOption() {currentOption++;if (currentOption >= getNumberOptions()) currentOption = 0;}
    public void previousOption() {currentOption--;if (currentOption < 0) currentOption = getNumberOptions()-1;}
    public String getOption(int i) {
        return options.get(i);
    }
    public boolean isSelected(int i) {
        return currentOption == i;
    }

    public int getNumberOptions() {
        return this.options.size();
    }

    public int getCurrentOption() {
        return currentOption;
    }



    public void setRunning(boolean b) {
        running = b;
    }

    public boolean getRunning() {
        return running;
    }
}
