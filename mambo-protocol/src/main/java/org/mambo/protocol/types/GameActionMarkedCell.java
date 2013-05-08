

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionMarkedCell extends NetworkType {
    public static final short TYPE_ID = 85;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeShort(cellId);
        buf.writeByte(zoneSize);
        buf.writeInt(cellColor);
        buf.writeByte(cellsType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        cellId = buf.readShort();
        if (cellId < 0 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < 0 || cellId > 559");
        zoneSize = buf.readByte();
        cellColor = buf.readInt();
        cellsType = buf.readByte();
    }
    
}
