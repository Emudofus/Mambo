

// Generated on 12/14/2012 18:44:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(maxTaxCollectorsCount);
        writer.writeByte(taxCollectorsCount);
        writer.writeShort(taxCollectorLifePoints);
        writer.writeShort(taxCollectorDamagesBonuses);
        writer.writeShort(taxCollectorPods);
        writer.writeShort(taxCollectorProspecting);
        writer.writeShort(taxCollectorWisdom);
        writer.writeShort(boostPoints);
        writer.writeUnsignedShort(spellId.length);
        for (short entry : spellId) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(spellLevel.length);
        for (byte entry : spellLevel) {
            writer.writeByte(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        maxTaxCollectorsCount = reader.readByte();
        if (maxTaxCollectorsCount < 0)
            throw new RuntimeException("Forbidden value on maxTaxCollectorsCount = " + maxTaxCollectorsCount + ", it doesn't respect the following condition : maxTaxCollectorsCount < 0");
        taxCollectorsCount = reader.readByte();
        if (taxCollectorsCount < 0)
            throw new RuntimeException("Forbidden value on taxCollectorsCount = " + taxCollectorsCount + ", it doesn't respect the following condition : taxCollectorsCount < 0");
        taxCollectorLifePoints = reader.readShort();
        if (taxCollectorLifePoints < 0)
            throw new RuntimeException("Forbidden value on taxCollectorLifePoints = " + taxCollectorLifePoints + ", it doesn't respect the following condition : taxCollectorLifePoints < 0");
        taxCollectorDamagesBonuses = reader.readShort();
        if (taxCollectorDamagesBonuses < 0)
            throw new RuntimeException("Forbidden value on taxCollectorDamagesBonuses = " + taxCollectorDamagesBonuses + ", it doesn't respect the following condition : taxCollectorDamagesBonuses < 0");
        taxCollectorPods = reader.readShort();
        if (taxCollectorPods < 0)
            throw new RuntimeException("Forbidden value on taxCollectorPods = " + taxCollectorPods + ", it doesn't respect the following condition : taxCollectorPods < 0");
        taxCollectorProspecting = reader.readShort();
        if (taxCollectorProspecting < 0)
            throw new RuntimeException("Forbidden value on taxCollectorProspecting = " + taxCollectorProspecting + ", it doesn't respect the following condition : taxCollectorProspecting < 0");
        taxCollectorWisdom = reader.readShort();
        if (taxCollectorWisdom < 0)
            throw new RuntimeException("Forbidden value on taxCollectorWisdom = " + taxCollectorWisdom + ", it doesn't respect the following condition : taxCollectorWisdom < 0");
        boostPoints = reader.readShort();
        if (boostPoints < 0)
            throw new RuntimeException("Forbidden value on boostPoints = " + boostPoints + ", it doesn't respect the following condition : boostPoints < 0");
        int limit = reader.readUnsignedShort();
        spellId = new short[limit];
        for (int i = 0; i < limit; i++) {
            spellId[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        spellLevel = new byte[limit];
        for (int i = 0; i < limit; i++) {
            spellLevel[i] = reader.readByte();
        }
    }
    
}
