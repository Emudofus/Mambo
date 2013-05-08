

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HumanInformations extends NetworkType {
    public static final short TYPE_ID = 157;
    
    @Override
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
    public void serialize(Buffer buf) {
        restrictions.serialize(buf);
        buf.writeBoolean(sex);
        buf.writeUShort(options.length);
        for (HumanOption entry : options) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        restrictions = new ActorRestrictionsInformations();
        restrictions.deserialize(buf);
        sex = buf.readBoolean();
        int limit = buf.readUShort();
        options = new HumanOption[limit];
        for (int i = 0; i < limit; i++) {
            options[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            options[i].deserialize(buf);
        }
    }
    
}
