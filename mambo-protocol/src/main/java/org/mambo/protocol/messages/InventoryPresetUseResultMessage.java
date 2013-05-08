

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InventoryPresetUseResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6163;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public byte code;
    public short[] unlinkedPosition;
    
    public InventoryPresetUseResultMessage() { }
    
    public InventoryPresetUseResultMessage(byte presetId, byte code, short[] unlinkedPosition) {
        this.presetId = presetId;
        this.code = code;
        this.unlinkedPosition = unlinkedPosition;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(presetId);
        buf.writeByte(code);
        buf.writeUShort(unlinkedPosition.length);
        for (short entry : unlinkedPosition) {
            buf.writeUByte(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        presetId = buf.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        code = buf.readByte();
        if (code < 0)
            throw new RuntimeException("Forbidden value on code = " + code + ", it doesn't respect the following condition : code < 0");
        int limit = buf.readUShort();
        unlinkedPosition = new short[limit];
        for (int i = 0; i < limit; i++) {
            unlinkedPosition[i] = buf.readUByte();
        }
    }
    
}
