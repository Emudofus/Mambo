

// Generated on 01/04/2013 14:54:44
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AbstractCharacterInformation implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 400;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    
    public AbstractCharacterInformation() { }
    
    public AbstractCharacterInformation(int id) {
        this.id = id;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
    }
    
}
