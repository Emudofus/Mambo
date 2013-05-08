

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PartyGuestInformations extends NetworkType {
    public static final short TYPE_ID = 374;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int guestId;
    public int hostId;
    public String name;
    public EntityLook guestLook;
    public byte breed;
    public boolean sex;
    public PlayerStatus status;
    
    public PartyGuestInformations() { }
    
    public PartyGuestInformations(int guestId, int hostId, String name, EntityLook guestLook, byte breed, boolean sex, PlayerStatus status) {
        this.guestId = guestId;
        this.hostId = hostId;
        this.name = name;
        this.guestLook = guestLook;
        this.breed = breed;
        this.sex = sex;
        this.status = status;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(guestId);
        buf.writeInt(hostId);
        buf.writeString(name);
        guestLook.serialize(buf);
        buf.writeByte(breed);
        buf.writeBoolean(sex);
        buf.writeShort(status.getTypeId());
        status.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        guestId = buf.readInt();
        if (guestId < 0)
            throw new RuntimeException("Forbidden value on guestId = " + guestId + ", it doesn't respect the following condition : guestId < 0");
        hostId = buf.readInt();
        if (hostId < 0)
            throw new RuntimeException("Forbidden value on hostId = " + hostId + ", it doesn't respect the following condition : hostId < 0");
        name = buf.readString();
        guestLook = new EntityLook();
        guestLook.deserialize(buf);
        breed = buf.readByte();
        sex = buf.readBoolean();
        status = ProtocolTypeManager.getInstance().build(buf.readShort());
        status.deserialize(buf);
    }
    
}
