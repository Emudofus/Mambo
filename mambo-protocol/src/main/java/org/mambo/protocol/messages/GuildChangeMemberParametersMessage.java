

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildChangeMemberParametersMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5549;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int memberId;
    public short rank;
    public byte experienceGivenPercent;
    public long rights;
    
    public GuildChangeMemberParametersMessage() { }
    
    public GuildChangeMemberParametersMessage(int memberId, short rank, byte experienceGivenPercent, long rights) {
        this.memberId = memberId;
        this.rank = rank;
        this.experienceGivenPercent = experienceGivenPercent;
        this.rights = rights;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(memberId);
        buf.writeShort(rank);
        buf.writeByte(experienceGivenPercent);
        buf.writeUInt(rights);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        memberId = buf.readInt();
        if (memberId < 0)
            throw new RuntimeException("Forbidden value on memberId = " + memberId + ", it doesn't respect the following condition : memberId < 0");
        rank = buf.readShort();
        if (rank < 0)
            throw new RuntimeException("Forbidden value on rank = " + rank + ", it doesn't respect the following condition : rank < 0");
        experienceGivenPercent = buf.readByte();
        if (experienceGivenPercent < 0 || experienceGivenPercent > 100)
            throw new RuntimeException("Forbidden value on experienceGivenPercent = " + experienceGivenPercent + ", it doesn't respect the following condition : experienceGivenPercent < 0 || experienceGivenPercent > 100");
        rights = buf.readUInt();
        if (rights < 0 || rights > 4294967295L)
            throw new RuntimeException("Forbidden value on rights = " + rights + ", it doesn't respect the following condition : rights < 0 || rights > 4294967295L");
    }
    
}
