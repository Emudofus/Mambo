

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class Preset extends NetworkType {
    public static final short TYPE_ID = 355;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte presetId;
    public byte symbolId;
    public boolean mount;
    public PresetItem[] objects;
    
    public Preset() { }
    
    public Preset(byte presetId, byte symbolId, boolean mount, PresetItem[] objects) {
        this.presetId = presetId;
        this.symbolId = symbolId;
        this.mount = mount;
        this.objects = objects;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(presetId);
        buf.writeByte(symbolId);
        buf.writeBoolean(mount);
        buf.writeUShort(objects.length);
        for (PresetItem entry : objects) {
            entry.serialize(buf);
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
        mount = buf.readBoolean();
        int limit = buf.readUShort();
        objects = new PresetItem[limit];
        for (int i = 0; i < limit; i++) {
            objects[i] = new PresetItem();
            objects[i].deserialize(buf);
        }
    }
    
}
