

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    }
    
}
