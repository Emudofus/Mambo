

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountEmoteIconUsedOkMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5978;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int mountId;
    public byte reactionType;
    
    public MountEmoteIconUsedOkMessage() { }
    
    public MountEmoteIconUsedOkMessage(int mountId, byte reactionType) {
        this.mountId = mountId;
        this.reactionType = reactionType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(mountId);
        buf.writeByte(reactionType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mountId = buf.readInt();
        reactionType = buf.readByte();
        if (reactionType < 0)
            throw new RuntimeException("Forbidden value on reactionType = " + reactionType + ", it doesn't respect the following condition : reactionType < 0");
    }
    
}
