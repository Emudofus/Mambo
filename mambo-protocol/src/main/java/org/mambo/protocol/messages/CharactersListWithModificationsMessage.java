

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(charactersToRecolor.length);
        for (CharacterToRecolorInformation entry : charactersToRecolor) {
            entry.serialize(buf);
        }
        buf.writeUShort(charactersToRename.length);
        for (int entry : charactersToRename) {
            buf.writeInt(entry);
        }
        buf.writeUShort(unusableCharacters.length);
        for (int entry : unusableCharacters) {
            buf.writeInt(entry);
        }
        buf.writeUShort(charactersToRelook.length);
        for (CharacterToRelookInformation entry : charactersToRelook) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        charactersToRecolor = new CharacterToRecolorInformation[limit];
        for (int i = 0; i < limit; i++) {
            charactersToRecolor[i] = new CharacterToRecolorInformation();
            charactersToRecolor[i].deserialize(buf);
        }
        limit = buf.readUShort();
        charactersToRename = new int[limit];
        for (int i = 0; i < limit; i++) {
            charactersToRename[i] = buf.readInt();
        }
        limit = buf.readUShort();
        unusableCharacters = new int[limit];
        for (int i = 0; i < limit; i++) {
            unusableCharacters[i] = buf.readInt();
        }
        limit = buf.readUShort();
        charactersToRelook = new CharacterToRelookInformation[limit];
        for (int i = 0; i < limit; i++) {
            charactersToRelook[i] = new CharacterToRelookInformation();
            charactersToRelook[i].deserialize(buf);
        }
    }
    
}
