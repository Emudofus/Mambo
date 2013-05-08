

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class BasicGuildInformations extends NetworkType {
    public static final short TYPE_ID = 365;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(guildId);
        buf.writeString(guildName);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        guildId = buf.readInt();
        if (guildId < 0)
            throw new RuntimeException("Forbidden value on guildId = " + guildId + ", it doesn't respect the following condition : guildId < 0");
        guildName = buf.readString();
    }
    
}
