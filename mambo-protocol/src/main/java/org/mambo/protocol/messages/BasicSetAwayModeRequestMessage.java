

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class BasicSetAwayModeRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5665;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enable;
    public boolean invisible;
    
    public BasicSetAwayModeRequestMessage() { }
    
    public BasicSetAwayModeRequestMessage(boolean enable, boolean invisible) {
        this.enable = enable;
        this.invisible = invisible;
    }
    
    @Override
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, enable);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, invisible);
        buf.writeUByte(flag1);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        enable = BooleanByteWrapper.getFlag(flag1, 0);
        invisible = BooleanByteWrapper.getFlag(flag1, 1);
    }
    
}
