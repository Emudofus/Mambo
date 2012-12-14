

// Generated on 12/14/2012 18:44:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class LockableStateUpdateHouseDoorMessage extends LockableStateUpdateAbstractMessage {
    public static final int MESSAGE_ID = 5668;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int houseId;
    
    public LockableStateUpdateHouseDoorMessage() { }
    
    public LockableStateUpdateHouseDoorMessage(boolean locked, int houseId) {
        super(locked);
        this.houseId = houseId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(houseId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        houseId = reader.readInt();
    }
    
}
