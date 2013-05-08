

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InventoryPresetItemUpdateRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6210;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public short position;
    public int objUid;
    
    public InventoryPresetItemUpdateRequestMessage() { }
    
    public InventoryPresetItemUpdateRequestMessage(byte presetId, short position, int objUid) {
        this.presetId = presetId;
        this.position = position;
        this.objUid = objUid;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(presetId);
        buf.writeUByte(position);
        buf.writeInt(objUid);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        presetId = buf.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        position = buf.readUByte();
        if (position < 0 || position > 255)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 0 || position > 255");
        objUid = buf.readInt();
        if (objUid < 0)
            throw new RuntimeException("Forbidden value on objUid = " + objUid + ", it doesn't respect the following condition : objUid < 0");
    }
    
}
