

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(reason);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        reason = reader.readByte();
    }
    
}
