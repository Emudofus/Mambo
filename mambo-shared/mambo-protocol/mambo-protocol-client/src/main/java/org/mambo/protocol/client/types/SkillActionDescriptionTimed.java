

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class SkillActionDescriptionTimed extends SkillActionDescription {
    public static final short TYPE_ID = 103;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short time;
    
    public SkillActionDescriptionTimed() { }
    
    public SkillActionDescriptionTimed(short skillId, short time) {
        super(skillId);
        this.time = time;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedByte(time);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        time = reader.readUnsignedByte();
        if (time < 0 || time > 255)
            throw new RuntimeException("Forbidden value on time = " + time + ", it doesn't respect the following condition : time < 0 || time > 255");
    }
    
}
