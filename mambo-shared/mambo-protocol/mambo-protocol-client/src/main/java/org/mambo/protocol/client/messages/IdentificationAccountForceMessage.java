

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class IdentificationAccountForceMessage extends IdentificationMessage {
    public static final int MESSAGE_ID = 6119;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String forcedAccountLogin;
    
    public IdentificationAccountForceMessage() { }
    
    public IdentificationAccountForceMessage(boolean autoconnect, boolean useCertificate, boolean useLoginToken, Version version, String lang, String login, byte[] credentials, short serverId, String forcedAccountLogin) {
        super(autoconnect, useCertificate, useLoginToken, version, lang, login, credentials, serverId);
        this.forcedAccountLogin = forcedAccountLogin;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(forcedAccountLogin);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        forcedAccountLogin = reader.readString();
    }
    
}
