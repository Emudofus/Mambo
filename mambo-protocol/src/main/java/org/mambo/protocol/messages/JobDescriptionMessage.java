

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobDescriptionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5655;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public JobDescription[] jobsDescription;
    
    public JobDescriptionMessage() { }
    
    public JobDescriptionMessage(JobDescription[] jobsDescription) {
        this.jobsDescription = jobsDescription;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(jobsDescription.length);
        for (JobDescription entry : jobsDescription) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        jobsDescription = new JobDescription[limit];
        for (int i = 0; i < limit; i++) {
            jobsDescription[i] = new JobDescription();
            jobsDescription[i].deserialize(buf);
        }
    }
    
}
