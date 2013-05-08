

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MoodSmileyResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6196;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte resultCode;
    public byte smileyId;
    
    public MoodSmileyResultMessage() { }
    
    public MoodSmileyResultMessage(byte resultCode, byte smileyId) {
        this.resultCode = resultCode;
        this.smileyId = smileyId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(resultCode);
        buf.writeByte(smileyId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        resultCode = buf.readByte();
        if (resultCode < 0)
            throw new RuntimeException("Forbidden value on resultCode = " + resultCode + ", it doesn't respect the following condition : resultCode < 0");
        smileyId = buf.readByte();
    }
    
}
