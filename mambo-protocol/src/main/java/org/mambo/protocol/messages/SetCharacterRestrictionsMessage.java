

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SetCharacterRestrictionsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 170;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ActorRestrictionsInformations restrictions;
    
    public SetCharacterRestrictionsMessage() { }
    
    public SetCharacterRestrictionsMessage(ActorRestrictionsInformations restrictions) {
        this.restrictions = restrictions;
    }
    
    @Override
    public void serialize(Buffer buf) {
        restrictions.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        restrictions = new ActorRestrictionsInformations();
        restrictions.deserialize(buf);
    }
    
}
