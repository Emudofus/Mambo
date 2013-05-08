

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobExperienceMultiUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5809;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public JobExperience[] experiencesUpdate;
    
    public JobExperienceMultiUpdateMessage() { }
    
    public JobExperienceMultiUpdateMessage(JobExperience[] experiencesUpdate) {
        this.experiencesUpdate = experiencesUpdate;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(experiencesUpdate.length);
        for (JobExperience entry : experiencesUpdate) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        experiencesUpdate = new JobExperience[limit];
        for (int i = 0; i < limit; i++) {
            experiencesUpdate[i] = new JobExperience();
            experiencesUpdate[i].deserialize(buf);
        }
    }
    
}
