

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class BasicGuildInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 365;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int guildId;
    public String guildName;
    
    public BasicGuildInformations() { }
    
    public BasicGuildInformations(int guildId, String guildName) {
        this.guildId = guildId;
        this.guildName = guildName;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(guildId);
        writer.writeString(guildName);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        guildId = reader.readInt();
        if (guildId < 0)
            throw new RuntimeException("Forbidden value on guildId = " + guildId + ", it doesn't respect the following condition : guildId < 0");
        guildName = reader.readString();
    }
    
}
