

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(properties.getTypeId());
        properties.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        properties = ProtocolTypeManager.getInstance().build(buf.readShort());
        properties.deserialize(buf);
    }
    
}
