

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(markId);
        buf.writeInt(triggeringCharacterId);
        buf.writeShort(triggeredSpellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        markId = buf.readShort();
        triggeringCharacterId = buf.readInt();
        triggeredSpellId = buf.readShort();
        if (triggeredSpellId < 0)
            throw new RuntimeException("Forbidden value on triggeredSpellId = " + triggeredSpellId + ", it doesn't respect the following condition : triggeredSpellId < 0");
    }
    
}
