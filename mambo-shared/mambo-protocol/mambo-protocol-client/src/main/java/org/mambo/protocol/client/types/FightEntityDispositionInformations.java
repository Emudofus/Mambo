

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FightEntityDispositionInformations extends EntityDispositionInformations {
    public static final short TYPE_ID = 217;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int carryingCharacterId;
    
    public FightEntityDispositionInformations() { }
    
    public FightEntityDispositionInformations(short cellId, byte direction, int carryingCharacterId) {
        super(cellId, direction);
        this.carryingCharacterId = carryingCharacterId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(carryingCharacterId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        carryingCharacterId = reader.readInt();
    }
    
}
