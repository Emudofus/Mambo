

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightNoSpellCastMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6132;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int spellLevelId;
    
    public GameActionFightNoSpellCastMessage() { }
    
    public GameActionFightNoSpellCastMessage(int spellLevelId) {
        this.spellLevelId = spellLevelId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(spellLevelId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        spellLevelId = reader.readInt();
        if (spellLevelId < 0)
            throw new RuntimeException("Forbidden value on spellLevelId = " + spellLevelId + ", it doesn't respect the following condition : spellLevelId < 0");
    }
    
}
