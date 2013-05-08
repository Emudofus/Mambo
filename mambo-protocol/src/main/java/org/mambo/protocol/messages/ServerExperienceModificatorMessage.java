

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeShort(experiencePercent);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        experiencePercent = buf.readShort();
        if (experiencePercent < 0)
            throw new RuntimeException("Forbidden value on experiencePercent = " + experiencePercent + ", it doesn't respect the following condition : experiencePercent < 0");
    }
    
}
