

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismFightAttackerAddMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5893;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public CharacterMinimalPlusLookAndGradeInformations[] charactersDescription;
    
    public PrismFightAttackerAddMessage() { }
    
    public PrismFightAttackerAddMessage(double fightId, CharacterMinimalPlusLookAndGradeInformations[] charactersDescription) {
        this.fightId = fightId;
        this.charactersDescription = charactersDescription;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(fightId);
        buf.writeUShort(charactersDescription.length);
        for (CharacterMinimalPlusLookAndGradeInformations entry : charactersDescription) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readDouble();
        int limit = buf.readUShort();
        charactersDescription = new CharacterMinimalPlusLookAndGradeInformations[limit];
        for (int i = 0; i < limit; i++) {
            charactersDescription[i] = new CharacterMinimalPlusLookAndGradeInformations();
            charactersDescription[i].deserialize(buf);
        }
    }
    
}
