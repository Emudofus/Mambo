

// Generated on 11/11/2012 19:06:14
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PresetItem implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 354;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short position;
    public int objGid;
    public int objUid;
    
    public PresetItem() { }
    
    public PresetItem(short position, int objGid, int objUid) {
        this.position = position;
        this.objGid = objGid;
        this.objUid = objUid;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedByte(position);
        writer.writeInt(objGid);
        writer.writeInt(objUid);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        position = reader.readUnsignedByte();
        if (position < 0 || position > 255)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 0 || position > 255");
        objGid = reader.readInt();
        if (objGid < 0)
            throw new RuntimeException("Forbidden value on objGid = " + objGid + ", it doesn't respect the following condition : objGid < 0");
        objUid = reader.readInt();
        if (objUid < 0)
            throw new RuntimeException("Forbidden value on objUid = " + objUid + ", it doesn't respect the following condition : objUid < 0");
    }
    
}
