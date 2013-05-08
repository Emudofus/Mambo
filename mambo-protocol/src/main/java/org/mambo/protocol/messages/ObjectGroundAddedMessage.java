

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectGroundAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3017;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cellId;
    public short objectGID;
    
    public ObjectGroundAddedMessage() { }
    
    public ObjectGroundAddedMessage(short cellId, short objectGID) {
        this.cellId = cellId;
        this.objectGID = objectGID;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(cellId);
        buf.writeShort(objectGID);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        cellId = buf.readShort();
        if (cellId < 0 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < 0 || cellId > 559");
        objectGID = buf.readShort();
        if (objectGID < 0)
            throw new RuntimeException("Forbidden value on objectGID = " + objectGID + ", it doesn't respect the following condition : objectGID < 0");
    }
    
}
