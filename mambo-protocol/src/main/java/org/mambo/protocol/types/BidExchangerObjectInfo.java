

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class BidExchangerObjectInfo extends NetworkType {
    public static final short TYPE_ID = 122;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(objectUID);
        buf.writeShort(powerRate);
        buf.writeBoolean(overMax);
        buf.writeUShort(effects.length);
        for (ObjectEffect entry : effects) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
        buf.writeUShort(prices.length);
        for (int entry : prices) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        objectUID = buf.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
        powerRate = buf.readShort();
        overMax = buf.readBoolean();
        int limit = buf.readUShort();
        effects = new ObjectEffect[limit];
        for (int i = 0; i < limit; i++) {
            effects[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            effects[i].deserialize(buf);
        }
        limit = buf.readUShort();
        prices = new int[limit];
        for (int i = 0; i < limit; i++) {
            prices[i] = buf.readInt();
        }
    }
    
}
