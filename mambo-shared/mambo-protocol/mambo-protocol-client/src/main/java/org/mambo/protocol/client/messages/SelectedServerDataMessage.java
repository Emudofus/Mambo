

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(serverId);
        writer.writeString(address);
        writer.writeUnsignedShort(port);
        writer.writeBoolean(canCreateNewCharacter);
        writer.writeString(ticket);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        serverId = reader.readShort();
        address = reader.readString();
        port = reader.readUnsignedShort();
        if (port < 0 || port > 65535)
            throw new RuntimeException("Forbidden value on port = " + port + ", it doesn't respect the following condition : port < 0 || port > 65535");
        canCreateNewCharacter = reader.readBoolean();
        ticket = reader.readString();
    }
    
}
