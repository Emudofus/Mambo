

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobCrafterDirectoryListEntry extends NetworkType {
    public static final short TYPE_ID = 196;
    
    @Override
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
    public void serialize(Buffer buf) {
        playerInfo.serialize(buf);
        jobInfo.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
        playerInfo.deserialize(buf);
        jobInfo = new JobCrafterDirectoryEntryJobInfo();
        jobInfo.deserialize(buf);
    }
    
}
