

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterSelectionWithRecolorMessage extends CharacterSelectionMessage {
    public static final int MESSAGE_ID = 6075;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] indexedColor;
    
    public CharacterSelectionWithRecolorMessage() { }
    
    public CharacterSelectionWithRecolorMessage(int id, int[] indexedColor) {
        super(id);
        this.indexedColor = indexedColor;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(indexedColor.length);
        for (int entry : indexedColor) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        indexedColor = new int[limit];
        for (int i = 0; i < limit; i++) {
            indexedColor[i] = buf.readInt();
        }
    }
    
}
