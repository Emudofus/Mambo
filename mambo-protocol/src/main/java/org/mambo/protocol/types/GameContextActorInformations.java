

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameContextActorInformations extends NetworkType {
    public static final short TYPE_ID = 150;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int contextualId;
    public EntityLook look;
    public EntityDispositionInformations disposition;
    
    public GameContextActorInformations() { }
    
    public GameContextActorInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition) {
        this.contextualId = contextualId;
        this.look = look;
        this.disposition = disposition;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(contextualId);
        look.serialize(buf);
        buf.writeShort(disposition.getTypeId());
        disposition.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        contextualId = buf.readInt();
        look = new EntityLook();
        look.deserialize(buf);
        disposition = ProtocolTypeManager.getInstance().build(buf.readShort());
        disposition.deserialize(buf);
    }
    
}
