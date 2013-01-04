

// Generated on 01/04/2013 14:54:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
