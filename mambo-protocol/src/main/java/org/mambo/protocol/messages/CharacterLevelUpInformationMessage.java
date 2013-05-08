

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterLevelUpInformationMessage extends CharacterLevelUpMessage {
    public static final int MESSAGE_ID = 6076;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    public int id;
    
    public CharacterLevelUpInformationMessage() { }
    
    public CharacterLevelUpInformationMessage(short newLevel, String name, int id) {
        super(newLevel);
        this.name = name;
        this.id = id;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(name);
        buf.writeInt(id);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        name = buf.readString();
        id = buf.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
    }
    
}
