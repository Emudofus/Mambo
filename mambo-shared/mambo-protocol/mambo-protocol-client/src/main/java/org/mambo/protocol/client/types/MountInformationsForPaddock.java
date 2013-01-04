

// Generated on 01/04/2013 14:54:49
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class MountInformationsForPaddock implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 184;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int modelId;
    public String name;
    public String ownerName;
    
    public MountInformationsForPaddock() { }
    
    public MountInformationsForPaddock(int modelId, String name, String ownerName) {
        this.modelId = modelId;
        this.name = name;
        this.ownerName = ownerName;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(modelId);
        writer.writeString(name);
        writer.writeString(ownerName);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        modelId = reader.readInt();
        name = reader.readString();
        ownerName = reader.readString();
    }
    
}
