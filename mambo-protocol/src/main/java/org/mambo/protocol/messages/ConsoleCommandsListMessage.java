

// Generated on 05/08/2013 19:37:37
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ConsoleCommandsListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6127;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String[] aliases;
    public String[] arguments;
    public String[] descriptions;
    
    public ConsoleCommandsListMessage() { }
    
    public ConsoleCommandsListMessage(String[] aliases, String[] arguments, String[] descriptions) {
        this.aliases = aliases;
        this.arguments = arguments;
        this.descriptions = descriptions;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(aliases.length);
        for (String entry : aliases) {
            buf.writeString(entry);
        }
        buf.writeUShort(arguments.length);
        for (String entry : arguments) {
            buf.writeString(entry);
        }
        buf.writeUShort(descriptions.length);
        for (String entry : descriptions) {
            buf.writeString(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        aliases = new String[limit];
        for (int i = 0; i < limit; i++) {
            aliases[i] = buf.readString();
        }
        limit = buf.readUShort();
        arguments = new String[limit];
        for (int i = 0; i < limit; i++) {
            arguments[i] = buf.readString();
        }
        limit = buf.readUShort();
        descriptions = new String[limit];
        for (int i = 0; i < limit; i++) {
            descriptions[i] = buf.readString();
        }
    }
    
}
