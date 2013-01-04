

// Generated on 01/04/2013 14:54:40
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(fightId);
        writer.writeUnsignedShort(charactersDescription.length);
        for (CharacterMinimalPlusLookAndGradeInformations entry : charactersDescription) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readDouble();
        int limit = reader.readUnsignedShort();
        charactersDescription = new CharacterMinimalPlusLookAndGradeInformations[limit];
        for (int i = 0; i < limit; i++) {
            charactersDescription[i] = new CharacterMinimalPlusLookAndGradeInformations();
            charactersDescription[i].deserialize(reader);
        }
    }
    
}
