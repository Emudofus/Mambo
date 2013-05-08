

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightPlacementPossiblePositionsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 703;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] positionsForChallengers;
    public short[] positionsForDefenders;
    public byte teamNumber;
    
    public GameFightPlacementPossiblePositionsMessage() { }
    
    public GameFightPlacementPossiblePositionsMessage(short[] positionsForChallengers, short[] positionsForDefenders, byte teamNumber) {
        this.positionsForChallengers = positionsForChallengers;
        this.positionsForDefenders = positionsForDefenders;
        this.teamNumber = teamNumber;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(positionsForChallengers.length);
        for (short entry : positionsForChallengers) {
            buf.writeShort(entry);
        }
        buf.writeUShort(positionsForDefenders.length);
        for (short entry : positionsForDefenders) {
            buf.writeShort(entry);
        }
        buf.writeByte(teamNumber);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        positionsForChallengers = new short[limit];
        for (int i = 0; i < limit; i++) {
            positionsForChallengers[i] = buf.readShort();
        }
        limit = buf.readUShort();
        positionsForDefenders = new short[limit];
        for (int i = 0; i < limit; i++) {
            positionsForDefenders[i] = buf.readShort();
        }
        teamNumber = buf.readByte();
        if (teamNumber < 0)
            throw new RuntimeException("Forbidden value on teamNumber = " + teamNumber + ", it doesn't respect the following condition : teamNumber < 0");
    }
    
}
