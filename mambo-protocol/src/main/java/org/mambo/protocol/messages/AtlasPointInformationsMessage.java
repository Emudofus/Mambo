

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AtlasPointInformationsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5956;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public AtlasPointsInformations type;
    
    public AtlasPointInformationsMessage() { }
    
    public AtlasPointInformationsMessage(AtlasPointsInformations type) {
        this.type = type;
    }
    
    @Override
    public void serialize(Buffer buf) {
        type.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        type = new AtlasPointsInformations();
        type.deserialize(buf);
    }
    
}
