

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(experiencesUpdate.length);
        for (JobExperience entry : experiencesUpdate) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        experiencesUpdate = new JobExperience[limit];
        for (int i = 0; i < limit; i++) {
            experiencesUpdate[i] = new JobExperience();
            experiencesUpdate[i].deserialize(reader);
        }
    }
    
}
