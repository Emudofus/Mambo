

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameActionFightStateChangeMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5569;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short stateId;
    public boolean active;
    
    public GameActionFightStateChangeMessage() { }
    
    public GameActionFightStateChangeMessage(short actionId, int sourceId, int targetId, short stateId, boolean active) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.stateId = stateId;
        this.active = active;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeShort(stateId);
        writer.writeBoolean(active);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        stateId = reader.readShort();
        active = reader.readBoolean();
    }
    
}
