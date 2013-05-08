

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismFightDefenderAddMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5895;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double fightId;
    public CharacterMinimalPlusLookAndGradeInformations fighterMovementInformations;
    public boolean inMain;
    
    public PrismFightDefenderAddMessage() { }
    
    public PrismFightDefenderAddMessage(double fightId, CharacterMinimalPlusLookAndGradeInformations fighterMovementInformations, boolean inMain) {
        this.fightId = fightId;
        this.fighterMovementInformations = fighterMovementInformations;
        this.inMain = inMain;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeDouble(fightId);
        fighterMovementInformations.serialize(buf);
        buf.writeBoolean(inMain);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        fightId = buf.readDouble();
        fighterMovementInformations = new CharacterMinimalPlusLookAndGradeInformations();
        fighterMovementInformations.deserialize(buf);
        inMain = buf.readBoolean();
    }
    
}
