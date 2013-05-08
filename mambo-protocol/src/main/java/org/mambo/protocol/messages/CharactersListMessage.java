

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharactersListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 151;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean hasStartupActions;
    public CharacterBaseInformations[] characters;
    
    public CharactersListMessage() { }
    
    public CharactersListMessage(boolean hasStartupActions, CharacterBaseInformations[] characters) {
        this.hasStartupActions = hasStartupActions;
        this.characters = characters;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(hasStartupActions);
        buf.writeUShort(characters.length);
        for (CharacterBaseInformations entry : characters) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        hasStartupActions = buf.readBoolean();
        int limit = buf.readUShort();
        characters = new CharacterBaseInformations[limit];
        for (int i = 0; i < limit; i++) {
            characters[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            characters[i].deserialize(buf);
        }
    }
    
}
