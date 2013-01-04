

// Generated on 01/04/2013 14:54:27
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        experiencesUpdate.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        experiencesUpdate = new JobExperience();
        experiencesUpdate.deserialize(reader);
    }
    
}
