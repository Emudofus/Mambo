

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeOnHumanVendorRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5772;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int humanVendorId;
    public int humanVendorCell;
    
    public ExchangeOnHumanVendorRequestMessage() { }
    
    public ExchangeOnHumanVendorRequestMessage(int humanVendorId, int humanVendorCell) {
        this.humanVendorId = humanVendorId;
        this.humanVendorCell = humanVendorCell;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(humanVendorId);
        buf.writeInt(humanVendorCell);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        humanVendorId = buf.readInt();
        if (humanVendorId < 0)
            throw new RuntimeException("Forbidden value on humanVendorId = " + humanVendorId + ", it doesn't respect the following condition : humanVendorId < 0");
        humanVendorCell = buf.readInt();
        if (humanVendorCell < 0)
            throw new RuntimeException("Forbidden value on humanVendorCell = " + humanVendorCell + ", it doesn't respect the following condition : humanVendorCell < 0");
    }
    
}
