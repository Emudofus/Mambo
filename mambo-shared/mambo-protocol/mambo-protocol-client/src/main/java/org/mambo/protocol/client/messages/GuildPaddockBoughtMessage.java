

// Generated on 11/11/2012 19:17:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        paddockInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        paddockInfo = new PaddockContentInformations();
        paddockInfo.deserialize(reader);
    }
    
}
