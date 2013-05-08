

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TaxCollectorErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5634;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte reason;
    
    public TaxCollectorErrorMessage() { }
    
    public TaxCollectorErrorMessage(byte reason) {
        this.reason = reason;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(reason);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        reason = buf.readByte();
    }
    
}
