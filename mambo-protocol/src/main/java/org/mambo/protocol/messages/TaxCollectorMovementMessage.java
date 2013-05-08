

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TaxCollectorMovementMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5633;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean hireOrFire;
    public TaxCollectorBasicInformations basicInfos;
    public int playerId;
    public String playerName;
    
    public TaxCollectorMovementMessage() { }
    
    public TaxCollectorMovementMessage(boolean hireOrFire, TaxCollectorBasicInformations basicInfos, int playerId, String playerName) {
        this.hireOrFire = hireOrFire;
        this.basicInfos = basicInfos;
        this.playerId = playerId;
        this.playerName = playerName;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(hireOrFire);
        basicInfos.serialize(buf);
        buf.writeInt(playerId);
        buf.writeString(playerName);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        hireOrFire = buf.readBoolean();
        basicInfos = new TaxCollectorBasicInformations();
        basicInfos.deserialize(buf);
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
        playerName = buf.readString();
    }
    
}
