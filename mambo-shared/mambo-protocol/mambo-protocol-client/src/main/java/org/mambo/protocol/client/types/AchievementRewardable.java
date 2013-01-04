

// Generated on 01/04/2013 14:54:43
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AchievementRewardable implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 412;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short id;
    public short finishedlevel;
    
    public AchievementRewardable() { }
    
    public AchievementRewardable(short id, short finishedlevel) {
        this.id = id;
        this.finishedlevel = finishedlevel;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(id);
        writer.writeShort(finishedlevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readShort();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        finishedlevel = reader.readShort();
        if (finishedlevel < 0 || finishedlevel > 200)
            throw new RuntimeException("Forbidden value on finishedlevel = " + finishedlevel + ", it doesn't respect the following condition : finishedlevel < 0 || finishedlevel > 200");
    }
    
}
