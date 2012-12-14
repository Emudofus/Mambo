

// Generated on 12/14/2012 18:44:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class IdentificationAccountForceMessage extends IdentificationMessage {
    public static final int MESSAGE_ID = 6119;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String forcedAccountLogin;
    
    public IdentificationAccountForceMessage() { }
    
    public IdentificationAccountForceMessage(boolean autoconnect, boolean useCertificate, boolean useLoginToken, VersionExtended version, String lang, byte[] credentials, short serverId, String forcedAccountLogin) {
        super(autoconnect, useCertificate, useLoginToken, version, lang, credentials, serverId);
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
