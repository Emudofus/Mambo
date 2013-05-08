

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(id);
        buf.writeUShort(parameters.length);
        for (String entry : parameters) {
            buf.writeString(entry);
        }
        buf.writeBoolean(forceOpen);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readUShort();
        if (id < 0 || id > 65535)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0 || id > 65535");
        int limit = buf.readUShort();
        parameters = new String[limit];
        for (int i = 0; i < limit; i++) {
            parameters[i] = buf.readString();
        }
        forceOpen = buf.readBoolean();
    }
    
}
