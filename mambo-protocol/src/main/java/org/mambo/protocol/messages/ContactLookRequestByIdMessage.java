

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ContactLookRequestByIdMessage extends ContactLookRequestMessage {
    public static final int MESSAGE_ID = 5935;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int playerId;
    
    public ContactLookRequestByIdMessage() { }
    
    public ContactLookRequestByIdMessage(short requestId, byte contactType, int playerId) {
        super(requestId, contactType);
        this.playerId = playerId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(playerId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
