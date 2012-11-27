

// Generated on 11/11/2012 20:41:21
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(aliases.length);
        for (String entry : aliases) {
            writer.writeString(entry);
        }
        writer.writeUnsignedShort(arguments.length);
        for (String entry : arguments) {
            writer.writeString(entry);
        }
        writer.writeUnsignedShort(descriptions.length);
        for (String entry : descriptions) {
            writer.writeString(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        aliases = new String[limit];
        for (int i = 0; i < limit; i++) {
            aliases[i] = reader.readString();
        }
        limit = reader.readUnsignedShort();
        arguments = new String[limit];
        for (int i = 0; i < limit; i++) {
            arguments[i] = reader.readString();
        }
        limit = reader.readUnsignedShort();
        descriptions = new String[limit];
        for (int i = 0; i < limit; i++) {
            descriptions[i] = reader.readString();
        }
    }
    
}
