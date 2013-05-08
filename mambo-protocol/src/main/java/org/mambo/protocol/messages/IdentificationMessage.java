

// Generated on 05/08/2013 19:37:37
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IdentificationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 4;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean autoconnect;
    public boolean useCertificate;
    public boolean useLoginToken;
    public VersionExtended version;
    public String lang;
    public byte[] credentials;
    public short serverId;
    
    public IdentificationMessage() { }
    
    public IdentificationMessage(boolean autoconnect, boolean useCertificate, boolean useLoginToken, VersionExtended version, String lang, byte[] credentials, short serverId) {
        this.autoconnect = autoconnect;
        this.useCertificate = useCertificate;
        this.useLoginToken = useLoginToken;
        this.version = version;
        this.lang = lang;
        this.credentials = credentials;
        this.serverId = serverId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, autoconnect);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, useCertificate);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, useLoginToken);
        buf.writeUByte(flag1);
        version.serialize(buf);
        buf.writeString(lang);
        buf.writeUShort(credentials.length);
        for (byte entry : credentials) {
            buf.writeByte(entry);
        }
        buf.writeShort(serverId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        autoconnect = BooleanByteWrapper.getFlag(flag1, 0);
        useCertificate = BooleanByteWrapper.getFlag(flag1, 1);
        useLoginToken = BooleanByteWrapper.getFlag(flag1, 2);
        version = new VersionExtended();
        version.deserialize(buf);
        lang = buf.readString();
        int limit = buf.readUShort();
        credentials = new byte[limit];
        for (int i = 0; i < limit; i++) {
            credentials[i] = buf.readByte();
        }
        serverId = buf.readShort();
    }
    
}
