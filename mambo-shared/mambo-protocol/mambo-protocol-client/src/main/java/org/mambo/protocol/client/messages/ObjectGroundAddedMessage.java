

// Generated on 01/04/2013 14:54:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(cellId);
        writer.writeShort(objectGID);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        cellId = reader.readShort();
        if (cellId < 0 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < 0 || cellId > 559");
        objectGID = reader.readShort();
        if (objectGID < 0)
            throw new RuntimeException("Forbidden value on objectGID = " + objectGID + ", it doesn't respect the following condition : objectGID < 0");
    }
    
}
