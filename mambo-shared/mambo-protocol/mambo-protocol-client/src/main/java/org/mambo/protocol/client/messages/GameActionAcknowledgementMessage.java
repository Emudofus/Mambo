

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionAcknowledgementMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 957;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean valid;
    public byte actionId;
    
    public GameActionAcknowledgementMessage() { }
    
    public GameActionAcknowledgementMessage(boolean valid, byte actionId) {
        this.valid = valid;
        this.actionId = actionId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(valid);
        writer.writeByte(actionId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        valid = reader.readBoolean();
        actionId = reader.readByte();
    }
    
}
