

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ShowCellSpectatorMessage extends ShowCellMessage {
    public static final int MESSAGE_ID = 6158;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String playerName;
    
    public ShowCellSpectatorMessage() { }
    
    public ShowCellSpectatorMessage(int sourceId, short cellId, String playerName) {
        super(sourceId, cellId);
        this.playerName = playerName;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(playerName);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        playerName = buf.readString();
    }
    
}
