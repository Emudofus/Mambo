

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class MapObstacle implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 200;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short obstacleCellId;
    public byte state;
    
    public MapObstacle() { }
    
    public MapObstacle(short obstacleCellId, byte state) {
        this.obstacleCellId = obstacleCellId;
        this.state = state;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(obstacleCellId);
        writer.writeByte(state);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        obstacleCellId = reader.readShort();
        if (obstacleCellId < 0 || obstacleCellId > 559)
            throw new RuntimeException("Forbidden value on obstacleCellId = " + obstacleCellId + ", it doesn't respect the following condition : obstacleCellId < 0 || obstacleCellId > 559");
        state = reader.readByte();
        if (state < 0)
            throw new RuntimeException("Forbidden value on state = " + state + ", it doesn't respect the following condition : state < 0");
    }
    
}
