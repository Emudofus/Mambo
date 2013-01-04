

// Generated on 01/04/2013 14:54:19
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightModifyEffectsDurationMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 6304;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short delta;
    
    public GameActionFightModifyEffectsDurationMessage() { }
    
    public GameActionFightModifyEffectsDurationMessage(short actionId, int sourceId, int targetId, short delta) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.delta = delta;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeShort(delta);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        delta = reader.readShort();
    }
    
}
