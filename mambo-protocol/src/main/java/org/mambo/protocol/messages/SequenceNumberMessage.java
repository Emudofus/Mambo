

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SequenceNumberMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6317;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int number;
    
    public SequenceNumberMessage() { }
    
    public SequenceNumberMessage(int number) {
        this.number = number;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(number);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        number = buf.readUShort();
        if (number < 0 || number > 65535)
            throw new RuntimeException("Forbidden value on number = " + number + ", it doesn't respect the following condition : number < 0 || number > 65535");
    }
    
}
