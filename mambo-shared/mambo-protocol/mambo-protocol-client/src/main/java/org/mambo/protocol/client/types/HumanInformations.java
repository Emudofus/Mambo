

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HumanInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 157;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public EntityLook[] followingCharactersLook;
    public byte emoteId;
    public double emoteStartTime;
    public ActorRestrictionsInformations restrictions;
    public short titleId;
    public String titleParam;
    
    public HumanInformations() { }
    
    public HumanInformations(EntityLook[] followingCharactersLook, byte emoteId, double emoteStartTime, ActorRestrictionsInformations restrictions, short titleId, String titleParam) {
        this.followingCharactersLook = followingCharactersLook;
        this.emoteId = emoteId;
        this.emoteStartTime = emoteStartTime;
        this.restrictions = restrictions;
        this.titleId = titleId;
        this.titleParam = titleParam;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(followingCharactersLook.length);
        for (EntityLook entry : followingCharactersLook) {
            entry.serialize(writer);
        }
        writer.writeByte(emoteId);
        writer.writeDouble(emoteStartTime);
        restrictions.serialize(writer);
        writer.writeShort(titleId);
        writer.writeString(titleParam);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        followingCharactersLook = new EntityLook[limit];
        for (int i = 0; i < limit; i++) {
            followingCharactersLook[i] = new EntityLook();
            followingCharactersLook[i].deserialize(reader);
        }
        emoteId = reader.readByte();
        emoteStartTime = reader.readDouble();
        restrictions = new ActorRestrictionsInformations();
        restrictions.deserialize(reader);
        titleId = reader.readShort();
        if (titleId < 0)
            throw new RuntimeException("Forbidden value on titleId = " + titleId + ", it doesn't respect the following condition : titleId < 0");
        titleParam = reader.readString();
    }
    
}
