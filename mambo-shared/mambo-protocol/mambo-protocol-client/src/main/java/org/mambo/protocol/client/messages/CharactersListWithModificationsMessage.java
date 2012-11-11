

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class CharactersListWithModificationsMessage extends CharactersListMessage {
    public static final int MESSAGE_ID = 6120;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public CharacterToRecolorInformation[] charactersToRecolor;
    public int[] charactersToRename;
    public int[] unusableCharacters;
    
    public CharactersListWithModificationsMessage() { }
    
    public CharactersListWithModificationsMessage(boolean hasStartupActions, CharacterBaseInformations[] characters, CharacterToRecolorInformation[] charactersToRecolor, int[] charactersToRename, int[] unusableCharacters) {
        super(hasStartupActions, characters);
        this.charactersToRecolor = charactersToRecolor;
        this.charactersToRename = charactersToRename;
        this.unusableCharacters = unusableCharacters;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(charactersToRecolor.length);
        for (CharacterToRecolorInformation entry : charactersToRecolor) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(charactersToRename.length);
        for (int entry : charactersToRename) {
            writer.writeInt(entry);
        }
        writer.writeUnsignedShort(unusableCharacters.length);
        for (int entry : unusableCharacters) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        charactersToRecolor = new CharacterToRecolorInformation[limit];
        for (int i = 0; i < limit; i++) {
            charactersToRecolor[i] = new CharacterToRecolorInformation();
            charactersToRecolor[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        charactersToRename = new int[limit];
        for (int i = 0; i < limit; i++) {
            charactersToRename[i] = reader.readInt();
        }
        limit = reader.readUnsignedShort();
        unusableCharacters = new int[limit];
        for (int i = 0; i < limit; i++) {
            unusableCharacters[i] = reader.readInt();
        }
    }
    
}
