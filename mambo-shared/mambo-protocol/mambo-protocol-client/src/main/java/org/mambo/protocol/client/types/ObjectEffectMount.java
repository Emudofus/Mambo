

// Generated on 01/04/2013 14:54:48
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(mountId);
        writer.writeDouble(date);
        writer.writeShort(modelId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        mountId = reader.readInt();
        if (mountId < 0)
            throw new RuntimeException("Forbidden value on mountId = " + mountId + ", it doesn't respect the following condition : mountId < 0");
        date = reader.readDouble();
        modelId = reader.readShort();
        if (modelId < 0)
            throw new RuntimeException("Forbidden value on modelId = " + modelId + ", it doesn't respect the following condition : modelId < 0");
    }
    
}
