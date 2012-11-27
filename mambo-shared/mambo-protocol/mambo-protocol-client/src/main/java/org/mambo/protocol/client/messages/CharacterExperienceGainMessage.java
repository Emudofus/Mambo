

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterExperienceGainMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6321;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double experienceCharacter;
    public double experienceMount;
    public double experienceGuild;
    public double experienceIncarnation;
    
    public CharacterExperienceGainMessage() { }
    
    public CharacterExperienceGainMessage(double experienceCharacter, double experienceMount, double experienceGuild, double experienceIncarnation) {
        this.experienceCharacter = experienceCharacter;
        this.experienceMount = experienceMount;
        this.experienceGuild = experienceGuild;
        this.experienceIncarnation = experienceIncarnation;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(experienceCharacter);
        writer.writeDouble(experienceMount);
        writer.writeDouble(experienceGuild);
        writer.writeDouble(experienceIncarnation);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        experienceCharacter = reader.readDouble();
        if (experienceCharacter < 0)
            throw new RuntimeException("Forbidden value on experienceCharacter = " + experienceCharacter + ", it doesn't respect the following condition : experienceCharacter < 0");
        experienceMount = reader.readDouble();
        if (experienceMount < 0)
            throw new RuntimeException("Forbidden value on experienceMount = " + experienceMount + ", it doesn't respect the following condition : experienceMount < 0");
        experienceGuild = reader.readDouble();
        if (experienceGuild < 0)
            throw new RuntimeException("Forbidden value on experienceGuild = " + experienceGuild + ", it doesn't respect the following condition : experienceGuild < 0");
        experienceIncarnation = reader.readDouble();
        if (experienceIncarnation < 0)
            throw new RuntimeException("Forbidden value on experienceIncarnation = " + experienceIncarnation + ", it doesn't respect the following condition : experienceIncarnation < 0");
    }
    
}
