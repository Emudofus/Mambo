

// Generated on 11/11/2012 19:17:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(presets.length);
        for (Preset entry : presets) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        presets = new Preset[limit];
        for (int i = 0; i < limit; i++) {
            presets[i] = new Preset();
            presets[i].deserialize(reader);
        }
    }
    
}
