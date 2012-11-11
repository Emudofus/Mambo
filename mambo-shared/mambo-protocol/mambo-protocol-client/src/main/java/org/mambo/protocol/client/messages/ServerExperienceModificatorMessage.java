

// Generated on 11/11/2012 19:17:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ServerExperienceModificatorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6237;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short experiencePercent;
    
    public ServerExperienceModificatorMessage() { }
    
    public ServerExperienceModificatorMessage(short experiencePercent) {
        this.experiencePercent = experiencePercent;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(experiencePercent);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        experiencePercent = reader.readShort();
        if (experiencePercent < 0)
            throw new RuntimeException("Forbidden value on experiencePercent = " + experiencePercent + ", it doesn't respect the following condition : experiencePercent < 0");
    }
    
}
