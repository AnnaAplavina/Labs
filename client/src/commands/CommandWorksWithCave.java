package commands;

import dragons.DragonCave;

public interface CommandWorksWithCave {
    void setCave(DragonCave cave);
    DragonCave getCave();
}
