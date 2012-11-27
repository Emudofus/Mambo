

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionMarkedCell implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 85;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short cellId;
    public byte zoneSize;
    public int cellColor;
    public byte cellsType;
    
    public GameActionMarkedCell() { }
    
    public GameActionMarkedCell(short cellId, byte zoneSize, int cellColor, byte cellsType) {
        this.cellId = cellId;
        this.zoneSize = zoneSize;
        this.cellColor = cellColor;
        this.cellsType = cellsType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(cellId);
        writer.writeByte(zoneSize);
        writer.writeInt(cellColor);
        writer.writeByte(cellsType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        cellId = reader.readShort();
        if (cellId < 0 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < 0 || cellId > 559");
        zoneSize = reader.readByte();
        cellColor = reader.readInt();
        cellsType = reader.readByte();
    }
    
}
