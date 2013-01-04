

// Generated on 01/04/2013 14:54:21
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
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
    public int cosmeticId;
    
    public CharacterCreationRequestMessage() { }
    
    public CharacterCreationRequestMessage(String name, byte breed, boolean sex, int[] colors, int cosmeticId) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.colors = colors;
        this.cosmeticId = cosmeticId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(name);
        writer.writeByte(breed);
        writer.writeBoolean(sex);
        for (int entry : colors) {
            writer.writeInt(entry);
        }
        writer.writeInt(cosmeticId);
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
        cosmeticId = reader.readInt();
        if (cosmeticId < 0)
            throw new RuntimeException("Forbidden value on cosmeticId = " + cosmeticId + ", it doesn't respect the following condition : cosmeticId < 0");
    }
    
}
