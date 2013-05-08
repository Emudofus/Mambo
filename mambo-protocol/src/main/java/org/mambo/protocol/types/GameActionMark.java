

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionMark extends NetworkType {
    public static final short TYPE_ID = 351;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int markAuthorId;
    public int markSpellId;
    public short markId;
    public byte markType;
    public GameActionMarkedCell[] cells;
    
    public GameActionMark() { }
    
    public GameActionMark(int markAuthorId, int markSpellId, short markId, byte markType, GameActionMarkedCell[] cells) {
        this.markAuthorId = markAuthorId;
        this.markSpellId = markSpellId;
        this.markId = markId;
        this.markType = markType;
        this.cells = cells;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(markAuthorId);
        buf.writeInt(markSpellId);
        buf.writeShort(markId);
        buf.writeByte(markType);
        buf.writeUShort(cells.length);
        for (GameActionMarkedCell entry : cells) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        markAuthorId = buf.readInt();
        markSpellId = buf.readInt();
        if (markSpellId < 0)
            throw new RuntimeException("Forbidden value on markSpellId = " + markSpellId + ", it doesn't respect the following condition : markSpellId < 0");
        markId = buf.readShort();
        markType = buf.readByte();
        int limit = buf.readUShort();
        cells = new GameActionMarkedCell[limit];
        for (int i = 0; i < limit; i++) {
            cells[i] = new GameActionMarkedCell();
            cells[i].deserialize(buf);
        }
    }
    
}
