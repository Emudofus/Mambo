

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ShortcutBarRemoveErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6222;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte error;
    
    public ShortcutBarRemoveErrorMessage() { }
    
    public ShortcutBarRemoveErrorMessage(byte error) {
        this.error = error;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(error);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        error = buf.readByte();
        if (error < 0)
            throw new RuntimeException("Forbidden value on error = " + error + ", it doesn't respect the following condition : error < 0");
    }
    
}
