

// Generated on 01/04/2013 14:54:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(weaponGenericId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        weaponGenericId = reader.readInt();
        if (weaponGenericId < 0)
            throw new RuntimeException("Forbidden value on weaponGenericId = " + weaponGenericId + ", it doesn't respect the following condition : weaponGenericId < 0");
    }
    
}
