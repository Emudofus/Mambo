

// Generated on 05/08/2013 19:37:59
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartInfoMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1508;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ContentPart part;
    public float installationPercent;
    
    public PartInfoMessage() { }
    
    public PartInfoMessage(ContentPart part, float installationPercent) {
        this.part = part;
        this.installationPercent = installationPercent;
    }
    
    @Override
    public void serialize(Buffer buf) {
        part.serialize(buf);
        buf.writeFloat(installationPercent);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        part = new ContentPart();
        part.deserialize(buf);
        installationPercent = buf.readFloat();
    }
    
}
