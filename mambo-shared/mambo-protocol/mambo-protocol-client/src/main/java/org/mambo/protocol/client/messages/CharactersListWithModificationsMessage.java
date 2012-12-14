

// Generated on 12/14/2012 18:44:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharactersListWithModificationsMessage extends CharactersListMessage {
    public static final int MESSAGE_ID = 6120;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public CharacterToRecolorInformation[] charactersToRecolor;
    public int[] charactersToRename;
    public int[] unusableCharacters;
    public CharacterToRelookInformation[] charactersToRelook;
    
    public CharactersListWithModificationsMessage() { }
    
    public CharactersListWithModificationsMessage(boolean hasStartupActions, CharacterBaseInformations[] characters, CharacterToRecolorInformation[] charactersToRecolor, int[] charactersToRename, int[] unusableCharacters, CharacterToRelookInformation[] charactersToRelook) {
        super(hasStartupActions, characters);
        this.charactersToRecolor = charactersToRecolor;
        this.charactersToRename = charactersToRename;
        this.unusableCharacters = unusableCharacters;
        this.charactersToRelook = charactersToRelook;
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
        writer.writeUnsignedShort(charactersToRelook.length);
        for (CharacterToRelookInformation entry : charactersToRelook) {
            entry.serialize(writer);
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
        limit = reader.readUnsignedShort();
        charactersToRelook = new CharacterToRelookInformation[limit];
        for (int i = 0; i < limit; i++) {
            charactersToRelook[i] = new CharacterToRelookInformation();
            charactersToRelook[i].deserialize(reader);
        }
    }
    
}
