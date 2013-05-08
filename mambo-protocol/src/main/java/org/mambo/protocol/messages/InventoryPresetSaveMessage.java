

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InventoryPresetSaveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6165;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public byte symbolId;
    public boolean saveEquipment;
    
    public InventoryPresetSaveMessage() { }
    
    public InventoryPresetSaveMessage(byte presetId, byte symbolId, boolean saveEquipment) {
        this.presetId = presetId;
        this.symbolId = symbolId;
        this.saveEquipment = saveEquipment;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(presetId);
        buf.writeByte(symbolId);
        buf.writeBoolean(saveEquipment);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        presetId = buf.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        symbolId = buf.readByte();
        if (symbolId < 0)
            throw new RuntimeException("Forbidden value on symbolId = " + symbolId + ", it doesn't respect the following condition : symbolId < 0");
        saveEquipment = buf.readBoolean();
    }
    
}
