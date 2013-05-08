

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectItemInRolePlay extends NetworkType {
    public static final short TYPE_ID = 198;
    
    @Override
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
