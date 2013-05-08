

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CompassUpdatePvpSeekMessage extends CompassUpdateMessage {
    public static final int MESSAGE_ID = 6013;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int memberId;
    public String memberName;
    
    public CompassUpdatePvpSeekMessage() { }
    
    public CompassUpdatePvpSeekMessage(byte type, short worldX, short worldY, int memberId, String memberName) {
        super(type, worldX, worldY);
        this.memberId = memberId;
        this.memberName = memberName;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(memberId);
        buf.writeString(memberName);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        memberId = buf.readInt();
        if (memberId < 0)
            throw new RuntimeException("Forbidden value on memberId = " + memberId + ", it doesn't respect the following condition : memberId < 0");
        memberName = buf.readString();
    }
    
}
