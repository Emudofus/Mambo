

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
