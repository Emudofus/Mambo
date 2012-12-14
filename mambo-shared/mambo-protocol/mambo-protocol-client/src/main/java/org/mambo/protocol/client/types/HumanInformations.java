

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HumanInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 157;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public ActorRestrictionsInformations restrictions;
    public boolean sex;
    public HumanOption[] options;
    
    public HumanInformations() { }
    
    public HumanInformations(ActorRestrictionsInformations restrictions, boolean sex, HumanOption[] options) {
        this.restrictions = restrictions;
        this.sex = sex;
        this.options = options;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        restrictions.serialize(writer);
        writer.writeBoolean(sex);
        writer.writeUnsignedShort(options.length);
        for (HumanOption entry : options) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        restrictions = new ActorRestrictionsInformations();
        restrictions.deserialize(reader);
        sex = reader.readBoolean();
        int limit = reader.readUnsignedShort();
        options = new HumanOption[limit];
        for (int i = 0; i < limit; i++) {
            options[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), HumanOption.class);
            options[i].deserialize(reader);
        }
    }
    
}
