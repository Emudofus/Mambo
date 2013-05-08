

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        listEntry.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        listEntry = new JobCrafterDirectoryListEntry();
        listEntry.deserialize(buf);
    }
    
}
