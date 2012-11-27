

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameServerInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 25;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    public byte status;
    public byte completion;
    public boolean isSelectable;
    public byte charactersCount;
    public double date;
    
    public GameServerInformations() { }
    
    public GameServerInformations(int id, byte status, byte completion, boolean isSelectable, byte charactersCount, double date) {
        this.id = id;
        this.status = status;
        this.completion = completion;
        this.isSelectable = isSelectable;
        this.charactersCount = charactersCount;
        this.date = date;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(id);
        writer.writeByte(status);
        writer.writeByte(completion);
        writer.writeBoolean(isSelectable);
        writer.writeByte(charactersCount);
        writer.writeDouble(date);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readUnsignedShort();
        if (id < 0 || id > 65535)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0 || id > 65535");
        status = reader.readByte();
        if (status < 0)
            throw new RuntimeException("Forbidden value on status = " + status + ", it doesn't respect the following condition : status < 0");
        completion = reader.readByte();
        if (completion < 0)
            throw new RuntimeException("Forbidden value on completion = " + completion + ", it doesn't respect the following condition : completion < 0");
        isSelectable = reader.readBoolean();
        charactersCount = reader.readByte();
        if (charactersCount < 0)
            throw new RuntimeException("Forbidden value on charactersCount = " + charactersCount + ", it doesn't respect the following condition : charactersCount < 0");
        date = reader.readDouble();
    }
    
}
