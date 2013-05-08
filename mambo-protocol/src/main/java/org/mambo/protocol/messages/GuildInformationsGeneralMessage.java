

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildInformationsGeneralMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5557;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enabled;
    public boolean abandonnedPaddock;
    public short level;
    public double expLevelFloor;
    public double experience;
    public double expNextLevelFloor;
    public int creationDate;
    
    public GuildInformationsGeneralMessage() { }
    
    public GuildInformationsGeneralMessage(boolean enabled, boolean abandonnedPaddock, short level, double expLevelFloor, double experience, double expNextLevelFloor, int creationDate) {
        this.enabled = enabled;
        this.abandonnedPaddock = abandonnedPaddock;
        this.level = level;
        this.expLevelFloor = expLevelFloor;
        this.experience = experience;
        this.expNextLevelFloor = expNextLevelFloor;
        this.creationDate = creationDate;
    }
    
    @Override
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, enabled);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, abandonnedPaddock);
        buf.writeUByte(flag1);
        buf.writeUByte(level);
        buf.writeDouble(expLevelFloor);
        buf.writeDouble(experience);
        buf.writeDouble(expNextLevelFloor);
        buf.writeInt(creationDate);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        enabled = BooleanByteWrapper.getFlag(flag1, 0);
        abandonnedPaddock = BooleanByteWrapper.getFlag(flag1, 1);
        level = buf.readUByte();
        if (level < 0 || level > 255)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0 || level > 255");
        expLevelFloor = buf.readDouble();
        if (expLevelFloor < 0)
            throw new RuntimeException("Forbidden value on expLevelFloor = " + expLevelFloor + ", it doesn't respect the following condition : expLevelFloor < 0");
        experience = buf.readDouble();
        if (experience < 0)
            throw new RuntimeException("Forbidden value on experience = " + experience + ", it doesn't respect the following condition : experience < 0");
        expNextLevelFloor = buf.readDouble();
        if (expNextLevelFloor < 0)
            throw new RuntimeException("Forbidden value on expNextLevelFloor = " + expNextLevelFloor + ", it doesn't respect the following condition : expNextLevelFloor < 0");
        creationDate = buf.readInt();
        if (creationDate < 0)
            throw new RuntimeException("Forbidden value on creationDate = " + creationDate + ", it doesn't respect the following condition : creationDate < 0");
    }
    
}
