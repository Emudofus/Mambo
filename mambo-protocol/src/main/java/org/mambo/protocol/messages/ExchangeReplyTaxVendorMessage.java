

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(objectValue);
        buf.writeInt(totalTaxValue);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectValue = buf.readInt();
        if (objectValue < 0)
            throw new RuntimeException("Forbidden value on objectValue = " + objectValue + ", it doesn't respect the following condition : objectValue < 0");
        totalTaxValue = buf.readInt();
        if (totalTaxValue < 0)
            throw new RuntimeException("Forbidden value on totalTaxValue = " + totalTaxValue + ", it doesn't respect the following condition : totalTaxValue < 0");
    }
    
}
