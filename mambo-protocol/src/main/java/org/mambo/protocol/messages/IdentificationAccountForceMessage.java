

// Generated on 05/08/2013 19:37:37
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(forcedAccountLogin);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        forcedAccountLogin = buf.readString();
    }
    
}
