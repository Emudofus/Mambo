

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightFighterLightInformations extends NetworkType {
    public static final short TYPE_ID = 413;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public boolean sex;
    public boolean alive;
    public int id;
    public String name;
    public short level;
    public byte breed;
    
    public GameFightFighterLightInformations() { }
    
    public GameFightFighterLightInformations(boolean sex, boolean alive, int id, String name, short level, byte breed) {
        this.sex = sex;
        this.alive = alive;
        this.id = id;
        this.name = name;
        this.level = level;
        this.breed = breed;
    }
    
    @Override
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, sex);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, alive);
        buf.writeUByte(flag1);
        buf.writeInt(id);
        buf.writeString(name);
        buf.writeShort(level);
        buf.writeByte(breed);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        sex = BooleanByteWrapper.getFlag(flag1, 0);
        alive = BooleanByteWrapper.getFlag(flag1, 1);
        id = buf.readInt();
        name = buf.readString();
        level = buf.readShort();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
        breed = buf.readByte();
    }
    
}
