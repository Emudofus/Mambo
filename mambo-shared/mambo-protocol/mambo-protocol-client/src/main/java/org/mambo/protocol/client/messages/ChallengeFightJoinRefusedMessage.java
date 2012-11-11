

// Generated on 11/11/2012 20:41:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ChallengeFightJoinRefusedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5908;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int playerId;
    public byte reason;
    
    public ChallengeFightJoinRefusedMessage() { }
    
    public ChallengeFightJoinRefusedMessage(int playerId, byte reason) {
        this.playerId = playerId;
        this.reason = reason;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(playerId);
        writer.writeByte(reason);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        reason = reader.readByte();
    }
    
}
