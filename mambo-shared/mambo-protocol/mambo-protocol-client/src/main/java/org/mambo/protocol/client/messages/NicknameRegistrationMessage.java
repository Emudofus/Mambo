

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class NicknameRegistrationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5640;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public NicknameRegistrationMessage() { }
    
    
    @Override
    public void serialize(DataWriterInterface writer) {
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
    }
    
}
