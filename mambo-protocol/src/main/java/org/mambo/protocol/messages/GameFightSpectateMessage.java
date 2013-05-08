

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeUShort(effects.length);
        for (FightDispellableEffectExtendedInformations entry : effects) {
            entry.serialize(buf);
        }
        buf.writeUShort(marks.length);
        for (GameActionMark entry : marks) {
            entry.serialize(buf);
        }
        buf.writeShort(gameTurn);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        effects = new FightDispellableEffectExtendedInformations[limit];
        for (int i = 0; i < limit; i++) {
            effects[i] = new FightDispellableEffectExtendedInformations();
            effects[i].deserialize(buf);
        }
        limit = buf.readUShort();
        marks = new GameActionMark[limit];
        for (int i = 0; i < limit; i++) {
            marks[i] = new GameActionMark();
            marks[i].deserialize(buf);
        }
        gameTurn = buf.readShort();
        if (gameTurn < 0)
            throw new RuntimeException("Forbidden value on gameTurn = " + gameTurn + ", it doesn't respect the following condition : gameTurn < 0");
    }
    
}
