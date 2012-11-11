

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightSpellCooldown implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 205;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(spellId);
        writer.writeByte(cooldown);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        spellId = reader.readInt();
        cooldown = reader.readByte();
        if (cooldown < 0)
            throw new RuntimeException("Forbidden value on cooldown = " + cooldown + ", it doesn't respect the following condition : cooldown < 0");
    }
    
}
