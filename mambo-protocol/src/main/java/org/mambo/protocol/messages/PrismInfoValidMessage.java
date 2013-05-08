

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismInfoValidMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5858;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ProtectedEntityWaitingForHelpInfo waitingForHelpInfo;
    
    public PrismInfoValidMessage() { }
    
    public PrismInfoValidMessage(ProtectedEntityWaitingForHelpInfo waitingForHelpInfo) {
        this.waitingForHelpInfo = waitingForHelpInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        waitingForHelpInfo.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
        waitingForHelpInfo.deserialize(buf);
    }
    
}
