

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class CharacterLevelUpInformationMessage extends CharacterLevelUpMessage {
    public static final int MESSAGE_ID = 6076;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    public int id;
    public byte relationType;
    
    public CharacterLevelUpInformationMessage() { }
    
    public CharacterLevelUpInformationMessage(short newLevel, String name, int id, byte relationType) {
        super(newLevel);
        this.name = name;
        this.id = id;
        this.relationType = relationType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(name);
        writer.writeInt(id);
        writer.writeByte(relationType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        name = reader.readString();
        id = reader.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        relationType = reader.readByte();
    }
    
}
