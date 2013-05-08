

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeDouble(experienceCharacter);
        buf.writeDouble(experienceMount);
        buf.writeDouble(experienceGuild);
        buf.writeDouble(experienceIncarnation);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        experienceCharacter = buf.readDouble();
        if (experienceCharacter < 0)
            throw new RuntimeException("Forbidden value on experienceCharacter = " + experienceCharacter + ", it doesn't respect the following condition : experienceCharacter < 0");
        experienceMount = buf.readDouble();
        if (experienceMount < 0)
            throw new RuntimeException("Forbidden value on experienceMount = " + experienceMount + ", it doesn't respect the following condition : experienceMount < 0");
        experienceGuild = buf.readDouble();
        if (experienceGuild < 0)
            throw new RuntimeException("Forbidden value on experienceGuild = " + experienceGuild + ", it doesn't respect the following condition : experienceGuild < 0");
        experienceIncarnation = buf.readDouble();
        if (experienceIncarnation < 0)
            throw new RuntimeException("Forbidden value on experienceIncarnation = " + experienceIncarnation + ", it doesn't respect the following condition : experienceIncarnation < 0");
    }
    
}
