

// Generated on 11/11/2012 19:17:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightLeaveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 721;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int charId;
    
    public GameFightLeaveMessage() { }
    
    public GameFightLeaveMessage(int charId) {
        this.charId = charId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(charId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        charId = reader.readInt();
    }
    
}
