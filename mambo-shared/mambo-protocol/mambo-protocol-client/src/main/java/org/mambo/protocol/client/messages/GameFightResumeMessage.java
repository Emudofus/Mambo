

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(spellCooldowns.length);
        for (GameFightSpellCooldown entry : spellCooldowns) {
            entry.serialize(writer);
        }
        writer.writeByte(summonCount);
        writer.writeByte(bombCount);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        spellCooldowns = new GameFightSpellCooldown[limit];
        for (int i = 0; i < limit; i++) {
            spellCooldowns[i] = new GameFightSpellCooldown();
            spellCooldowns[i].deserialize(reader);
        }
        summonCount = reader.readByte();
        if (summonCount < 0)
            throw new RuntimeException("Forbidden value on summonCount = " + summonCount + ", it doesn't respect the following condition : summonCount < 0");
        bombCount = reader.readByte();
        if (bombCount < 0)
            throw new RuntimeException("Forbidden value on bombCount = " + bombCount + ", it doesn't respect the following condition : bombCount < 0");
    }
    
}
