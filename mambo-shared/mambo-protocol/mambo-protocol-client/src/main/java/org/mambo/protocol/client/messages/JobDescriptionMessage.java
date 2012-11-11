

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(jobsDescription.length);
        for (JobDescription entry : jobsDescription) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        jobsDescription = new JobDescription[limit];
        for (int i = 0; i < limit; i++) {
            jobsDescription[i] = new JobDescription();
            jobsDescription[i].deserialize(reader);
        }
    }
    
}
