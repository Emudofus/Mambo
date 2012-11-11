

// Generated on 11/11/2012 19:16:58
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameActionFightSpellImmunityMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 6221;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public int spellId;
    
    public GameActionFightSpellImmunityMessage() { }
    
    public GameActionFightSpellImmunityMessage(short actionId, int sourceId, int targetId, int spellId) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.spellId = spellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeInt(spellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        spellId = reader.readInt();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
    }
    
}
