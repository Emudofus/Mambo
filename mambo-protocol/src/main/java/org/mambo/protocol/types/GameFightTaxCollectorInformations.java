

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightTaxCollectorInformations extends GameFightAIInformations {
    public static final short TYPE_ID = 48;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short firstNameId;
    public short lastNameId;
    public short level;
    
    public GameFightTaxCollectorInformations() { }
    
    public GameFightTaxCollectorInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, boolean alive, GameFightMinimalStats stats, short firstNameId, short lastNameId, short level) {
        super(contextualId, look, disposition, teamId, alive, stats);
        this.firstNameId = firstNameId;
        this.lastNameId = lastNameId;
        this.level = level;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(firstNameId);
        buf.writeShort(lastNameId);
        buf.writeShort(level);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        firstNameId = buf.readShort();
        if (firstNameId < 0)
            throw new RuntimeException("Forbidden value on firstNameId = " + firstNameId + ", it doesn't respect the following condition : firstNameId < 0");
        lastNameId = buf.readShort();
        if (lastNameId < 0)
            throw new RuntimeException("Forbidden value on lastNameId = " + lastNameId + ", it doesn't respect the following condition : lastNameId < 0");
        level = buf.readShort();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
    }
    
}
