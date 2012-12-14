

// Generated on 12/14/2012 18:44:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameRolePlayShowActorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5632;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameRolePlayActorInformations informations;
    
    public GameRolePlayShowActorMessage() { }
    
    public GameRolePlayShowActorMessage(GameRolePlayActorInformations informations) {
        this.informations = informations;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(informations.getTypeId());
        informations.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        informations = ProtocolTypeManager.getInstance().build(reader.readShort(), GameRolePlayActorInformations.class);
        informations.deserialize(reader);
    }
    
}
