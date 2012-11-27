

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class GameActionFightReflectDamagesMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5530;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public int amount;
    
    public GameActionFightReflectDamagesMessage() { }
    
    public GameActionFightReflectDamagesMessage(short actionId, int sourceId, int targetId, int amount) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.amount = amount;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeInt(amount);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        amount = reader.readInt();
        if (amount < 0)
            throw new RuntimeException("Forbidden value on amount = " + amount + ", it doesn't respect the following condition : amount < 0");
    }
    
}
