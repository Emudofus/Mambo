

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameDataPaddockObjectListAddMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5992;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PaddockItem[] paddockItemDescription;
    
    public GameDataPaddockObjectListAddMessage() { }
    
    public GameDataPaddockObjectListAddMessage(PaddockItem[] paddockItemDescription) {
        this.paddockItemDescription = paddockItemDescription;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(paddockItemDescription.length);
        for (PaddockItem entry : paddockItemDescription) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        paddockItemDescription = new PaddockItem[limit];
        for (int i = 0; i < limit; i++) {
            paddockItemDescription[i] = new PaddockItem();
            paddockItemDescription[i].deserialize(buf);
        }
    }
    
}
