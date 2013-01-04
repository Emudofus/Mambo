

// Generated on 01/04/2013 14:54:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        playerInfo.serialize(writer);
        writer.writeUnsignedShort(jobInfoList.length);
        for (JobCrafterDirectoryEntryJobInfo entry : jobInfoList) {
            entry.serialize(writer);
        }
        playerLook.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
        playerInfo.deserialize(reader);
        int limit = reader.readUnsignedShort();
        jobInfoList = new JobCrafterDirectoryEntryJobInfo[limit];
        for (int i = 0; i < limit; i++) {
            jobInfoList[i] = new JobCrafterDirectoryEntryJobInfo();
            jobInfoList[i].deserialize(reader);
        }
        playerLook = new EntityLook();
        playerLook.deserialize(reader);
    }
    
}
