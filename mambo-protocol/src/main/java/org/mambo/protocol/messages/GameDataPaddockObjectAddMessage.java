

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameDataPaddockObjectAddMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5990;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PaddockItem paddockItemDescription;
    
    public GameDataPaddockObjectAddMessage() { }
    
    public GameDataPaddockObjectAddMessage(PaddockItem paddockItemDescription) {
        this.paddockItemDescription = paddockItemDescription;
    }
    
    @Override
    public void serialize(Buffer buf) {
        paddockItemDescription.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        paddockItemDescription = new PaddockItem();
        paddockItemDescription.deserialize(buf);
    }
    
}
