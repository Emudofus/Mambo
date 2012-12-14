

// Generated on 12/14/2012 18:44:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class LockableStateUpdateAbstractMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5671;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean locked;
    
    public LockableStateUpdateAbstractMessage() { }
    
    public LockableStateUpdateAbstractMessage(boolean locked) {
        this.locked = locked;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(locked);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        locked = reader.readBoolean();
    }
    
}
