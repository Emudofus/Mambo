

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectEffectMount extends ObjectEffect {
    public static final short TYPE_ID = 179;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int mountId;
    public double date;
    public short modelId;
    
    public ObjectEffectMount() { }
    
    public ObjectEffectMount(short actionId, int mountId, double date, short modelId) {
        super(actionId);
        this.mountId = mountId;
        this.date = date;
        this.modelId = modelId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(mountId);
        buf.writeDouble(date);
        buf.writeShort(modelId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        mountId = buf.readInt();
        if (mountId < 0)
            throw new RuntimeException("Forbidden value on mountId = " + mountId + ", it doesn't respect the following condition : mountId < 0");
        date = buf.readDouble();
        modelId = buf.readShort();
        if (modelId < 0)
            throw new RuntimeException("Forbidden value on modelId = " + modelId + ", it doesn't respect the following condition : modelId < 0");
    }
    
}
