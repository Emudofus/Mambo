

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SelectedServerRefusedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 41;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short serverId;
    public byte error;
    public byte serverStatus;
    
    public SelectedServerRefusedMessage() { }
    
    public SelectedServerRefusedMessage(short serverId, byte error, byte serverStatus) {
        this.serverId = serverId;
        this.error = error;
        this.serverStatus = serverStatus;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(serverId);
        buf.writeByte(error);
        buf.writeByte(serverStatus);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        serverId = buf.readShort();
        error = buf.readByte();
        if (error < 0)
            throw new RuntimeException("Forbidden value on error = " + error + ", it doesn't respect the following condition : error < 0");
        serverStatus = buf.readByte();
        if (serverStatus < 0)
            throw new RuntimeException("Forbidden value on serverStatus = " + serverStatus + ", it doesn't respect the following condition : serverStatus < 0");
    }
    
}
