

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InventoryPresetUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6171;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public Preset preset;
    
    public InventoryPresetUpdateMessage() { }
    
    public InventoryPresetUpdateMessage(Preset preset) {
        this.preset = preset;
    }
    
    @Override
    public void serialize(Buffer buf) {
        preset.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        preset = new Preset();
        preset.deserialize(buf);
    }
    
}
