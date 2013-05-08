

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(carryingCharacterId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        carryingCharacterId = buf.readInt();
    }
    
}
