

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameServerInformations extends NetworkType {
    public static final short TYPE_ID = 25;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeUShort(id);
        buf.writeByte(status);
        buf.writeByte(completion);
        buf.writeBoolean(isSelectable);
        buf.writeByte(charactersCount);
        buf.writeDouble(date);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readUShort();
        if (id < 0 || id > 65535)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0 || id > 65535");
        status = buf.readByte();
        if (status < 0)
            throw new RuntimeException("Forbidden value on status = " + status + ", it doesn't respect the following condition : status < 0");
        completion = buf.readByte();
        if (completion < 0)
            throw new RuntimeException("Forbidden value on completion = " + completion + ", it doesn't respect the following condition : completion < 0");
        isSelectable = buf.readBoolean();
        charactersCount = buf.readByte();
        if (charactersCount < 0)
            throw new RuntimeException("Forbidden value on charactersCount = " + charactersCount + ", it doesn't respect the following condition : charactersCount < 0");
        date = buf.readDouble();
    }
    
}
