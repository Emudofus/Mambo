

// Generated on 11/11/2012 19:16:59
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameActionFightTriggerGlyphTrapMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5741;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short markId;
    public int triggeringCharacterId;
    public short triggeredSpellId;
    
    public GameActionFightTriggerGlyphTrapMessage() { }
    
    public GameActionFightTriggerGlyphTrapMessage(short actionId, int sourceId, short markId, int triggeringCharacterId, short triggeredSpellId) {
        super(actionId, sourceId);
        this.markId = markId;
        this.triggeringCharacterId = triggeringCharacterId;
        this.triggeredSpellId = triggeredSpellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(markId);
        writer.writeInt(triggeringCharacterId);
        writer.writeShort(triggeredSpellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        markId = reader.readShort();
        triggeringCharacterId = reader.readInt();
        triggeredSpellId = reader.readShort();
        if (triggeredSpellId < 0)
            throw new RuntimeException("Forbidden value on triggeredSpellId = " + triggeredSpellId + ", it doesn't respect the following condition : triggeredSpellId < 0");
    }
    
}
