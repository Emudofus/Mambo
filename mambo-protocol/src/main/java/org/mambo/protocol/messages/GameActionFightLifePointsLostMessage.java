

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(targetId);
        buf.writeShort(loss);
        buf.writeShort(permanentDamages);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        targetId = buf.readInt();
        loss = buf.readShort();
        if (loss < 0)
            throw new RuntimeException("Forbidden value on loss = " + loss + ", it doesn't respect the following condition : loss < 0");
        permanentDamages = buf.readShort();
        if (permanentDamages < 0)
            throw new RuntimeException("Forbidden value on permanentDamages = " + permanentDamages + ", it doesn't respect the following condition : permanentDamages < 0");
    }
    
}
