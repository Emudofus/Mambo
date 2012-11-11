package org.mambo.protocol.client;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/11/12
 * Time: 22:49
 */
public abstract class NetworkMessage implements SerializerInterface, DeserializerInterface {
    public abstract NetworkMessageType getNetworkMessageType();

    @Override
    public String toString() {
        return String.format("{%d %s}", getNetworkMessageType().value(), getClass().getSimpleName());
    }

    @Override
    public int hashCode() {
        return getNetworkMessageType().value();
    }
}
