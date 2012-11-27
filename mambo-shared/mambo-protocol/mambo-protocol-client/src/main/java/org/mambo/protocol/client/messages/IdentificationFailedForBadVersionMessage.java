

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        requiredVersion.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        requiredVersion = new Version();
        requiredVersion.deserialize(reader);
    }
    
}
