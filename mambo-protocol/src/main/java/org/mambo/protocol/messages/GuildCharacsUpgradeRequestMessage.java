

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildCharacsUpgradeRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5706;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte charaTypeTarget;
    
    public GuildCharacsUpgradeRequestMessage() { }
    
    public GuildCharacsUpgradeRequestMessage(byte charaTypeTarget) {
        this.charaTypeTarget = charaTypeTarget;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(charaTypeTarget);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        charaTypeTarget = buf.readByte();
        if (charaTypeTarget < 0)
            throw new RuntimeException("Forbidden value on charaTypeTarget = " + charaTypeTarget + ", it doesn't respect the following condition : charaTypeTarget < 0");
    }
    
}
