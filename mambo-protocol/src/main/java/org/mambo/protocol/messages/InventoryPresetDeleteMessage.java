

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InventoryPresetDeleteMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6169;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    
    public InventoryPresetDeleteMessage() { }
    
    public InventoryPresetDeleteMessage(byte presetId) {
        this.presetId = presetId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(presetId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        presetId = buf.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
    }
    
}
