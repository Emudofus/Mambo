

// Generated on 01/04/2013 14:54:20
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(number);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        number = reader.readUnsignedShort();
        if (number < 0 || number > 65535)
            throw new RuntimeException("Forbidden value on number = " + number + ", it doesn't respect the following condition : number < 0 || number > 65535");
    }
    
}
