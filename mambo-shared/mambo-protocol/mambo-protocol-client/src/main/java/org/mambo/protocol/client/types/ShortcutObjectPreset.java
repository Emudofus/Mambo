

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class ShortcutObjectPreset extends ShortcutObject {
    public static final short TYPE_ID = 370;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte presetId;
    
    public ShortcutObjectPreset() { }
    
    public ShortcutObjectPreset(int slot, byte presetId) {
        super(slot);
        this.presetId = presetId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(presetId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        presetId = reader.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
    }
    
}
