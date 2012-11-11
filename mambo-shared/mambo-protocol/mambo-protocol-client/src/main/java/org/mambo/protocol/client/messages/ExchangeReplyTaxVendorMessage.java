

// Generated on 11/11/2012 19:17:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeReplyTaxVendorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5787;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int objectValue;
    public int totalTaxValue;
    
    public ExchangeReplyTaxVendorMessage() { }
    
    public ExchangeReplyTaxVendorMessage(int objectValue, int totalTaxValue) {
        this.objectValue = objectValue;
        this.totalTaxValue = totalTaxValue;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(objectValue);
        writer.writeInt(totalTaxValue);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objectValue = reader.readInt();
        if (objectValue < 0)
            throw new RuntimeException("Forbidden value on objectValue = " + objectValue + ", it doesn't respect the following condition : objectValue < 0");
        totalTaxValue = reader.readInt();
        if (totalTaxValue < 0)
            throw new RuntimeException("Forbidden value on totalTaxValue = " + totalTaxValue + ", it doesn't respect the following condition : totalTaxValue < 0");
    }
    
}
