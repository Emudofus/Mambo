

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightOptionStateUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5927;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short fightId;
    public byte teamId;
    public byte option;
    public boolean state;
    
    public GameFightOptionStateUpdateMessage() { }
    
    public GameFightOptionStateUpdateMessage(short fightId, byte teamId, byte option, boolean state) {
        this.fightId = fightId;
        this.teamId = teamId;
        this.option = option;
        this.state = state;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(fightId);
        writer.writeByte(teamId);
        writer.writeByte(option);
        writer.writeBoolean(state);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readShort();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        teamId = reader.readByte();
        if (teamId < 0)
            throw new RuntimeException("Forbidden value on teamId = " + teamId + ", it doesn't respect the following condition : teamId < 0");
        option = reader.readByte();
        if (option < 0)
            throw new RuntimeException("Forbidden value on option = " + option + ", it doesn't respect the following condition : option < 0");
        state = reader.readBoolean();
    }
    
}
