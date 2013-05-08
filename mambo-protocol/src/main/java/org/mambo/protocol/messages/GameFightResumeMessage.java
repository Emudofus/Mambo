

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightResumeMessage extends GameFightSpectateMessage {
    public static final int MESSAGE_ID = 6067;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameFightSpellCooldown[] spellCooldowns;
    public byte summonCount;
    public byte bombCount;
    
    public GameFightResumeMessage() { }
    
    public GameFightResumeMessage(FightDispellableEffectExtendedInformations[] effects, GameActionMark[] marks, short gameTurn, GameFightSpellCooldown[] spellCooldowns, byte summonCount, byte bombCount) {
        super(effects, marks, gameTurn);
        this.spellCooldowns = spellCooldowns;
        this.summonCount = summonCount;
        this.bombCount = bombCount;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(spellCooldowns.length);
        for (GameFightSpellCooldown entry : spellCooldowns) {
            entry.serialize(buf);
        }
        buf.writeByte(summonCount);
        buf.writeByte(bombCount);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        spellCooldowns = new GameFightSpellCooldown[limit];
        for (int i = 0; i < limit; i++) {
            spellCooldowns[i] = new GameFightSpellCooldown();
            spellCooldowns[i].deserialize(buf);
        }
        summonCount = buf.readByte();
        if (summonCount < 0)
            throw new RuntimeException("Forbidden value on summonCount = " + summonCount + ", it doesn't respect the following condition : summonCount < 0");
        bombCount = buf.readByte();
        if (bombCount < 0)
            throw new RuntimeException("Forbidden value on bombCount = " + bombCount + ", it doesn't respect the following condition : bombCount < 0");
    }
    
}
