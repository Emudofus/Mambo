

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class UpdateMountIntBoost extends UpdateMountBoost {
    public static final short TYPE_ID = 357;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int value;
    
    public UpdateMountIntBoost() { }
    
    public UpdateMountIntBoost(byte type, int value) {
        super(type);
        this.value = value;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(value);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        value = reader.readInt();
    }
    
}
