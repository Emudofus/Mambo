

// Generated on 01/04/2013 14:54:32
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class IgnoredAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5678;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public IgnoredInformations ignoreAdded;
    public boolean session;
    
    public IgnoredAddedMessage() { }
    
    public IgnoredAddedMessage(IgnoredInformations ignoreAdded, boolean session) {
        this.ignoreAdded = ignoreAdded;
        this.session = session;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(ignoreAdded.getTypeId());
        ignoreAdded.serialize(writer);
        writer.writeBoolean(session);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        ignoreAdded = ProtocolTypeManager.getInstance().build(reader.readShort(), IgnoredInformations.class);
        ignoreAdded.deserialize(reader);
        session = reader.readBoolean();
    }
    
}
