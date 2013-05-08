

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobCrafterDirectoryEntryMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6044;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public JobCrafterDirectoryEntryPlayerInfo playerInfo;
    public JobCrafterDirectoryEntryJobInfo[] jobInfoList;
    public EntityLook playerLook;
    
    public JobCrafterDirectoryEntryMessage() { }
    
    public JobCrafterDirectoryEntryMessage(JobCrafterDirectoryEntryPlayerInfo playerInfo, JobCrafterDirectoryEntryJobInfo[] jobInfoList, EntityLook playerLook) {
        this.playerInfo = playerInfo;
        this.jobInfoList = jobInfoList;
        this.playerLook = playerLook;
    }
    
    @Override
    public void serialize(Buffer buf) {
        playerInfo.serialize(buf);
        buf.writeUShort(jobInfoList.length);
        for (JobCrafterDirectoryEntryJobInfo entry : jobInfoList) {
            entry.serialize(buf);
        }
        playerLook.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
        playerInfo.deserialize(buf);
        int limit = buf.readUShort();
        jobInfoList = new JobCrafterDirectoryEntryJobInfo[limit];
        for (int i = 0; i < limit; i++) {
            jobInfoList[i] = new JobCrafterDirectoryEntryJobInfo();
            jobInfoList[i].deserialize(buf);
        }
        playerLook = new EntityLook();
        playerLook.deserialize(buf);
    }
    
}
