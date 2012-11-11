

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(summonerId);
        writer.writeInt(slaveId);
        writer.writeUnsignedShort(slaveSpells.length);
        for (SpellItem entry : slaveSpells) {
            entry.serialize(writer);
        }
        slaveStats.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        summonerId = reader.readInt();
        slaveId = reader.readInt();
        int limit = reader.readUnsignedShort();
        slaveSpells = new SpellItem[limit];
        for (int i = 0; i < limit; i++) {
            slaveSpells[i] = new SpellItem();
            slaveSpells[i].deserialize(reader);
        }
        slaveStats = new CharacterCharacteristicsInformations();
        slaveStats.deserialize(reader);
    }
    
}
