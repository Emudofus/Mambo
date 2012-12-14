

// Generated on 12/14/2012 18:44:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(fightId);
        fighterMovementInformations.serialize(writer);
        writer.writeBoolean(inMain);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readDouble();
        fighterMovementInformations = new CharacterMinimalPlusLookAndGradeInformations();
        fighterMovementInformations.deserialize(reader);
        inMain = reader.readBoolean();
    }
    
}
