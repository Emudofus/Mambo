

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class JobCrafterDirectoryAddMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5651;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public JobCrafterDirectoryListEntry listEntry;
    
    public JobCrafterDirectoryAddMessage() { }
    
    public JobCrafterDirectoryAddMessage(JobCrafterDirectoryListEntry listEntry) {
        this.listEntry = listEntry;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        listEntry.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        listEntry = new JobCrafterDirectoryListEntry();
        listEntry.deserialize(reader);
    }
    
}
