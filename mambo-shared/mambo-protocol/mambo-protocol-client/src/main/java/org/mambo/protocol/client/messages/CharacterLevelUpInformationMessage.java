

// Generated on 12/14/2012 18:44:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterLevelUpInformationMessage extends CharacterLevelUpMessage {
    public static final int MESSAGE_ID = 6076;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    public int id;
    
    public CharacterLevelUpInformationMessage() { }
    
    public CharacterLevelUpInformationMessage(short newLevel, String name, int id) {
        super(newLevel);
        this.name = name;
        this.id = id;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(name);
        writer.writeInt(id);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        name = reader.readString();
        id = reader.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
    }
    
}
