

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PaddockContentInformations extends PaddockInformations {
    public static final short TYPE_ID = 183;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int paddockId;
    public short worldX;
    public short worldY;
    public int mapId;
    public short subAreaId;
    public boolean abandonned;
    public MountInformationsForPaddock[] mountsInformations;
    
    public PaddockContentInformations() { }
    
    public PaddockContentInformations(short maxOutdoorMount, short maxItems, int paddockId, short worldX, short worldY, int mapId, short subAreaId, boolean abandonned, MountInformationsForPaddock[] mountsInformations) {
        super(maxOutdoorMount, maxItems);
        this.paddockId = paddockId;
        this.worldX = worldX;
        this.worldY = worldY;
        this.mapId = mapId;
        this.subAreaId = subAreaId;
        this.abandonned = abandonned;
        this.mountsInformations = mountsInformations;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(paddockId);
        buf.writeShort(worldX);
        buf.writeShort(worldY);
        buf.writeInt(mapId);
        buf.writeShort(subAreaId);
        buf.writeBoolean(abandonned);
        buf.writeUShort(mountsInformations.length);
        for (MountInformationsForPaddock entry : mountsInformations) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        paddockId = buf.readInt();
        worldX = buf.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = buf.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        mapId = buf.readInt();
        subAreaId = buf.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        abandonned = buf.readBoolean();
        int limit = buf.readUShort();
        mountsInformations = new MountInformationsForPaddock[limit];
        for (int i = 0; i < limit; i++) {
            mountsInformations[i] = new MountInformationsForPaddock();
            mountsInformations[i].deserialize(buf);
        }
    }
    
}
