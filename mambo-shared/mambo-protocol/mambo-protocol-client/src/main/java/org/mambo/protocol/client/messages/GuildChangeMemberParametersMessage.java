

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(memberId);
        writer.writeShort(rank);
        writer.writeByte(experienceGivenPercent);
        writer.writeUnsignedInt(rights);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        memberId = reader.readInt();
        if (memberId < 0)
            throw new RuntimeException("Forbidden value on memberId = " + memberId + ", it doesn't respect the following condition : memberId < 0");
        rank = reader.readShort();
        if (rank < 0)
            throw new RuntimeException("Forbidden value on rank = " + rank + ", it doesn't respect the following condition : rank < 0");
        experienceGivenPercent = reader.readByte();
        if (experienceGivenPercent < 0 || experienceGivenPercent > 100)
            throw new RuntimeException("Forbidden value on experienceGivenPercent = " + experienceGivenPercent + ", it doesn't respect the following condition : experienceGivenPercent < 0 || experienceGivenPercent > 100");
        rights = reader.readUnsignedInt();
        if (rights < 0 || rights > 4294967295L)
            throw new RuntimeException("Forbidden value on rights = " + rights + ", it doesn't respect the following condition : rights < 0 || rights > 4294967295L");
    }
    
}
