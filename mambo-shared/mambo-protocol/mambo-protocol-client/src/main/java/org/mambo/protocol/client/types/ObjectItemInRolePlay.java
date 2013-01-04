

// Generated on 01/04/2013 14:54:46
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ObjectItemInRolePlay implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 198;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short cellId;
    public short objectGID;
    
    public ObjectItemInRolePlay() { }
    
    public ObjectItemInRolePlay(short cellId, short objectGID) {
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
