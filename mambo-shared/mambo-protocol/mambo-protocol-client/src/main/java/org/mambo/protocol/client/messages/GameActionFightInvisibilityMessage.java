

// Generated on 12/14/2012 18:44:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightInvisibilityMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5821;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public byte state;
    
    public GameActionFightInvisibilityMessage() { }
    
    public GameActionFightInvisibilityMessage(short actionId, int sourceId, int targetId, byte state) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.state = state;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeByte(state);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        state = reader.readByte();
    }
    
}
