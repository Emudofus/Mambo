

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyMemberInformations extends CharacterMinimalPlusLookInformations {
    public static final short TYPE_ID = 90;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int lifePoints;
    public int maxLifePoints;
    public short prospecting;
    public short regenRate;
    public short initiative;
    public boolean pvpEnabled;
    public byte alignmentSide;
    
    public PartyMemberInformations() { }
    
    public PartyMemberInformations(int id, short level, String name, EntityLook entityLook, int lifePoints, int maxLifePoints, short prospecting, short regenRate, short initiative, boolean pvpEnabled, byte alignmentSide) {
        super(id, level, name, entityLook);
        this.lifePoints = lifePoints;
        this.maxLifePoints = maxLifePoints;
        this.prospecting = prospecting;
        this.regenRate = regenRate;
        this.initiative = initiative;
        this.pvpEnabled = pvpEnabled;
        this.alignmentSide = alignmentSide;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(lifePoints);
        writer.writeInt(maxLifePoints);
        writer.writeShort(prospecting);
        writer.writeUnsignedByte(regenRate);
        writer.writeShort(initiative);
        writer.writeBoolean(pvpEnabled);
        writer.writeByte(alignmentSide);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
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
        initiative = reader.readShort();
        if (initiative < 0)
            throw new RuntimeException("Forbidden value on initiative = " + initiative + ", it doesn't respect the following condition : initiative < 0");
        pvpEnabled = reader.readBoolean();
        alignmentSide = reader.readByte();
    }
    
}
