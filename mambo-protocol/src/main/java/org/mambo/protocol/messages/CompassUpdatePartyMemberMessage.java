

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CompassUpdatePartyMemberMessage extends CompassUpdateMessage {
    public static final int MESSAGE_ID = 5589;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int memberId;
    
    public CompassUpdatePartyMemberMessage() { }
    
    public CompassUpdatePartyMemberMessage(byte type, short worldX, short worldY, int memberId) {
        super(type, worldX, worldY);
        this.memberId = memberId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(memberId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        memberId = buf.readInt();
        if (memberId < 0)
            throw new RuntimeException("Forbidden value on memberId = " + memberId + ", it doesn't respect the following condition : memberId < 0");
    }
    
}
