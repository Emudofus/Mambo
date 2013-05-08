

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AcquaintanceSearchMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6144;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String nickname;
    
    public AcquaintanceSearchMessage() { }
    
    public AcquaintanceSearchMessage(String nickname) {
        this.nickname = nickname;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeString(nickname);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        nickname = buf.readString();
    }
    
}
