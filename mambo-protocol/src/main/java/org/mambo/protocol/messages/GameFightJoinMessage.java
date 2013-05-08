

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, canBeCancelled);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, canSayReady);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, isSpectator);
        flag1 = BooleanByteWrapper.setFlag(flag1, 3, isFightStarted);
        buf.writeUByte(flag1);
        buf.writeInt(timeMaxBeforeFightStart);
        buf.writeByte(fightType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        canBeCancelled = BooleanByteWrapper.getFlag(flag1, 0);
        canSayReady = BooleanByteWrapper.getFlag(flag1, 1);
        isSpectator = BooleanByteWrapper.getFlag(flag1, 2);
        isFightStarted = BooleanByteWrapper.getFlag(flag1, 3);
        timeMaxBeforeFightStart = buf.readInt();
        if (timeMaxBeforeFightStart < 0)
            throw new RuntimeException("Forbidden value on timeMaxBeforeFightStart = " + timeMaxBeforeFightStart + ", it doesn't respect the following condition : timeMaxBeforeFightStart < 0");
        fightType = buf.readByte();
        if (fightType < 0)
            throw new RuntimeException("Forbidden value on fightType = " + fightType + ", it doesn't respect the following condition : fightType < 0");
    }
    
}
