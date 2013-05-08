

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterSelectedSuccessMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 153;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public CharacterBaseInformations infos;
    
    public CharacterSelectedSuccessMessage() { }
    
    public CharacterSelectedSuccessMessage(CharacterBaseInformations infos) {
        this.infos = infos;
    }
    
    @Override
    public void serialize(Buffer buf) {
        infos.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        infos = new CharacterBaseInformations();
        infos.deserialize(buf);
    }
    
}
