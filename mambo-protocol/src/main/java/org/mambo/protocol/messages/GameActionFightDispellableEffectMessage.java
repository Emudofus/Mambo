

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightDispellableEffectMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 6070;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public AbstractFightDispellableEffect effect;
    
    public GameActionFightDispellableEffectMessage() { }
    
    public GameActionFightDispellableEffectMessage(short actionId, int sourceId, AbstractFightDispellableEffect effect) {
        super(actionId, sourceId);
        this.effect = effect;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(effect.getTypeId());
        effect.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        effect = ProtocolTypeManager.getInstance().build(buf.readShort());
        effect.deserialize(buf);
    }
    
}
