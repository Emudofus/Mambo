

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class ChatClientMultiMessage extends ChatAbstractClientMessage {
    public static final int MESSAGE_ID = 861;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte channel;
    
    public ChatClientMultiMessage() { }
    
    public ChatClientMultiMessage(String content, byte channel) {
        super(content);
        this.channel = channel;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(channel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        channel = reader.readByte();
        if (channel < 0)
            throw new RuntimeException("Forbidden value on channel = " + channel + ", it doesn't respect the following condition : channel < 0");
    }
    
}
