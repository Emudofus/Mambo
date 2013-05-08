

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeString(name);
        buf.writeByte(breed);
        buf.writeBoolean(sex);
        for (int entry : colors) {
            buf.writeInt(entry);
        }
        buf.writeInt(cosmeticId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        name = buf.readString();
        breed = buf.readByte();
        if (breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value())
            throw new RuntimeException("Forbidden value on breed = " + breed + ", it doesn't respect the following condition : breed < PlayableBreedEnum.Feca.value() || breed > PlayableBreedEnum.Steamer.value()");
        sex = buf.readBoolean();
        colors = new int[5];
        for (int i = 0; i < 5; i++) {
            colors[i] = buf.readInt();
        }
        cosmeticId = buf.readInt();
        if (cosmeticId < 0)
            throw new RuntimeException("Forbidden value on cosmeticId = " + cosmeticId + ", it doesn't respect the following condition : cosmeticId < 0");
    }
    
}
