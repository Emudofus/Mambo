

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class ObjectEffectString extends ObjectEffect {
    public static final short TYPE_ID = 74;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String value;
    
    public ObjectEffectString() { }
    
    public ObjectEffectString(short actionId, String value) {
        super(actionId);
        this.value = value;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(value);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        value = reader.readString();
    }
    
}
