

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5513;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte errorType;
    
    public ExchangeErrorMessage() { }
    
    public ExchangeErrorMessage(byte errorType) {
        this.errorType = errorType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(errorType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        errorType = buf.readByte();
    }
    
}
