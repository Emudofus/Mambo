

// Generated on 01/04/2013 14:54:32
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class SpouseInformationsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6356;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public FriendSpouseInformations spouse;
    
    public SpouseInformationsMessage() { }
    
    public SpouseInformationsMessage(FriendSpouseInformations spouse) {
        this.spouse = spouse;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(spouse.getTypeId());
        spouse.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        spouse = ProtocolTypeManager.getInstance().build(reader.readShort(), FriendSpouseInformations.class);
        spouse.deserialize(reader);
    }
    
}
