

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class CompassUpdatePartyMemberMessage extends CompassUpdateMessage {
    public static final int MESSAGE_ID = 5589;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int memberId;
    
    public CompassUpdatePartyMemberMessage() { }
    
    public CompassUpdatePartyMemberMessage(byte type, short worldX, short worldY, int memberId) {
        super(type, worldX, worldY);
        this.memberId = memberId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(memberId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        memberId = reader.readInt();
        if (memberId < 0)
            throw new RuntimeException("Forbidden value on memberId = " + memberId + ", it doesn't respect the following condition : memberId < 0");
    }
    
}
