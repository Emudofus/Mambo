

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        preset.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        preset = new Preset();
        preset.deserialize(reader);
    }
    
}
