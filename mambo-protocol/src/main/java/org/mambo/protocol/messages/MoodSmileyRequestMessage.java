

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MoodSmileyRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6192;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte smileyId;
    
    public MoodSmileyRequestMessage() { }
    
    public MoodSmileyRequestMessage(byte smileyId) {
        this.smileyId = smileyId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(smileyId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        smileyId = buf.readByte();
    }
    
}
