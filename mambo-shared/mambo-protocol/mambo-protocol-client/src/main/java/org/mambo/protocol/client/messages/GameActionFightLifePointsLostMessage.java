

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class GameActionFightLifePointsLostMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 6312;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short loss;
    public short permanentDamages;
    
    public GameActionFightLifePointsLostMessage() { }
    
    public GameActionFightLifePointsLostMessage(short actionId, int sourceId, int targetId, short loss, short permanentDamages) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.loss = loss;
        this.permanentDamages = permanentDamages;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeShort(loss);
        writer.writeShort(permanentDamages);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        loss = reader.readShort();
        if (loss < 0)
            throw new RuntimeException("Forbidden value on loss = " + loss + ", it doesn't respect the following condition : loss < 0");
        permanentDamages = reader.readShort();
        if (permanentDamages < 0)
            throw new RuntimeException("Forbidden value on permanentDamages = " + permanentDamages + ", it doesn't respect the following condition : permanentDamages < 0");
    }
    
}
