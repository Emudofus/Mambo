

// Generated on 01/04/2013 14:54:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
