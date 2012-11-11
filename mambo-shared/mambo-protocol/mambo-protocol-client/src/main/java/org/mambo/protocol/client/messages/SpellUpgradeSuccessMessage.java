

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class SpellUpgradeSuccessMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1201;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int spellId;
    public byte spellLevel;
    
    public SpellUpgradeSuccessMessage() { }
    
    public SpellUpgradeSuccessMessage(int spellId, byte spellLevel) {
        this.spellId = spellId;
        this.spellLevel = spellLevel;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(spellId);
        writer.writeByte(spellLevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        spellId = reader.readInt();
        spellLevel = reader.readByte();
        if (spellLevel < 1 || spellLevel > 6)
            throw new RuntimeException("Forbidden value on spellLevel = " + spellLevel + ", it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6");
    }
    
}
