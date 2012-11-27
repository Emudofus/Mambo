

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class LocalizedChatSmileyMessage extends ChatSmileyMessage {
    public static final int MESSAGE_ID = 6185;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cellId;
    
    public LocalizedChatSmileyMessage() { }
    
    public LocalizedChatSmileyMessage(int entityId, byte smileyId, int accountId, short cellId) {
        super(entityId, smileyId, accountId);
        this.cellId = cellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(cellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        cellId = reader.readShort();
        if (cellId < 0 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < 0 || cellId > 559");
    }
    
}
