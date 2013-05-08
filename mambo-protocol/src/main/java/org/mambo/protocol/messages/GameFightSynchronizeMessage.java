

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightSynchronizeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5921;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameFightFighterInformations[] fighters;
    
    public GameFightSynchronizeMessage() { }
    
    public GameFightSynchronizeMessage(GameFightFighterInformations[] fighters) {
        this.fighters = fighters;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(fighters.length);
        for (GameFightFighterInformations entry : fighters) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        fighters = new GameFightFighterInformations[limit];
        for (int i = 0; i < limit; i++) {
            fighters[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            fighters[i].deserialize(buf);
        }
    }
    
}
