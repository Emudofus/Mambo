

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectItemToSell extends Item {
    public static final short TYPE_ID = 120;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short objectGID;
    public short powerRate;
    public boolean overMax;
    public ObjectEffect[] effects;
    public int objectUID;
    public int quantity;
    public int objectPrice;
    
    public ObjectItemToSell() { }
    
    public ObjectItemToSell(short objectGID, short powerRate, boolean overMax, ObjectEffect[] effects, int objectUID, int quantity, int objectPrice) {
        this.objectGID = objectGID;
        this.powerRate = powerRate;
        this.overMax = overMax;
        this.effects = effects;
        this.objectUID = objectUID;
        this.quantity = quantity;
        this.objectPrice = objectPrice;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(objectGID);
        buf.writeShort(powerRate);
        buf.writeBoolean(overMax);
        buf.writeUShort(effects.length);
        for (ObjectEffect entry : effects) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
        buf.writeInt(objectUID);
        buf.writeInt(quantity);
        buf.writeInt(objectPrice);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        objectGID = buf.readShort();
        if (objectGID < 0)
            throw new RuntimeException("Forbidden value on objectGID = " + objectGID + ", it doesn't respect the following condition : objectGID < 0");
        powerRate = buf.readShort();
        overMax = buf.readBoolean();
        int limit = buf.readUShort();
        effects = new ObjectEffect[limit];
        for (int i = 0; i < limit; i++) {
            effects[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            effects[i].deserialize(buf);
        }
        objectUID = buf.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
        objectPrice = buf.readInt();
        if (objectPrice < 0)
            throw new RuntimeException("Forbidden value on objectPrice = " + objectPrice + ", it doesn't respect the following condition : objectPrice < 0");
    }
    
}
