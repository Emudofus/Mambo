

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class EntityLook implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 55;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short bonesId;
    public short[] skins;
    public int[] indexedColors;
    public short[] scales;
    public SubEntity[] subentities;
    
    public EntityLook() { }
    
    public EntityLook(short bonesId, short[] skins, int[] indexedColors, short[] scales, SubEntity[] subentities) {
        this.bonesId = bonesId;
        this.skins = skins;
        this.indexedColors = indexedColors;
        this.scales = scales;
        this.subentities = subentities;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(bonesId);
        writer.writeUnsignedShort(skins.length);
        for (short entry : skins) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(indexedColors.length);
        for (int entry : indexedColors) {
            writer.writeInt(entry);
        }
        writer.writeUnsignedShort(scales.length);
        for (short entry : scales) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(subentities.length);
        for (SubEntity entry : subentities) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        bonesId = reader.readShort();
        if (bonesId < 0)
            throw new RuntimeException("Forbidden value on bonesId = " + bonesId + ", it doesn't respect the following condition : bonesId < 0");
        int limit = reader.readUnsignedShort();
        skins = new short[limit];
        for (int i = 0; i < limit; i++) {
            skins[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        indexedColors = new int[limit];
        for (int i = 0; i < limit; i++) {
            indexedColors[i] = reader.readInt();
        }
        limit = reader.readUnsignedShort();
        scales = new short[limit];
        for (int i = 0; i < limit; i++) {
            scales[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        subentities = new SubEntity[limit];
        for (int i = 0; i < limit; i++) {
            subentities[i] = new SubEntity();
            subentities[i].deserialize(reader);
        }
    }
    
}
