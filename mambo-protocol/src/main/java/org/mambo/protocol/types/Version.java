

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class Version extends NetworkType {
    public static final short TYPE_ID = 11;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeByte(major);
        buf.writeByte(minor);
        buf.writeByte(release);
        buf.writeInt(revision);
        buf.writeByte(patch);
        buf.writeByte(buildType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        major = buf.readByte();
        if (major < 0)
            throw new RuntimeException("Forbidden value on major = " + major + ", it doesn't respect the following condition : major < 0");
        minor = buf.readByte();
        if (minor < 0)
            throw new RuntimeException("Forbidden value on minor = " + minor + ", it doesn't respect the following condition : minor < 0");
        release = buf.readByte();
        if (release < 0)
            throw new RuntimeException("Forbidden value on release = " + release + ", it doesn't respect the following condition : release < 0");
        revision = buf.readInt();
        if (revision < 0)
            throw new RuntimeException("Forbidden value on revision = " + revision + ", it doesn't respect the following condition : revision < 0");
        patch = buf.readByte();
        if (patch < 0)
            throw new RuntimeException("Forbidden value on patch = " + patch + ", it doesn't respect the following condition : patch < 0");
        buildType = buf.readByte();
        if (buildType < 0)
            throw new RuntimeException("Forbidden value on buildType = " + buildType + ", it doesn't respect the following condition : buildType < 0");
    }
    
}
