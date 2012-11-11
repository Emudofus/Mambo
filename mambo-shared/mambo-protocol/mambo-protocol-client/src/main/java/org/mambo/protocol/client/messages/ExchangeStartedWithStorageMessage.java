

// Generated on 11/11/2012 19:17:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeStartedWithStorageMessage extends ExchangeStartedMessage {
    public static final int MESSAGE_ID = 6236;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int storageMaxSlot;
    
    public ExchangeStartedWithStorageMessage() { }
    
    public ExchangeStartedWithStorageMessage(byte exchangeType, int storageMaxSlot) {
        super(exchangeType);
        this.storageMaxSlot = storageMaxSlot;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(storageMaxSlot);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        storageMaxSlot = reader.readInt();
        if (storageMaxSlot < 0)
            throw new RuntimeException("Forbidden value on storageMaxSlot = " + storageMaxSlot + ", it doesn't respect the following condition : storageMaxSlot < 0");
    }
    
}
