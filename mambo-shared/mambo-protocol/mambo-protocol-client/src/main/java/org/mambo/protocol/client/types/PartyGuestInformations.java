

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PartyGuestInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 374;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int guestId;
    public int hostId;
    public String name;
    public EntityLook guestLook;
    public byte breed;
    public boolean sex;
    
    public PartyGuestInformations() { }
    
    public PartyGuestInformations(int guestId, int hostId, String name, EntityLook guestLook, byte breed, boolean sex) {
        this.guestId = guestId;
        this.hostId = hostId;
        this.name = name;
        this.guestLook = guestLook;
        this.breed = breed;
        this.sex = sex;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(guestId);
        writer.writeInt(hostId);
        writer.writeString(name);
        guestLook.serialize(writer);
        writer.writeByte(breed);
        writer.writeBoolean(sex);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        guestId = reader.readInt();
        if (guestId < 0)
            throw new RuntimeException("Forbidden value on guestId = " + guestId + ", it doesn't respect the following condition : guestId < 0");
        hostId = reader.readInt();
        if (hostId < 0)
            throw new RuntimeException("Forbidden value on hostId = " + hostId + ", it doesn't respect the following condition : hostId < 0");
        name = reader.readString();
        guestLook = new EntityLook();
        guestLook.deserialize(reader);
        breed = reader.readByte();
        sex = reader.readBoolean();
    }
    
}
