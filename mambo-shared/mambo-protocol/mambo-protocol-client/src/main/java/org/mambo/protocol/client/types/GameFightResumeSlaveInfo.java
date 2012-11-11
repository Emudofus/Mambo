

// Generated on 11/11/2012 19:06:12
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightResumeSlaveInfo implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 364;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int slaveId;
    public GameFightSpellCooldown[] spellCooldowns;
    public byte summonCount;
    public byte bombCount;
    
    public GameFightResumeSlaveInfo() { }
    
    public GameFightResumeSlaveInfo(int slaveId, GameFightSpellCooldown[] spellCooldowns, byte summonCount, byte bombCount) {
        this.slaveId = slaveId;
        this.spellCooldowns = spellCooldowns;
        this.summonCount = summonCount;
        this.bombCount = bombCount;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(slaveId);
        writer.writeUnsignedShort(spellCooldowns.length);
        for (GameFightSpellCooldown entry : spellCooldowns) {
            entry.serialize(writer);
        }
        writer.writeByte(summonCount);
        writer.writeByte(bombCount);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        slaveId = reader.readInt();
        int limit = reader.readUnsignedShort();
        spellCooldowns = new GameFightSpellCooldown[limit];
        for (int i = 0; i < limit; i++) {
            spellCooldowns[i] = new GameFightSpellCooldown();
            spellCooldowns[i].deserialize(reader);
        }
        summonCount = reader.readByte();
        if (summonCount < 0)
            throw new RuntimeException("Forbidden value on summonCount = " + summonCount + ", it doesn't respect the following condition : summonCount < 0");
        bombCount = reader.readByte();
        if (bombCount < 0)
            throw new RuntimeException("Forbidden value on bombCount = " + bombCount + ", it doesn't respect the following condition : bombCount < 0");
    }
    
}
