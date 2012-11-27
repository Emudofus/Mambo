

// Generated on 11/11/2012 20:41:22
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.core.io.*;

public class IdentificationAccountForceMessage extends IdentificationMessage {
    public static final int MESSAGE_ID = 6119;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String forcedAccountLogin;
    
    public IdentificationAccountForceMessage() { }
    
    public IdentificationAccountForceMessage(boolean autoconnect, boolean useCertificate, boolean useLoginToken, VersionExtended version, String lang, String login, byte[] credentials, short serverId, String forcedAccountLogin) {
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
