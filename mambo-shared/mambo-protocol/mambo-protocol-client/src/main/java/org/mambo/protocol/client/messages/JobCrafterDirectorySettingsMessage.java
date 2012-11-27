

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class JobCrafterDirectorySettingsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5652;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public JobCrafterDirectorySettings[] craftersSettings;
    
    public JobCrafterDirectorySettingsMessage() { }
    
    public JobCrafterDirectorySettingsMessage(JobCrafterDirectorySettings[] craftersSettings) {
        this.craftersSettings = craftersSettings;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(craftersSettings.length);
        for (JobCrafterDirectorySettings entry : craftersSettings) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        craftersSettings = new JobCrafterDirectorySettings[limit];
        for (int i = 0; i < limit; i++) {
            craftersSettings[i] = new JobCrafterDirectorySettings();
            craftersSettings[i].deserialize(reader);
        }
    }
    
}
