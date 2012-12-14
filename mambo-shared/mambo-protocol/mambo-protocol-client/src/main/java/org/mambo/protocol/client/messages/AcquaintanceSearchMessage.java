

// Generated on 12/14/2012 18:44:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
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
