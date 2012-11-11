

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FriendsListWithSpouseMessage extends FriendsListMessage {
    public static final int MESSAGE_ID = 5931;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public FriendSpouseInformations spouse;
    
    public FriendsListWithSpouseMessage() { }
    
    public FriendsListWithSpouseMessage(FriendInformations[] friendsList, FriendSpouseInformations spouse) {
        super(friendsList);
        this.spouse = spouse;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(spouse.getTypeId());
        spouse.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        spouse = ProtocolTypeManager.getInstance().build(reader.readShort(), FriendSpouseInformations.class);
        spouse.deserialize(reader);
    }
    
}
