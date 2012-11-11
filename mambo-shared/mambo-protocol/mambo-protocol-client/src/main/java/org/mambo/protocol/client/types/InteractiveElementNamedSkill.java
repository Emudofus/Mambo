

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InteractiveElementNamedSkill extends InteractiveElementSkill {
    public static final short TYPE_ID = 220;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int nameId;
    
    public InteractiveElementNamedSkill() { }
    
    public InteractiveElementNamedSkill(int skillId, int skillInstanceUid, int nameId) {
        super(skillId, skillInstanceUid);
        this.nameId = nameId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(nameId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        nameId = reader.readInt();
        if (nameId < 0)
            throw new RuntimeException("Forbidden value on nameId = " + nameId + ", it doesn't respect the following condition : nameId < 0");
    }
    
}
