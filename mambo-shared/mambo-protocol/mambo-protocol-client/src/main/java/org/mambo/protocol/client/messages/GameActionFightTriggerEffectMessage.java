

// Generated on 01/04/2013 14:54:19
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightTriggerEffectMessage extends GameActionFightDispellEffectMessage {
    public static final int MESSAGE_ID = 6147;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public GameActionFightTriggerEffectMessage() { }
    
    public GameActionFightTriggerEffectMessage(short actionId, int sourceId, int targetId, int boostUID) {
        super(actionId, sourceId, targetId, boostUID);
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
