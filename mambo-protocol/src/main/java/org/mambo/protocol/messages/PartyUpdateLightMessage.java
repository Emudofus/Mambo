

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyUpdateLightMessage extends AbstractPartyEventMessage {
    public static final int MESSAGE_ID = 6054;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int id;
    public int lifePoints;
    public int maxLifePoints;
    public short prospecting;
    public short regenRate;
    
    public PartyUpdateLightMessage() { }
    
    public PartyUpdateLightMessage(int partyId, int id, int lifePoints, int maxLifePoints, short prospecting, short regenRate) {
        super(partyId);
        this.id = id;
        this.lifePoints = lifePoints;
        this.maxLifePoints = maxLifePoints;
        this.prospecting = prospecting;
        this.regenRate = regenRate;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(id);
        buf.writeInt(lifePoints);
        buf.writeInt(maxLifePoints);
        buf.writeShort(prospecting);
        buf.writeUByte(regenRate);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        id = buf.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        lifePoints = buf.readInt();
        if (lifePoints < 0)
            throw new RuntimeException("Forbidden value on lifePoints = " + lifePoints + ", it doesn't respect the following condition : lifePoints < 0");
        maxLifePoints = buf.readInt();
        if (maxLifePoints < 0)
            throw new RuntimeException("Forbidden value on maxLifePoints = " + maxLifePoints + ", it doesn't respect the following condition : maxLifePoints < 0");
        prospecting = buf.readShort();
        if (prospecting < 0)
            throw new RuntimeException("Forbidden value on prospecting = " + prospecting + ", it doesn't respect the following condition : prospecting < 0");
        regenRate = buf.readUByte();
        if (regenRate < 0 || regenRate > 255)
            throw new RuntimeException("Forbidden value on regenRate = " + regenRate + ", it doesn't respect the following condition : regenRate < 0 || regenRate > 255");
    }
    
}
