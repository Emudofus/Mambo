

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SpouseInformationsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6356;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public FriendSpouseInformations spouse;
    
    public SpouseInformationsMessage() { }
    
    public SpouseInformationsMessage(FriendSpouseInformations spouse) {
        this.spouse = spouse;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(spouse.getTypeId());
        spouse.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spouse = ProtocolTypeManager.getInstance().build(buf.readShort());
        spouse.deserialize(buf);
    }
    
}
