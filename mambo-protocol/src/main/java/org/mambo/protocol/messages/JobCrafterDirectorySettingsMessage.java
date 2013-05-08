

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(craftersSettings.length);
        for (JobCrafterDirectorySettings entry : craftersSettings) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        craftersSettings = new JobCrafterDirectorySettings[limit];
        for (int i = 0; i < limit; i++) {
            craftersSettings[i] = new JobCrafterDirectorySettings();
            craftersSettings[i].deserialize(buf);
        }
    }
    
}
