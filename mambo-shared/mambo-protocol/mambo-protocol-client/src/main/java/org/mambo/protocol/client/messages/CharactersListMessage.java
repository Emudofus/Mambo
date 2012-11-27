

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(hasStartupActions);
        writer.writeUnsignedShort(characters.length);
        for (CharacterBaseInformations entry : characters) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        hasStartupActions = reader.readBoolean();
        int limit = reader.readUnsignedShort();
        characters = new CharacterBaseInformations[limit];
        for (int i = 0; i < limit; i++) {
            characters[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), CharacterBaseInformations.class);
            characters[i].deserialize(reader);
        }
    }
    
}
