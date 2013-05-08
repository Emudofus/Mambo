

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TaxCollectorMovementRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5915;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int collectorId;
    
    public TaxCollectorMovementRemoveMessage() { }
    
    public TaxCollectorMovementRemoveMessage(int collectorId) {
        this.collectorId = collectorId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(collectorId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        collectorId = buf.readInt();
    }
    
}
