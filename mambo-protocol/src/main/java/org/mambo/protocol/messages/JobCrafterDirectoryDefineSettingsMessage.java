

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        settings.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        settings = new JobCrafterDirectorySettings();
        settings.deserialize(buf);
    }
    
}
