

// Generated on 12/14/2012 18:44:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CompassUpdatePvpSeekMessage extends CompassUpdateMessage {
    public static final int MESSAGE_ID = 6013;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int memberId;
    public String memberName;
    
    public CompassUpdatePvpSeekMessage() { }
    
    public CompassUpdatePvpSeekMessage(byte type, short worldX, short worldY, int memberId, String memberName) {
        super(type, worldX, worldY);
        this.memberId = memberId;
        this.memberName = memberName;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(memberId);
        writer.writeString(memberName);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        memberId = reader.readInt();
        if (memberId < 0)
            throw new RuntimeException("Forbidden value on memberId = " + memberId + ", it doesn't respect the following condition : memberId < 0");
        memberName = reader.readString();
    }
    
}
