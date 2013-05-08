

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ServerSettingsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6340;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String lang;
    public byte community;
    public byte gameType;
    
    public ServerSettingsMessage() { }
    
    public ServerSettingsMessage(String lang, byte community, byte gameType) {
        this.lang = lang;
        this.community = community;
        this.gameType = gameType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(lang);
        buf.writeByte(community);
        buf.writeByte(gameType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        lang = buf.readString();
        community = buf.readByte();
        if (community < 0)
            throw new RuntimeException("Forbidden value on community = " + community + ", it doesn't respect the following condition : community < 0");
        gameType = buf.readByte();
        if (gameType < 0)
            throw new RuntimeException("Forbidden value on gameType = " + gameType + ", it doesn't respect the following condition : gameType < 0");
    }
    
}
