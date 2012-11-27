

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        part.serialize(writer);
        writer.writeFloat(installationPercent);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        part = new ContentPart();
        part.deserialize(reader);
        installationPercent = reader.readFloat();
    }
    
}
