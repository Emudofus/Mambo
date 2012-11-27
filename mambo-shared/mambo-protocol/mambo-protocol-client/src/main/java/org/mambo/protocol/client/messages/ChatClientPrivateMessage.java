

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class ChatClientPrivateMessage extends ChatAbstractClientMessage {
    public static final int MESSAGE_ID = 851;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String receiver;
    
    public ChatClientPrivateMessage() { }
    
    public ChatClientPrivateMessage(String content, String receiver) {
        super(content);
        this.receiver = receiver;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(receiver);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        receiver = reader.readString();
    }
    
}
