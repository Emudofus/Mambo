

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SlaveSwitchContextMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6214;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int summonerId;
    public int slaveId;
    public SpellItem[] slaveSpells;
    public CharacterCharacteristicsInformations slaveStats;
    
    public SlaveSwitchContextMessage() { }
    
    public SlaveSwitchContextMessage(int summonerId, int slaveId, SpellItem[] slaveSpells, CharacterCharacteristicsInformations slaveStats) {
        this.summonerId = summonerId;
        this.slaveId = slaveId;
        this.slaveSpells = slaveSpells;
        this.slaveStats = slaveStats;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(summonerId);
        buf.writeInt(slaveId);
        buf.writeUShort(slaveSpells.length);
        for (SpellItem entry : slaveSpells) {
            entry.serialize(buf);
        }
        slaveStats.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        summonerId = buf.readInt();
        slaveId = buf.readInt();
        int limit = buf.readUShort();
        slaveSpells = new SpellItem[limit];
        for (int i = 0; i < limit; i++) {
            slaveSpells[i] = new SpellItem();
            slaveSpells[i].deserialize(buf);
        }
        slaveStats = new CharacterCharacteristicsInformations();
        slaveStats.deserialize(buf);
    }
    
}
