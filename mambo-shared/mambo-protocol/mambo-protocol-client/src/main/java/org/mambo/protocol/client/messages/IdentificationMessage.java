

// Generated on 12/14/2012 18:44:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, autoconnect);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, useCertificate);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, useLoginToken);
        writer.writeUnsignedByte(flag1);
        version.serialize(writer);
        writer.writeString(lang);
        writer.writeUnsignedShort(credentials.length);
        for (byte entry : credentials) {
            writer.writeByte(entry);
        }
        writer.writeShort(serverId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        autoconnect = BooleanByteWrapper.getFlag(flag1, 0);
        useCertificate = BooleanByteWrapper.getFlag(flag1, 1);
        useLoginToken = BooleanByteWrapper.getFlag(flag1, 2);
        version = new VersionExtended();
        version.deserialize(reader);
        lang = reader.readString();
        int limit = reader.readUnsignedShort();
        credentials = new byte[limit];
        for (int i = 0; i < limit; i++) {
            credentials[i] = reader.readByte();
        }
        serverId = reader.readShort();
    }
    
}
