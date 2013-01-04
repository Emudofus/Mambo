

// Generated on 01/04/2013 14:54:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeMountStableBornAddMessage extends ExchangeMountStableAddMessage {
    public static final int MESSAGE_ID = 5966;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public ExchangeMountStableBornAddMessage() { }
    
    public ExchangeMountStableBornAddMessage(MountClientData mountDescription) {
        super(mountDescription);
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
