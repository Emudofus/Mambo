

// Generated on 01/04/2013 14:54:19
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightSpellCooldownVariationMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 6219;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public int spellId;
    public short value;
    
    public GameActionFightSpellCooldownVariationMessage() { }
    
    public GameActionFightSpellCooldownVariationMessage(short actionId, int sourceId, int targetId, int spellId, short value) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.spellId = spellId;
        this.value = value;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeInt(spellId);
        writer.writeShort(value);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        spellId = reader.readInt();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
        value = reader.readShort();
    }
    
}
