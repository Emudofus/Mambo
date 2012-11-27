

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterCreationRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 160;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    public byte breed;
    public boolean sex;
    public int[] colors;
    
    public CharacterCreationRequestMessage() { }
    
    public CharacterCreationRequestMessage(String name, byte breed, boolean sex, int[] colors) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.colors = colors;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(name);
        writer.writeByte(breed);
        writer.writeBoolean(sex);
        for (int entry : colors) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        name = reader.readString();
        breed = reader.readByte();
        if (breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value())
            throw new RuntimeException("Forbidden value on breed = " + breed + ", it doesn't respect the following condition : breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value()");
        sex = reader.readBoolean();
        colors = new int[5];
        for (int i = 0; i < 5; i++) {
            colors[i] = reader.readInt();
        }
    }
    
}
