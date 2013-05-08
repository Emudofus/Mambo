

// Generated on 05/08/2013 19:37:42
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterReplayWithRenameRequestMessage extends CharacterReplayRequestMessage {
    public static final int MESSAGE_ID = 6122;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    
    public CharacterReplayWithRenameRequestMessage() { }
    
    public CharacterReplayWithRenameRequestMessage(int characterId, String name) {
        super(characterId);
        this.name = name;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(name);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        name = buf.readString();
    }
    
}
