

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectEffect implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 76;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short actionId;
    
    public ObjectEffect() { }
    
    public ObjectEffect(short actionId) {
        this.actionId = actionId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(actionId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        actionId = reader.readShort();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
    }
    
}
