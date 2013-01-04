

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(serverId);
        writer.writeByte(error);
        writer.writeByte(serverStatus);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        serverId = reader.readShort();
        error = reader.readByte();
        if (error < 0)
            throw new RuntimeException("Forbidden value on error = " + error + ", it doesn't respect the following condition : error < 0");
        serverStatus = reader.readByte();
        if (serverStatus < 0)
            throw new RuntimeException("Forbidden value on serverStatus = " + serverStatus + ", it doesn't respect the following condition : serverStatus < 0");
    }
    
}
