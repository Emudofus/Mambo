

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class JobCrafterDirectoryDefineSettingsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5649;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public JobCrafterDirectorySettings settings;
    
    public JobCrafterDirectoryDefineSettingsMessage() { }
    
    public JobCrafterDirectoryDefineSettingsMessage(JobCrafterDirectorySettings settings) {
        this.settings = settings;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        settings.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        settings = new JobCrafterDirectorySettings();
        settings.deserialize(reader);
    }
    
}
