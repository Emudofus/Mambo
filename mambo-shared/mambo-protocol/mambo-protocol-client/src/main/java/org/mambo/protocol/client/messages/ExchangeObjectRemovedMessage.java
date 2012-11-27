

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class ExchangeObjectRemovedMessage extends ExchangeObjectMessage {
    public static final int MESSAGE_ID = 5517;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectUID;
    
    public ExchangeObjectRemovedMessage() { }
    
    public ExchangeObjectRemovedMessage(boolean remote, int objectUID) {
        super(remote);
        this.objectUID = objectUID;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(objectUID);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        objectUID = reader.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
    }
    
}
