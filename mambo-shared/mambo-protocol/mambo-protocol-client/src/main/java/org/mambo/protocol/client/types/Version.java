

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class Version implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 11;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte major;
    public byte minor;
    public byte release;
    public int revision;
    public byte patch;
    public byte buildType;
    
    public Version() { }
    
    public Version(byte major, byte minor, byte release, int revision, byte patch, byte buildType) {
        this.major = major;
        this.minor = minor;
        this.release = release;
        this.revision = revision;
        this.patch = patch;
        this.buildType = buildType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(major);
        writer.writeByte(minor);
        writer.writeByte(release);
        writer.writeUnsignedShort(revision);
        writer.writeByte(patch);
        writer.writeByte(buildType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        major = reader.readByte();
        if (major < 0)
            throw new RuntimeException("Forbidden value on major = " + major + ", it doesn't respect the following condition : major < 0");
        minor = reader.readByte();
        if (minor < 0)
            throw new RuntimeException("Forbidden value on minor = " + minor + ", it doesn't respect the following condition : minor < 0");
        release = reader.readByte();
        if (release < 0)
            throw new RuntimeException("Forbidden value on release = " + release + ", it doesn't respect the following condition : release < 0");
        revision = reader.readUnsignedShort();
        if (revision < 0 || revision > 65535)
            throw new RuntimeException("Forbidden value on revision = " + revision + ", it doesn't respect the following condition : revision < 0 || revision > 65535");
        patch = reader.readByte();
        if (patch < 0)
            throw new RuntimeException("Forbidden value on patch = " + patch + ", it doesn't respect the following condition : patch < 0");
        buildType = reader.readByte();
        if (buildType < 0)
            throw new RuntimeException("Forbidden value on buildType = " + buildType + ", it doesn't respect the following condition : buildType < 0");
    }
    
}
