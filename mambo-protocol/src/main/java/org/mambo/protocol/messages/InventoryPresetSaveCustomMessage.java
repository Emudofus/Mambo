

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InventoryPresetSaveCustomMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6329;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public byte symbolId;
    public short[] itemsPositions;
    public int[] itemsUids;
    
    public InventoryPresetSaveCustomMessage() { }
    
    public InventoryPresetSaveCustomMessage(byte presetId, byte symbolId, short[] itemsPositions, int[] itemsUids) {
        this.presetId = presetId;
        this.symbolId = symbolId;
        this.itemsPositions = itemsPositions;
        this.itemsUids = itemsUids;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(presetId);
        buf.writeByte(symbolId);
        buf.writeUShort(itemsPositions.length);
        for (short entry : itemsPositions) {
            buf.writeUByte(entry);
        }
        buf.writeUShort(itemsUids.length);
        for (int entry : itemsUids) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        presetId = buf.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        symbolId = buf.readByte();
        if (symbolId < 0)
            throw new RuntimeException("Forbidden value on symbolId = " + symbolId + ", it doesn't respect the following condition : symbolId < 0");
        int limit = buf.readUShort();
        itemsPositions = new short[limit];
        for (int i = 0; i < limit; i++) {
            itemsPositions[i] = buf.readUByte();
        }
        limit = buf.readUShort();
        itemsUids = new int[limit];
        for (int i = 0; i < limit; i++) {
            itemsUids[i] = buf.readInt();
        }
    }
    
}
