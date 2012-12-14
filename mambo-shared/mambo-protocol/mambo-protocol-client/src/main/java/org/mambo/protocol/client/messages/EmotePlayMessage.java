

// Generated on 12/14/2012 18:44:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(actorId);
        writer.writeInt(accountId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        actorId = reader.readInt();
        accountId = reader.readInt();
    }
    
}
