

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(paddockId);
        writer.writeShort(worldX);
        writer.writeShort(worldY);
        writer.writeInt(mapId);
        writer.writeShort(subAreaId);
        writer.writeBoolean(abandonned);
        writer.writeUnsignedShort(mountsInformations.length);
        for (MountInformationsForPaddock entry : mountsInformations) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        paddockId = reader.readInt();
        worldX = reader.readShort();
        if (worldX < -255 || worldX > 255)
            throw new RuntimeException("Forbidden value on worldX = " + worldX + ", it doesn't respect the following condition : worldX < -255 || worldX > 255");
        worldY = reader.readShort();
        if (worldY < -255 || worldY > 255)
            throw new RuntimeException("Forbidden value on worldY = " + worldY + ", it doesn't respect the following condition : worldY < -255 || worldY > 255");
        mapId = reader.readInt();
        subAreaId = reader.readShort();
        if (subAreaId < 0)
            throw new RuntimeException("Forbidden value on subAreaId = " + subAreaId + ", it doesn't respect the following condition : subAreaId < 0");
        abandonned = reader.readBoolean();
        int limit = reader.readUnsignedShort();
        mountsInformations = new MountInformationsForPaddock[limit];
        for (int i = 0; i < limit; i++) {
            mountsInformations[i] = new MountInformationsForPaddock();
            mountsInformations[i].deserialize(reader);
        }
    }
    
}
