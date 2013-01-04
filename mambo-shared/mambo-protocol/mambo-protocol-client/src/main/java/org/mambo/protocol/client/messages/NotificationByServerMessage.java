

// Generated on 01/04/2013 14:54:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class NotificationByServerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6103;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int id;
    public String[] parameters;
    public boolean forceOpen;
    
    public NotificationByServerMessage() { }
    
    public NotificationByServerMessage(int id, String[] parameters, boolean forceOpen) {
        this.id = id;
        this.parameters = parameters;
        this.forceOpen = forceOpen;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(id);
        writer.writeUnsignedShort(parameters.length);
        for (String entry : parameters) {
            writer.writeString(entry);
        }
        writer.writeBoolean(forceOpen);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readUnsignedShort();
        if (id < 0 || id > 65535)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0 || id > 65535");
        int limit = reader.readUnsignedShort();
        parameters = new String[limit];
        for (int i = 0; i < limit; i++) {
            parameters[i] = reader.readString();
        }
        forceOpen = reader.readBoolean();
    }
    
}
