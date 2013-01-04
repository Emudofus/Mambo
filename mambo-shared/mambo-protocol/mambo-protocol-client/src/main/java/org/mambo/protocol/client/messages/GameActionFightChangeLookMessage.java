

// Generated on 01/04/2013 14:54:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightChangeLookMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5532;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public EntityLook entityLook;
    
    public GameActionFightChangeLookMessage() { }
    
    public GameActionFightChangeLookMessage(short actionId, int sourceId, int targetId, EntityLook entityLook) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.entityLook = entityLook;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        entityLook.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        entityLook = new EntityLook();
        entityLook.deserialize(reader);
    }
    
}
