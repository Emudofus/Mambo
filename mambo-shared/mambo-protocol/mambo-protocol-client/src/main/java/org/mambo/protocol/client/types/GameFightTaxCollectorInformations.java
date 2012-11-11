

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(firstNameId);
        writer.writeShort(lastNameId);
        writer.writeShort(level);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        firstNameId = reader.readShort();
        if (firstNameId < 0)
            throw new RuntimeException("Forbidden value on firstNameId = " + firstNameId + ", it doesn't respect the following condition : firstNameId < 0");
        lastNameId = reader.readShort();
        if (lastNameId < 0)
            throw new RuntimeException("Forbidden value on lastNameId = " + lastNameId + ", it doesn't respect the following condition : lastNameId < 0");
        level = reader.readShort();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
    }
    
}
