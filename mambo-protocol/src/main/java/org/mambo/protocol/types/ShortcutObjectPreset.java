

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(presetId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        presetId = buf.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
    }
    
}
