

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(listEntries.length);
        for (JobCrafterDirectoryListEntry entry : listEntries) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        listEntries = new JobCrafterDirectoryListEntry[limit];
        for (int i = 0; i < limit; i++) {
            listEntries[i] = new JobCrafterDirectoryListEntry();
            listEntries[i].deserialize(buf);
        }
    }
    
}
