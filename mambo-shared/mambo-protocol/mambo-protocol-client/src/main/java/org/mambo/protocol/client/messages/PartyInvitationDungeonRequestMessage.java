

// Generated on 11/11/2012 19:17:05
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PartyInvitationDungeonRequestMessage extends PartyInvitationRequestMessage {
    public static final int MESSAGE_ID = 6245;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    
    public PartyInvitationDungeonRequestMessage() { }
    
    public PartyInvitationDungeonRequestMessage(String name, short dungeonId) {
        super(name);
        this.dungeonId = dungeonId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(dungeonId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        dungeonId = reader.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
    }
    
}
