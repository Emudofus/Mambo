

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(effect.getTypeId());
        effect.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        effect = ProtocolTypeManager.getInstance().build(reader.readShort(), AbstractFightDispellableEffect.class);
        effect.deserialize(reader);
    }
    
}
