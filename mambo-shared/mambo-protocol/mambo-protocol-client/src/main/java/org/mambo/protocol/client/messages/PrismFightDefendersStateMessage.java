

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(fightId);
        writer.writeUnsignedShort(mainFighters.length);
        for (CharacterMinimalPlusLookAndGradeInformations entry : mainFighters) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(reserveFighters.length);
        for (CharacterMinimalPlusLookAndGradeInformations entry : reserveFighters) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readDouble();
        int limit = reader.readUnsignedShort();
        mainFighters = new CharacterMinimalPlusLookAndGradeInformations[limit];
        for (int i = 0; i < limit; i++) {
            mainFighters[i] = new CharacterMinimalPlusLookAndGradeInformations();
            mainFighters[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        reserveFighters = new CharacterMinimalPlusLookAndGradeInformations[limit];
        for (int i = 0; i < limit; i++) {
            reserveFighters[i] = new CharacterMinimalPlusLookAndGradeInformations();
            reserveFighters[i].deserialize(reader);
        }
    }
    
}
