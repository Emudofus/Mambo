

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class LockableStateUpdateStorageMessage extends LockableStateUpdateAbstractMessage {
    public static final int MESSAGE_ID = 5669;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int mapId;
    public int elementId;
    
    public LockableStateUpdateStorageMessage() { }
    
    public LockableStateUpdateStorageMessage(boolean locked, int mapId, int elementId) {
        super(locked);
        this.mapId = mapId;
        this.elementId = elementId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(mapId);
        writer.writeInt(elementId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        mapId = reader.readInt();
        elementId = reader.readInt();
        if (elementId < 0)
            throw new RuntimeException("Forbidden value on elementId = " + elementId + ", it doesn't respect the following condition : elementId < 0");
    }
    
}
