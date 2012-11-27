

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AcquaintanceSearchMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6144;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String nickname;
    
    public AcquaintanceSearchMessage() { }
    
    public AcquaintanceSearchMessage(String nickname) {
        this.nickname = nickname;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(nickname);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        nickname = reader.readString();
    }
    
}
