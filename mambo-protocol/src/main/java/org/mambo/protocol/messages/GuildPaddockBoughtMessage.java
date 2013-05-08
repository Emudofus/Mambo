

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildPaddockBoughtMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5952;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PaddockContentInformations paddockInfo;
    
    public GuildPaddockBoughtMessage() { }
    
    public GuildPaddockBoughtMessage(PaddockContentInformations paddockInfo) {
        this.paddockInfo = paddockInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        paddockInfo.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        paddockInfo = new PaddockContentInformations();
        paddockInfo.deserialize(buf);
    }
    
}
