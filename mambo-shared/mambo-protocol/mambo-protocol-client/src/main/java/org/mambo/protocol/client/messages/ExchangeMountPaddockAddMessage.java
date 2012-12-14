

// Generated on 12/14/2012 18:44:13
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeMountPaddockAddMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6049;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public MountClientData mountDescription;
    
    public ExchangeMountPaddockAddMessage() { }
    
    public ExchangeMountPaddockAddMessage(MountClientData mountDescription) {
        this.mountDescription = mountDescription;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        mountDescription.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mountDescription = new MountClientData();
        mountDescription.deserialize(reader);
    }
    
}
