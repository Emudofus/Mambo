

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class GameActionFightReflectSpellMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5531;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    
    public GameActionFightReflectSpellMessage() { }
    
    public GameActionFightReflectSpellMessage(short actionId, int sourceId, int targetId) {
        super(actionId, sourceId);
        this.targetId = targetId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
    }
    
}
