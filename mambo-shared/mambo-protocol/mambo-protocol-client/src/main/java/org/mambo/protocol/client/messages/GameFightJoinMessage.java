

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightJoinMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 702;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean canBeCancelled;
    public boolean canSayReady;
    public boolean isSpectator;
    public boolean isFightStarted;
    public int timeMaxBeforeFightStart;
    public byte fightType;
    
    public GameFightJoinMessage() { }
    
    public GameFightJoinMessage(boolean canBeCancelled, boolean canSayReady, boolean isSpectator, boolean isFightStarted, int timeMaxBeforeFightStart, byte fightType) {
        this.canBeCancelled = canBeCancelled;
        this.canSayReady = canSayReady;
        this.isSpectator = isSpectator;
        this.isFightStarted = isFightStarted;
        this.timeMaxBeforeFightStart = timeMaxBeforeFightStart;
        this.fightType = fightType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, canBeCancelled);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, canSayReady);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, isSpectator);
        flag1 = BooleanByteWrapper.setFlag(flag1, 3, isFightStarted);
        writer.writeUnsignedByte(flag1);
        writer.writeInt(timeMaxBeforeFightStart);
        writer.writeByte(fightType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        canBeCancelled = BooleanByteWrapper.getFlag(flag1, 0);
        canSayReady = BooleanByteWrapper.getFlag(flag1, 1);
        isSpectator = BooleanByteWrapper.getFlag(flag1, 2);
        isFightStarted = BooleanByteWrapper.getFlag(flag1, 3);
        timeMaxBeforeFightStart = reader.readInt();
        if (timeMaxBeforeFightStart < 0)
            throw new RuntimeException("Forbidden value on timeMaxBeforeFightStart = " + timeMaxBeforeFightStart + ", it doesn't respect the following condition : timeMaxBeforeFightStart < 0");
        fightType = reader.readByte();
        if (fightType < 0)
            throw new RuntimeException("Forbidden value on fightType = " + fightType + ", it doesn't respect the following condition : fightType < 0");
    }
    
}
