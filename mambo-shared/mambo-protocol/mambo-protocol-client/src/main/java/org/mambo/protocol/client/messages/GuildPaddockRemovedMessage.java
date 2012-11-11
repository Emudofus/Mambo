

// Generated on 11/11/2012 19:17:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildPaddockRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5955;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int paddockId;
    
    public GuildPaddockRemovedMessage() { }
    
    public GuildPaddockRemovedMessage(int paddockId) {
        this.paddockId = paddockId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(paddockId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        paddockId = reader.readInt();
    }
    
}
