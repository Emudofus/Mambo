

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightSpellCooldown extends NetworkType {
    public static final short TYPE_ID = 205;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int spellId;
    public byte cooldown;
    
    public GameFightSpellCooldown() { }
    
    public GameFightSpellCooldown(int spellId, byte cooldown) {
        this.spellId = spellId;
        this.cooldown = cooldown;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(spellId);
        buf.writeByte(cooldown);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        spellId = buf.readInt();
        cooldown = buf.readByte();
        if (cooldown < 0)
            throw new RuntimeException("Forbidden value on cooldown = " + cooldown + ", it doesn't respect the following condition : cooldown < 0");
    }
    
}
