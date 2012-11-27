

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        restrictions.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        restrictions = new ActorRestrictionsInformations();
        restrictions.deserialize(reader);
    }
    
}
