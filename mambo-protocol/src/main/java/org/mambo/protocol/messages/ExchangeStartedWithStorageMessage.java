

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(storageMaxSlot);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        storageMaxSlot = buf.readInt();
        if (storageMaxSlot < 0)
            throw new RuntimeException("Forbidden value on storageMaxSlot = " + storageMaxSlot + ", it doesn't respect the following condition : storageMaxSlot < 0");
    }
    
}
