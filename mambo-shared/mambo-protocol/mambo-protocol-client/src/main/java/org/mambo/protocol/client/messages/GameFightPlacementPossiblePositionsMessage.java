

// Generated on 01/04/2013 14:54:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(positionsForChallengers.length);
        for (short entry : positionsForChallengers) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(positionsForDefenders.length);
        for (short entry : positionsForDefenders) {
            writer.writeShort(entry);
        }
        writer.writeByte(teamNumber);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        positionsForChallengers = new short[limit];
        for (int i = 0; i < limit; i++) {
            positionsForChallengers[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        positionsForDefenders = new short[limit];
        for (int i = 0; i < limit; i++) {
            positionsForDefenders[i] = reader.readShort();
        }
        teamNumber = reader.readByte();
        if (teamNumber < 0)
            throw new RuntimeException("Forbidden value on teamNumber = " + teamNumber + ", it doesn't respect the following condition : teamNumber < 0");
    }
    
}
