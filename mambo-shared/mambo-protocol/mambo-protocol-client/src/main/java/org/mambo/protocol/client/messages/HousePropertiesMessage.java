

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HousePropertiesMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5734;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public HouseInformations properties;
    
    public HousePropertiesMessage() { }
    
    public HousePropertiesMessage(HouseInformations properties) {
        this.properties = properties;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(properties.getTypeId());
        properties.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        properties = ProtocolTypeManager.getInstance().build(reader.readShort(), HouseInformations.class);
        properties.deserialize(reader);
    }
    
}
