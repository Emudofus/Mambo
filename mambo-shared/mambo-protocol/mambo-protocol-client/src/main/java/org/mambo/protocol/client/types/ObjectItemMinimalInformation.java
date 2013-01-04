

// Generated on 01/04/2013 14:54:46
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ObjectItemMinimalInformation extends Item {
    public static final short TYPE_ID = 124;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short objectGID;
    public short powerRate;
    public boolean overMax;
    public ObjectEffect[] effects;
    
    public ObjectItemMinimalInformation() { }
    
    public ObjectItemMinimalInformation(short objectGID, short powerRate, boolean overMax, ObjectEffect[] effects) {
        this.objectGID = objectGID;
        this.powerRate = powerRate;
        this.overMax = overMax;
        this.effects = effects;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(objectGID);
        writer.writeShort(powerRate);
        writer.writeBoolean(overMax);
        writer.writeUnsignedShort(effects.length);
        for (ObjectEffect entry : effects) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
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
    }
    
}
