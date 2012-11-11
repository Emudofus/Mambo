

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyGuestInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 374;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int guestId;
    public int hostId;
    public String name;
    public EntityLook guestLook;
    
    public PartyGuestInformations() { }
    
    public PartyGuestInformations(int guestId, int hostId, String name, EntityLook guestLook) {
        this.guestId = guestId;
        this.hostId = hostId;
        this.name = name;
        this.guestLook = guestLook;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(guestId);
        writer.writeInt(hostId);
        writer.writeString(name);
        guestLook.serialize(writer);
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
    }
    
}
