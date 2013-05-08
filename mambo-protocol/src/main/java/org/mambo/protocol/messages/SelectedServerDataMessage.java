

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SelectedServerDataMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 42;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short serverId;
    public String address;
    public int port;
    public boolean canCreateNewCharacter;
    public String ticket;
    
    public SelectedServerDataMessage() { }
    
    public SelectedServerDataMessage(short serverId, String address, int port, boolean canCreateNewCharacter, String ticket) {
        this.serverId = serverId;
        this.address = address;
        this.port = port;
        this.canCreateNewCharacter = canCreateNewCharacter;
        this.ticket = ticket;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(serverId);
        buf.writeString(address);
        buf.writeUShort(port);
        buf.writeBoolean(canCreateNewCharacter);
        buf.writeString(ticket);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        serverId = buf.readShort();
        address = buf.readString();
        port = buf.readUShort();
        if (port < 0 || port > 65535)
            throw new RuntimeException("Forbidden value on port = " + port + ", it doesn't respect the following condition : port < 0 || port > 65535");
        canCreateNewCharacter = buf.readBoolean();
        ticket = buf.readString();
    }
    
}
