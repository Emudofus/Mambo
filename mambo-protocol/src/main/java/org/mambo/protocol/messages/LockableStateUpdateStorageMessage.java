

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(mapId);
        buf.writeInt(elementId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        mapId = buf.readInt();
        elementId = buf.readInt();
        if (elementId < 0)
            throw new RuntimeException("Forbidden value on elementId = " + elementId + ", it doesn't respect the following condition : elementId < 0");
    }
    
}
