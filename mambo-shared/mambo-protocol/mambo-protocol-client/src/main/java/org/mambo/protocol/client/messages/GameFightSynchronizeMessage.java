

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(fighters.length);
        for (GameFightFighterInformations entry : fighters) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        fighters = new GameFightFighterInformations[limit];
        for (int i = 0; i < limit; i++) {
            fighters[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), GameFightFighterInformations.class);
            fighters[i].deserialize(reader);
        }
    }
    
}
