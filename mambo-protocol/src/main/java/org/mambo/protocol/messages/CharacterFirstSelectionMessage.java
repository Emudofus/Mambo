

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterFirstSelectionMessage extends CharacterSelectionMessage {
    public static final int MESSAGE_ID = 6084;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean doTutorial;
    
    public CharacterFirstSelectionMessage() { }
    
    public CharacterFirstSelectionMessage(int id, boolean doTutorial) {
        super(id);
        this.doTutorial = doTutorial;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeBoolean(doTutorial);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        doTutorial = buf.readBoolean();
    }
    
}
