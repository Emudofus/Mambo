

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InventoryContentAndPresetMessage extends InventoryContentMessage {
    public static final int MESSAGE_ID = 6162;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public Preset[] presets;
    
    public InventoryContentAndPresetMessage() { }
    
    public InventoryContentAndPresetMessage(ObjectItem[] objects, int kamas, Preset[] presets) {
        super(objects, kamas);
        this.presets = presets;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(presets.length);
        for (Preset entry : presets) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        presets = new Preset[limit];
        for (int i = 0; i < limit; i++) {
            presets[i] = new Preset();
            presets[i].deserialize(buf);
        }
    }
    
}
