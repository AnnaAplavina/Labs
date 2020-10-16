package commands;

import dragons.DragonCollectionManager;

public interface CommandWorksWithColl {
    String execute(DragonCollectionManager coll) throws WrongArgumentException;
}
