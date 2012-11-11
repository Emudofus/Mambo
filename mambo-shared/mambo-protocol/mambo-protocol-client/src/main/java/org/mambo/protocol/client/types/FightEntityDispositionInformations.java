

// Generated on 11/11/2012 19:06:11
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
