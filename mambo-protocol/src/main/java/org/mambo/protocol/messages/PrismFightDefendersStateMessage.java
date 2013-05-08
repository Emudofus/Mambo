

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismFightDefendersStateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5899;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public CharacterMinimalPlusLookAndGradeInformations[] mainFighters;
    public CharacterMinimalPlusLookAndGradeInformations[] reserveFighters;
    
    public PrismFightDefendersStateMessage() { }
    
    public PrismFightDefendersStateMessage(double fightId, CharacterMinimalPlusLookAndGradeInformations[] mainFighters, CharacterMinimalPlusLookAndGradeInformations[] reserveFighters) {
        this.fightId = fightId;
        this.mainFighters = mainFighters;
        this.reserveFighters = reserveFighters;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(fightId);
        buf.writeUShort(mainFighters.length);
        for (CharacterMinimalPlusLookAndGradeInformations entry : mainFighters) {
            entry.serialize(buf);
        }
        buf.writeUShort(reserveFighters.length);
        for (CharacterMinimalPlusLookAndGradeInformations entry : reserveFighters) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readDouble();
        int limit = buf.readUShort();
        mainFighters = new CharacterMinimalPlusLookAndGradeInformations[limit];
        for (int i = 0; i < limit; i++) {
            mainFighters[i] = new CharacterMinimalPlusLookAndGradeInformations();
            mainFighters[i].deserialize(buf);
        }
        limit = buf.readUShort();
        reserveFighters = new CharacterMinimalPlusLookAndGradeInformations[limit];
        for (int i = 0; i < limit; i++) {
            reserveFighters[i] = new CharacterMinimalPlusLookAndGradeInformations();
            reserveFighters[i].deserialize(buf);
        }
    }
    
}
