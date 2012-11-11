

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightRefreshFighterMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6309;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameContextActorInformations informations;
    
    public GameFightRefreshFighterMessage() { }
    
    public GameFightRefreshFighterMessage(GameContextActorInformations informations) {
        this.informations = informations;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(informations.getTypeId());
        informations.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        informations = ProtocolTypeManager.getInstance().build(reader.readShort(), GameContextActorInformations.class);
        informations.deserialize(reader);
    }
    
}
