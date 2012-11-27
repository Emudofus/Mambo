

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameContextActorInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 150;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(contextualId);
        look.serialize(writer);
        writer.writeShort(disposition.getTypeId());
        disposition.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        contextualId = reader.readInt();
        look = new EntityLook();
        look.deserialize(reader);
        disposition = ProtocolTypeManager.getInstance().build(reader.readShort(), EntityDispositionInformations.class);
        disposition.deserialize(reader);
    }
    
}
