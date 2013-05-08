

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightDispellableEffectExtendedInformations extends NetworkType {
    public static final short TYPE_ID = 208;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeShort(actionId);
        buf.writeInt(sourceId);
        buf.writeShort(effect.getTypeId());
        effect.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        actionId = buf.readShort();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
        sourceId = buf.readInt();
        effect = ProtocolTypeManager.getInstance().build(buf.readShort());
        effect.deserialize(buf);
    }
    
}
