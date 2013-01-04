

// Generated on 01/04/2013 14:54:41
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class OrnamentSelectRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6374;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short ornamentId;
    
    public OrnamentSelectRequestMessage() { }
    
    public OrnamentSelectRequestMessage(short ornamentId) {
        this.ornamentId = ornamentId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(ornamentId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        ornamentId = reader.readShort();
        if (ornamentId < 0)
            throw new RuntimeException("Forbidden value on ornamentId = " + ornamentId + ", it doesn't respect the following condition : ornamentId < 0");
    }
    
}
