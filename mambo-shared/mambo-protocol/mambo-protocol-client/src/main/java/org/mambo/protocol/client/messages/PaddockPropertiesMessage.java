

// Generated on 12/14/2012 18:44:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PaddockPropertiesMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5824;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PaddockInformations properties;
    
    public PaddockPropertiesMessage() { }
    
    public PaddockPropertiesMessage(PaddockInformations properties) {
        this.properties = properties;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(properties.getTypeId());
        properties.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        properties = ProtocolTypeManager.getInstance().build(reader.readShort(), PaddockInformations.class);
        properties.deserialize(reader);
    }
    
}
