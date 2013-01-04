

// Generated on 01/04/2013 14:54:21
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterSelectedForceMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6068;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int id;
    
    public CharacterSelectedForceMessage() { }
    
    public CharacterSelectedForceMessage(int id) {
        this.id = id;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
        if (id < 1 || id > 2147483647)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 1 || id > 2147483647");
    }
    
}
