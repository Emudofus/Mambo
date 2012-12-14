

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FightDispellableEffectExtendedInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 208;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short actionId;
    public int sourceId;
    public AbstractFightDispellableEffect effect;
    
    public FightDispellableEffectExtendedInformations() { }
    
    public FightDispellableEffectExtendedInformations(short actionId, int sourceId, AbstractFightDispellableEffect effect) {
        this.actionId = actionId;
        this.sourceId = sourceId;
        this.effect = effect;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(actionId);
        writer.writeInt(sourceId);
        writer.writeShort(effect.getTypeId());
        effect.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        actionId = reader.readShort();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
        sourceId = reader.readInt();
        effect = ProtocolTypeManager.getInstance().build(reader.readShort(), AbstractFightDispellableEffect.class);
        effect.deserialize(reader);
    }
    
}
