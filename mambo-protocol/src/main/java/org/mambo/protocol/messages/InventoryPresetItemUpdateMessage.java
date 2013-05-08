

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InventoryPresetItemUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6168;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public PresetItem presetItem;
    
    public InventoryPresetItemUpdateMessage() { }
    
    public InventoryPresetItemUpdateMessage(byte presetId, PresetItem presetItem) {
        this.presetId = presetId;
        this.presetItem = presetItem;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(presetId);
        presetItem.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        presetId = buf.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        presetItem = new PresetItem();
        presetItem.deserialize(buf);
    }
    
}
