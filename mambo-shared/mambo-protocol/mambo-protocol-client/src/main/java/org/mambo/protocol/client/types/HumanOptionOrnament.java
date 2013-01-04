

// Generated on 01/04/2013 14:54:46
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HumanOptionOrnament extends HumanOption {
    public static final short TYPE_ID = 411;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short ornamentId;
    
    public HumanOptionOrnament() { }
    
    public HumanOptionOrnament(short ornamentId) {
        this.ornamentId = ornamentId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(ornamentId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        ornamentId = reader.readShort();
        if (ornamentId < 0)
            throw new RuntimeException("Forbidden value on ornamentId = " + ornamentId + ", it doesn't respect the following condition : ornamentId < 0");
    }
    
}
