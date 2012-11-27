

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionMark implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 351;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(markAuthorId);
        writer.writeInt(markSpellId);
        writer.writeShort(markId);
        writer.writeByte(markType);
        writer.writeUnsignedShort(cells.length);
        for (GameActionMarkedCell entry : cells) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        markAuthorId = reader.readInt();
        markSpellId = reader.readInt();
        if (markSpellId < 0)
            throw new RuntimeException("Forbidden value on markSpellId = " + markSpellId + ", it doesn't respect the following condition : markSpellId < 0");
        markId = reader.readShort();
        markType = reader.readByte();
        int limit = reader.readUnsignedShort();
        cells = new GameActionMarkedCell[limit];
        for (int i = 0; i < limit; i++) {
            cells[i] = new GameActionMarkedCell();
            cells[i].deserialize(reader);
        }
    }
    
}
