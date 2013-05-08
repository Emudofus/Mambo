

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class EntityLook extends NetworkType {
    public static final short TYPE_ID = 55;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeShort(bonesId);
        buf.writeUShort(skins.length);
        for (short entry : skins) {
            buf.writeShort(entry);
        }
        buf.writeUShort(indexedColors.length);
        for (int entry : indexedColors) {
            buf.writeInt(entry);
        }
        buf.writeUShort(scales.length);
        for (short entry : scales) {
            buf.writeShort(entry);
        }
        buf.writeUShort(subentities.length);
        for (SubEntity entry : subentities) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        bonesId = buf.readShort();
        if (bonesId < 0)
            throw new RuntimeException("Forbidden value on bonesId = " + bonesId + ", it doesn't respect the following condition : bonesId < 0");
        int limit = buf.readUShort();
        skins = new short[limit];
        for (int i = 0; i < limit; i++) {
            skins[i] = buf.readShort();
        }
        limit = buf.readUShort();
        indexedColors = new int[limit];
        for (int i = 0; i < limit; i++) {
            indexedColors[i] = buf.readInt();
        }
        limit = buf.readUShort();
        scales = new short[limit];
        for (int i = 0; i < limit; i++) {
            scales[i] = buf.readShort();
        }
        limit = buf.readUShort();
        subentities = new SubEntity[limit];
        for (int i = 0; i < limit; i++) {
            subentities[i] = new SubEntity();
            subentities[i].deserialize(buf);
        }
    }
    
}
