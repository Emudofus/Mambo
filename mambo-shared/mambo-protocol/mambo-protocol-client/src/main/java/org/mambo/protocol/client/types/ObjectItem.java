

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectItem extends Item {
    public static final short TYPE_ID = 37;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short position;
    public short objectGID;
    public short powerRate;
    public boolean overMax;
    public ObjectEffect[] effects;
    public int objectUID;
    public int quantity;
    
    public ObjectItem() { }
    
    public ObjectItem(short position, short objectGID, short powerRate, boolean overMax, ObjectEffect[] effects, int objectUID, int quantity) {
        this.position = position;
        this.objectGID = objectGID;
        this.powerRate = powerRate;
        this.overMax = overMax;
        this.effects = effects;
        this.objectUID = objectUID;
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedByte(position);
        writer.writeShort(objectGID);
        writer.writeShort(powerRate);
        writer.writeBoolean(overMax);
        writer.writeUnsignedShort(effects.length);
        for (ObjectEffect entry : effects) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
        writer.writeInt(objectUID);
        writer.writeInt(quantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        position = reader.readUnsignedByte();
        if (position < 0 || position > 255)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 0 || position > 255");
        objectGID = reader.readShort();
        if (objectGID < 0)
            throw new RuntimeException("Forbidden value on objectGID = " + objectGID + ", it doesn't respect the following condition : objectGID < 0");
        powerRate = reader.readShort();
        overMax = reader.readBoolean();
        int limit = reader.readUnsignedShort();
        effects = new ObjectEffect[limit];
        for (int i = 0; i < limit; i++) {
            effects[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), ObjectEffect.class);
            effects[i].deserialize(reader);
        }
        objectUID = reader.readInt();
        if (objectUID < 0)
            throw new RuntimeException("Forbidden value on objectUID = " + objectUID + ", it doesn't respect the following condition : objectUID < 0");
        quantity = reader.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
