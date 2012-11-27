

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class GameFightTurnResumeMessage extends GameFightTurnStartMessage {
    public static final int MESSAGE_ID = 6307;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public GameFightTurnResumeMessage() { }
    
    public GameFightTurnResumeMessage(int id, int waitTime) {
        super(id, waitTime);
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
