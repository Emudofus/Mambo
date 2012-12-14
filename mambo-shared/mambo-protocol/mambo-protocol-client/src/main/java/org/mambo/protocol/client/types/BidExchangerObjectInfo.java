

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class BidExchangerObjectInfo implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 122;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int objectUID;
    public short powerRate;
    public boolean overMax;
    public ObjectEffect[] effects;
    public int[] prices;
    
    public BidExchangerObjectInfo() { }
    
    public BidExchangerObjectInfo(int objectUID, short powerRate, boolean overMax, ObjectEffect[] effects, int[] prices) {
        this.objectUID = objectUID;
        this.powerRate = powerRate;
        this.overMax = overMax;
        this.effects = effects;
        this.prices = prices;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(objectUID);
        writer.writeShort(powerRate);
        writer.writeBoolean(overMax);
        writer.writeUnsignedShort(effects.length);
        for (ObjectEffect entry : effects) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(prices.length);
        for (int entry : prices) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        objectUID = reader.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
        powerRate = reader.readShort();
        overMax = reader.readBoolean();
        int limit = reader.readUnsignedShort();
        effects = new ObjectEffect[limit];
        for (int i = 0; i < limit; i++) {
            effects[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), ObjectEffect.class);
            effects[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        prices = new int[limit];
        for (int i = 0; i < limit; i++) {
            prices[i] = reader.readInt();
        }
    }
    
}
