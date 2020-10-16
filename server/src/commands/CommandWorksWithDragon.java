package commands;

import dragons.Dragon;

public interface CommandWorksWithDragon {
    void setDragon(Dragon dragon);
    Dragon getDragon();
}
