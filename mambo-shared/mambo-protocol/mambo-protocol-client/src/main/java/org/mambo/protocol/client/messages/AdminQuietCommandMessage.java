

// Generated on 11/11/2012 20:41:21
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AdminQuietCommandMessage extends AdminCommandMessage {
    public static final int MESSAGE_ID = 5662;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public AdminQuietCommandMessage() { }
    
    public AdminQuietCommandMessage(String content) {
        super(content);
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
