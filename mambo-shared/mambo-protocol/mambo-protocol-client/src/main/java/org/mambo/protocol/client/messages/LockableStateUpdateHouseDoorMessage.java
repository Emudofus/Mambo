

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

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
