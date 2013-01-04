

// Generated on 01/04/2013 14:54:21
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterReplayWithRecolorRequestMessage extends CharacterReplayRequestMessage {
    public static final int MESSAGE_ID = 6111;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] indexedColor;
    
    public CharacterReplayWithRecolorRequestMessage() { }
    
    public CharacterReplayWithRecolorRequestMessage(int characterId, int[] indexedColor) {
        super(characterId);
        this.indexedColor = indexedColor;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(indexedColor.length);
        for (int entry : indexedColor) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        indexedColor = new int[limit];
        for (int i = 0; i < limit; i++) {
            indexedColor[i] = reader.readInt();
        }
    }
    
}
