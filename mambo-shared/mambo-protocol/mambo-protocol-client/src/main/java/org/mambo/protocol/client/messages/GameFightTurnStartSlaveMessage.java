

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameFightTurnStartSlaveMessage extends GameFightTurnStartMessage {
    public static final int MESSAGE_ID = 6213;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int idSummoner;
    
    public GameFightTurnStartSlaveMessage() { }
    
    public GameFightTurnStartSlaveMessage(int id, int waitTime, int idSummoner) {
        super(id, waitTime);
        this.idSummoner = idSummoner;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(idSummoner);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        idSummoner = reader.readInt();
    }
    
}
