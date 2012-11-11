

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeObjectRemovedFromBagMessage extends ExchangeObjectMessage {
    public static final int MESSAGE_ID = 6010;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectUID;
    
    public ExchangeObjectRemovedFromBagMessage() { }
    
    public ExchangeObjectRemovedFromBagMessage(boolean remote, int objectUID) {
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
