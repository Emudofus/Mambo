

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(id);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        id = buf.readInt();
    }
    
}
