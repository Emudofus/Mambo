

// Generated on 01/04/2013 14:54:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightLifeAndShieldPointsLostMessage extends GameActionFightLifePointsLostMessage {
    public static final int MESSAGE_ID = 6310;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short shieldLoss;
    
    public GameActionFightLifeAndShieldPointsLostMessage() { }
    
    public GameActionFightLifeAndShieldPointsLostMessage(short actionId, int sourceId, int targetId, short loss, short permanentDamages, short shieldLoss) {
        super(actionId, sourceId, targetId, loss, permanentDamages);
        this.shieldLoss = shieldLoss;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(shieldLoss);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        shieldLoss = reader.readShort();
        if (shieldLoss < 0)
            throw new RuntimeException("Forbidden value on shieldLoss = " + shieldLoss + ", it doesn't respect the following condition : shieldLoss < 0");
    }
    
}
