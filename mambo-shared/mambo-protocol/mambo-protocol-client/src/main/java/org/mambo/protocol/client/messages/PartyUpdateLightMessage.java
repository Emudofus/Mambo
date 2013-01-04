

// Generated on 01/04/2013 14:54:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(id);
        writer.writeInt(lifePoints);
        writer.writeInt(maxLifePoints);
        writer.writeShort(prospecting);
        writer.writeUnsignedByte(regenRate);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        id = reader.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        lifePoints = reader.readInt();
        if (lifePoints < 0)
            throw new RuntimeException("Forbidden value on lifePoints = " + lifePoints + ", it doesn't respect the following condition : lifePoints < 0");
        maxLifePoints = reader.readInt();
        if (maxLifePoints < 0)
            throw new RuntimeException("Forbidden value on maxLifePoints = " + maxLifePoints + ", it doesn't respect the following condition : maxLifePoints < 0");
        prospecting = reader.readShort();
        if (prospecting < 0)
            throw new RuntimeException("Forbidden value on prospecting = " + prospecting + ", it doesn't respect the following condition : prospecting < 0");
        regenRate = reader.readUnsignedByte();
        if (regenRate < 0 || regenRate > 255)
            throw new RuntimeException("Forbidden value on regenRate = " + regenRate + ", it doesn't respect the following condition : regenRate < 0 || regenRate > 255");
    }
    
}
