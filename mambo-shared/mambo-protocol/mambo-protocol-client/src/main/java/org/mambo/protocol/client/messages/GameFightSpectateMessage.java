

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightSpectateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6069;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public FightDispellableEffectExtendedInformations[] effects;
    public GameActionMark[] marks;
    public short gameTurn;
    
    public GameFightSpectateMessage() { }
    
    public GameFightSpectateMessage(FightDispellableEffectExtendedInformations[] effects, GameActionMark[] marks, short gameTurn) {
        this.effects = effects;
        this.marks = marks;
        this.gameTurn = gameTurn;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(effects.length);
        for (FightDispellableEffectExtendedInformations entry : effects) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(marks.length);
        for (GameActionMark entry : marks) {
            entry.serialize(writer);
        }
        writer.writeShort(gameTurn);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        effects = new FightDispellableEffectExtendedInformations[limit];
        for (int i = 0; i < limit; i++) {
            effects[i] = new FightDispellableEffectExtendedInformations();
            effects[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        marks = new GameActionMark[limit];
        for (int i = 0; i < limit; i++) {
            marks[i] = new GameActionMark();
            marks[i].deserialize(reader);
        }
        gameTurn = reader.readShort();
        if (gameTurn < 0)
            throw new RuntimeException("Forbidden value on gameTurn = " + gameTurn + ", it doesn't respect the following condition : gameTurn < 0");
    }
    
}
