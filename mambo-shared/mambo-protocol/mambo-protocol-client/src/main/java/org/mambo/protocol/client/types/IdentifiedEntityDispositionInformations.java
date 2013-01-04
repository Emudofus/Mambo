

// Generated on 01/04/2013 14:54:44
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class IdentifiedEntityDispositionInformations extends EntityDispositionInformations {
    public static final short TYPE_ID = 107;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    
    public IdentifiedEntityDispositionInformations() { }
    
    public IdentifiedEntityDispositionInformations(short cellId, byte direction, int id) {
        super(cellId, direction);
        this.id = id;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(id);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        id = reader.readInt();
    }
    
}
