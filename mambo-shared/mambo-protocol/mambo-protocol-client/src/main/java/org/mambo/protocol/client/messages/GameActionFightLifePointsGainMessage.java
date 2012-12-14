

// Generated on 12/14/2012 18:44:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightLifePointsGainMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 6311;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short delta;
    
    public GameActionFightLifePointsGainMessage() { }
    
    public GameActionFightLifePointsGainMessage(short actionId, int sourceId, int targetId, short delta) {
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
        if (delta < 0)
            throw new RuntimeException("Forbidden value on delta = " + delta + ", it doesn't respect the following condition : delta < 0");
    }
    
}
