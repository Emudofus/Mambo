

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        waitingForHelpInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
        waitingForHelpInfo.deserialize(reader);
    }
    
}
