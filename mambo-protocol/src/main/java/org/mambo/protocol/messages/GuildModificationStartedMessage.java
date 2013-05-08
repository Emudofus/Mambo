

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildModificationStartedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6324;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean canChangeName;
    public boolean canChangeEmblem;
    
    public GuildModificationStartedMessage() { }
    
    public GuildModificationStartedMessage(boolean canChangeName, boolean canChangeEmblem) {
        this.canChangeName = canChangeName;
        this.canChangeEmblem = canChangeEmblem;
    }
    
    @Override
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, canChangeName);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, canChangeEmblem);
        buf.writeUByte(flag1);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        canChangeName = BooleanByteWrapper.getFlag(flag1, 0);
        canChangeEmblem = BooleanByteWrapper.getFlag(flag1, 1);
    }
    
}
