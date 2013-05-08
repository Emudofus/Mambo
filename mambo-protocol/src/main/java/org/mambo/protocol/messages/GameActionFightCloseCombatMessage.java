

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightCloseCombatMessage extends AbstractGameActionFightTargetedAbilityMessage {
    public static final int MESSAGE_ID = 6116;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int weaponGenericId;
    
    public GameActionFightCloseCombatMessage() { }
    
    public GameActionFightCloseCombatMessage(short actionId, int sourceId, int targetId, short destinationCellId, byte critical, boolean silentCast, int weaponGenericId) {
        super(actionId, sourceId, targetId, destinationCellId, critical, silentCast);
        this.weaponGenericId = weaponGenericId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(weaponGenericId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        weaponGenericId = buf.readInt();
        if (weaponGenericId < 0)
            throw new RuntimeException("Forbidden value on weaponGenericId = " + weaponGenericId + ", it doesn't respect the following condition : weaponGenericId < 0");
    }
    
}
