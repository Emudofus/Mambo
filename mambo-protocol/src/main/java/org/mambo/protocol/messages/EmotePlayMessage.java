

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class EmotePlayMessage extends EmotePlayAbstractMessage {
    public static final int MESSAGE_ID = 5683;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int actorId;
    public int accountId;
    
    public EmotePlayMessage() { }
    
    public EmotePlayMessage(byte emoteId, double emoteStartTime, int actorId, int accountId) {
        super(emoteId, emoteStartTime);
        this.actorId = actorId;
        this.accountId = accountId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(actorId);
        buf.writeInt(accountId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        actorId = buf.readInt();
        accountId = buf.readInt();
    }
    
}
