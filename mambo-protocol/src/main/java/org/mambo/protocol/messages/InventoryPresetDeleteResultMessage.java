

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InventoryPresetDeleteResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6173;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public byte code;
    
    public InventoryPresetDeleteResultMessage() { }
    
    public InventoryPresetDeleteResultMessage(byte presetId, byte code) {
        this.presetId = presetId;
        this.code = code;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(presetId);
        buf.writeByte(code);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        presetId = buf.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        code = buf.readByte();
        if (code < 0)
            throw new RuntimeException("Forbidden value on code = " + code + ", it doesn't respect the following condition : code < 0");
    }
    
}
