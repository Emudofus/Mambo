

// Generated on 01/04/2013 14:54:48
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class Preset implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 355;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(presetId);
        writer.writeByte(symbolId);
        writer.writeBoolean(mount);
        writer.writeUnsignedShort(objects.length);
        for (PresetItem entry : objects) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        presetId = reader.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        symbolId = reader.readByte();
        if (symbolId < 0)
            throw new RuntimeException("Forbidden value on symbolId = " + symbolId + ", it doesn't respect the following condition : symbolId < 0");
        mount = reader.readBoolean();
        int limit = reader.readUnsignedShort();
        objects = new PresetItem[limit];
        for (int i = 0; i < limit; i++) {
            objects[i] = new PresetItem();
            objects[i].deserialize(reader);
        }
    }
    
}
