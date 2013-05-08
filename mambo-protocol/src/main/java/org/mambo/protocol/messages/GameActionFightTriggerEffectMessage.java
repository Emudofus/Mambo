

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
