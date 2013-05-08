

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildInfosUpgradeMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5636;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte maxTaxCollectorsCount;
    public byte taxCollectorsCount;
    public short taxCollectorLifePoints;
    public short taxCollectorDamagesBonuses;
    public short taxCollectorPods;
    public short taxCollectorProspecting;
    public short taxCollectorWisdom;
    public short boostPoints;
    public short[] spellId;
    public byte[] spellLevel;
    
    public GuildInfosUpgradeMessage() { }
    
    public GuildInfosUpgradeMessage(byte maxTaxCollectorsCount, byte taxCollectorsCount, short taxCollectorLifePoints, short taxCollectorDamagesBonuses, short taxCollectorPods, short taxCollectorProspecting, short taxCollectorWisdom, short boostPoints, short[] spellId, byte[] spellLevel) {
        this.maxTaxCollectorsCount = maxTaxCollectorsCount;
        this.taxCollectorsCount = taxCollectorsCount;
        this.taxCollectorLifePoints = taxCollectorLifePoints;
        this.taxCollectorDamagesBonuses = taxCollectorDamagesBonuses;
        this.taxCollectorPods = taxCollectorPods;
        this.taxCollectorProspecting = taxCollectorProspecting;
        this.taxCollectorWisdom = taxCollectorWisdom;
        this.boostPoints = boostPoints;
        this.spellId = spellId;
        this.spellLevel = spellLevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(maxTaxCollectorsCount);
        buf.writeByte(taxCollectorsCount);
        buf.writeShort(taxCollectorLifePoints);
        buf.writeShort(taxCollectorDamagesBonuses);
        buf.writeShort(taxCollectorPods);
        buf.writeShort(taxCollectorProspecting);
        buf.writeShort(taxCollectorWisdom);
        buf.writeShort(boostPoints);
        buf.writeUShort(spellId.length);
        for (short entry : spellId) {
            buf.writeShort(entry);
        }
        buf.writeUShort(spellLevel.length);
        for (byte entry : spellLevel) {
            buf.writeByte(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        maxTaxCollectorsCount = buf.readByte();
        if (maxTaxCollectorsCount < 0)
            throw new RuntimeException("Forbidden value on maxTaxCollectorsCount = " + maxTaxCollectorsCount + ", it doesn't respect the following condition : maxTaxCollectorsCount < 0");
        taxCollectorsCount = buf.readByte();
        if (taxCollectorsCount < 0)
            throw new RuntimeException("Forbidden value on taxCollectorsCount = " + taxCollectorsCount + ", it doesn't respect the following condition : taxCollectorsCount < 0");
        taxCollectorLifePoints = buf.readShort();
        if (taxCollectorLifePoints < 0)
            throw new RuntimeException("Forbidden value on taxCollectorLifePoints = " + taxCollectorLifePoints + ", it doesn't respect the following condition : taxCollectorLifePoints < 0");
        taxCollectorDamagesBonuses = buf.readShort();
        if (taxCollectorDamagesBonuses < 0)
            throw new RuntimeException("Forbidden value on taxCollectorDamagesBonuses = " + taxCollectorDamagesBonuses + ", it doesn't respect the following condition : taxCollectorDamagesBonuses < 0");
        taxCollectorPods = buf.readShort();
        if (taxCollectorPods < 0)
            throw new RuntimeException("Forbidden value on taxCollectorPods = " + taxCollectorPods + ", it doesn't respect the following condition : taxCollectorPods < 0");
        taxCollectorProspecting = buf.readShort();
        if (taxCollectorProspecting < 0)
            throw new RuntimeException("Forbidden value on taxCollectorProspecting = " + taxCollectorProspecting + ", it doesn't respect the following condition : taxCollectorProspecting < 0");
        taxCollectorWisdom = buf.readShort();
        if (taxCollectorWisdom < 0)
            throw new RuntimeException("Forbidden value on taxCollectorWisdom = " + taxCollectorWisdom + ", it doesn't respect the following condition : taxCollectorWisdom < 0");
        boostPoints = buf.readShort();
        if (boostPoints < 0)
            throw new RuntimeException("Forbidden value on boostPoints = " + boostPoints + ", it doesn't respect the following condition : boostPoints < 0");
        int limit = buf.readUShort();
        spellId = new short[limit];
        for (int i = 0; i < limit; i++) {
            spellId[i] = buf.readShort();
        }
        limit = buf.readUShort();
        spellLevel = new byte[limit];
        for (int i = 0; i < limit; i++) {
            spellLevel[i] = buf.readByte();
        }
    }
    
}
