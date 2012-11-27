

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class JobCrafterDirectoryListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6046;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public JobCrafterDirectoryListEntry[] listEntries;
    
    public JobCrafterDirectoryListMessage() { }
    
    public JobCrafterDirectoryListMessage(JobCrafterDirectoryListEntry[] listEntries) {
        this.listEntries = listEntries;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(listEntries.length);
        for (JobCrafterDirectoryListEntry entry : listEntries) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        listEntries = new JobCrafterDirectoryListEntry[limit];
        for (int i = 0; i < limit; i++) {
            listEntries[i] = new JobCrafterDirectoryListEntry();
            listEntries[i].deserialize(reader);
        }
    }
    
}
