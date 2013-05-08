

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightResumeSlaveInfo extends NetworkType {
    public static final short TYPE_ID = 364;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(slaveId);
        buf.writeUShort(spellCooldowns.length);
        for (GameFightSpellCooldown entry : spellCooldowns) {
            entry.serialize(buf);
        }
        buf.writeByte(summonCount);
        buf.writeByte(bombCount);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        slaveId = buf.readInt();
        int limit = buf.readUShort();
        spellCooldowns = new GameFightSpellCooldown[limit];
        for (int i = 0; i < limit; i++) {
            spellCooldowns[i] = new GameFightSpellCooldown();
            spellCooldowns[i].deserialize(buf);
        }
        summonCount = buf.readByte();
        if (summonCount < 0)
            throw new RuntimeException("Forbidden value on summonCount = " + summonCount + ", it doesn't respect the following condition : summonCount < 0");
        bombCount = buf.readByte();
        if (bombCount < 0)
            throw new RuntimeException("Forbidden value on bombCount = " + bombCount + ", it doesn't respect the following condition : bombCount < 0");
    }
    
}
