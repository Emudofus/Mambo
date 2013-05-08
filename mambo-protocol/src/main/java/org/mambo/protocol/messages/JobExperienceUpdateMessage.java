

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class JobExperienceUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5654;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public JobExperience experiencesUpdate;
    
    public JobExperienceUpdateMessage() { }
    
    public JobExperienceUpdateMessage(JobExperience experiencesUpdate) {
        this.experiencesUpdate = experiencesUpdate;
    }
    
    @Override
    public void serialize(Buffer buf) {
        experiencesUpdate.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        experiencesUpdate = new JobExperience();
        experiencesUpdate.deserialize(buf);
    }
    
}
