

// Generated on 05/08/2013 19:37:49
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(dungeonId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        dungeonId = buf.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
    }
    
}
