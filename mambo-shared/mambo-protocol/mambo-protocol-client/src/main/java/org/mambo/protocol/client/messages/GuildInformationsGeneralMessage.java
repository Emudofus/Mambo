

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, enabled);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, abandonnedPaddock);
        writer.writeUnsignedByte(flag1);
        writer.writeUnsignedByte(level);
        writer.writeDouble(expLevelFloor);
        writer.writeDouble(experience);
        writer.writeDouble(expNextLevelFloor);
        writer.writeInt(creationDate);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        enabled = BooleanByteWrapper.getFlag(flag1, 0);
        abandonnedPaddock = BooleanByteWrapper.getFlag(flag1, 1);
        level = reader.readUnsignedByte();
        if (level < 0 || level > 255)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0 || level > 255");
        expLevelFloor = reader.readDouble();
        if (expLevelFloor < 0)
            throw new RuntimeException("Forbidden value on expLevelFloor = " + expLevelFloor + ", it doesn't respect the following condition : expLevelFloor < 0");
        experience = reader.readDouble();
        if (experience < 0)
            throw new RuntimeException("Forbidden value on experience = " + experience + ", it doesn't respect the following condition : experience < 0");
        expNextLevelFloor = reader.readDouble();
        if (expNextLevelFloor < 0)
            throw new RuntimeException("Forbidden value on expNextLevelFloor = " + expNextLevelFloor + ", it doesn't respect the following condition : expNextLevelFloor < 0");
        creationDate = reader.readInt();
        if (creationDate < 0)
            throw new RuntimeException("Forbidden value on creationDate = " + creationDate + ", it doesn't respect the following condition : creationDate < 0");
    }
    
}
