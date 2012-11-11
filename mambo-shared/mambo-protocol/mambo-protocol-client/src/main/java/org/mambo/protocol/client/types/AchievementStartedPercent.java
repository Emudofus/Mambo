

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AchievementStartedPercent extends Achievement {
    public static final short TYPE_ID = 362;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte completionPercent;
    
    public AchievementStartedPercent() { }
    
    public AchievementStartedPercent(short id, byte completionPercent) {
        super(id);
        this.completionPercent = completionPercent;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(completionPercent);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        completionPercent = reader.readByte();
        if (completionPercent < 0)
            throw new RuntimeException("Forbidden value on completionPercent = " + completionPercent + ", it doesn't respect the following condition : completionPercent < 0");
    }
    
}
