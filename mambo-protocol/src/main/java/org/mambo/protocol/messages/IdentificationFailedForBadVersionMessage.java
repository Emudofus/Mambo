

// Generated on 05/08/2013 19:37:37
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IdentificationFailedForBadVersionMessage extends IdentificationFailedMessage {
    public static final int MESSAGE_ID = 21;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public Version requiredVersion;
    
    public IdentificationFailedForBadVersionMessage() { }
    
    public IdentificationFailedForBadVersionMessage(byte reason, Version requiredVersion) {
        super(reason);
        this.requiredVersion = requiredVersion;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        requiredVersion.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        requiredVersion = new Version();
        requiredVersion.deserialize(buf);
    }
    
}
