

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightResumeWithSlavesMessage extends GameFightResumeMessage {
    public static final int MESSAGE_ID = 6215;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GameFightResumeSlaveInfo[] slavesInfo;
    
    public GameFightResumeWithSlavesMessage() { }
    
    public GameFightResumeWithSlavesMessage(FightDispellableEffectExtendedInformations[] effects, GameActionMark[] marks, short gameTurn, GameFightSpellCooldown[] spellCooldowns, byte summonCount, byte bombCount, GameFightResumeSlaveInfo[] slavesInfo) {
        super(effects, marks, gameTurn, spellCooldowns, summonCount, bombCount);
        this.slavesInfo = slavesInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(slavesInfo.length);
        for (GameFightResumeSlaveInfo entry : slavesInfo) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        slavesInfo = new GameFightResumeSlaveInfo[limit];
        for (int i = 0; i < limit; i++) {
            slavesInfo[i] = new GameFightResumeSlaveInfo();
            slavesInfo[i].deserialize(buf);
        }
    }
    
}
