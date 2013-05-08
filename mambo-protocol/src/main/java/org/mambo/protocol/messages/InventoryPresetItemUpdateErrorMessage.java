

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InventoryPresetItemUpdateErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6211;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte code;
    
    public InventoryPresetItemUpdateErrorMessage() { }
    
    public InventoryPresetItemUpdateErrorMessage(byte code) {
        this.code = code;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(code);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        code = buf.readByte();
        if (code < 0)
            throw new RuntimeException("Forbidden value on code = " + code + ", it doesn't respect the following condition : code < 0");
    }
    
}
