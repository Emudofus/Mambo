

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InteractiveElement implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 80;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int elementId;
    public int elementTypeId;
    public InteractiveElementSkill[] enabledSkills;
    public InteractiveElementSkill[] disabledSkills;
    
    public InteractiveElement() { }
    
    public InteractiveElement(int elementId, int elementTypeId, InteractiveElementSkill[] enabledSkills, InteractiveElementSkill[] disabledSkills) {
        this.elementId = elementId;
        this.elementTypeId = elementTypeId;
        this.enabledSkills = enabledSkills;
        this.disabledSkills = disabledSkills;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(elementId);
        writer.writeInt(elementTypeId);
        writer.writeUnsignedShort(enabledSkills.length);
        for (InteractiveElementSkill entry : enabledSkills) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(disabledSkills.length);
        for (InteractiveElementSkill entry : disabledSkills) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        elementId = reader.readInt();
        if (elementId < 0)
            throw new RuntimeException("Forbidden value on elementId = " + elementId + ", it doesn't respect the following condition : elementId < 0");
        elementTypeId = reader.readInt();
        int limit = reader.readUnsignedShort();
        enabledSkills = new InteractiveElementSkill[limit];
        for (int i = 0; i < limit; i++) {
            enabledSkills[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), InteractiveElementSkill.class);
            enabledSkills[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        disabledSkills = new InteractiveElementSkill[limit];
        for (int i = 0; i < limit; i++) {
            disabledSkills[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), InteractiveElementSkill.class);
            disabledSkills[i].deserialize(reader);
        }
    }
    
}
