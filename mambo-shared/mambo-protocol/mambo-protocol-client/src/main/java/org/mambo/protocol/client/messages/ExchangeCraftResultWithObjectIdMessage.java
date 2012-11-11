

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeCraftResultWithObjectIdMessage extends ExchangeCraftResultMessage {
    public static final int MESSAGE_ID = 6000;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectGenericId;
    
    public ExchangeCraftResultWithObjectIdMessage() { }
    
    public ExchangeCraftResultWithObjectIdMessage(byte craftResult, int objectGenericId) {
        super(craftResult);
        this.objectGenericId = objectGenericId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(objectGenericId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        objectGenericId = reader.readInt();
        if (objectGenericId < 0)
            throw new RuntimeException("Forbidden value on objectGenericId = " + objectGenericId + ", it doesn't respect the following condition : objectGenericId < 0");
    }
    
}
