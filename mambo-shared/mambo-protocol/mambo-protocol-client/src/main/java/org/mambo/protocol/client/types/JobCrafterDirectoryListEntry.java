

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class JobCrafterDirectoryListEntry implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 196;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public JobCrafterDirectoryEntryPlayerInfo playerInfo;
    public JobCrafterDirectoryEntryJobInfo jobInfo;
    
    public JobCrafterDirectoryListEntry() { }
    
    public JobCrafterDirectoryListEntry(JobCrafterDirectoryEntryPlayerInfo playerInfo, JobCrafterDirectoryEntryJobInfo jobInfo) {
        this.playerInfo = playerInfo;
        this.jobInfo = jobInfo;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        playerInfo.serialize(writer);
        jobInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
        playerInfo.deserialize(reader);
        jobInfo = new JobCrafterDirectoryEntryJobInfo();
        jobInfo.deserialize(reader);
    }
    
}
