

// Generated on 11/11/2012 19:17:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(slavesInfo.length);
        for (GameFightResumeSlaveInfo entry : slavesInfo) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        slavesInfo = new GameFightResumeSlaveInfo[limit];
        for (int i = 0; i < limit; i++) {
            slavesInfo[i] = new GameFightResumeSlaveInfo();
            slavesInfo[i].deserialize(reader);
        }
    }
    
}
