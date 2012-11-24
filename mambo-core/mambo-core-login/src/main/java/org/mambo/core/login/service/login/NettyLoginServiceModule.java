package org.mambo.core.login.service.login;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.mambo.core.network.NetworkHandlerManager;
import org.mambo.core.network.base.ReflectiveNetworkHandlerManager;
import org.mambo.core.network.netty.DefaultNettyChannelPipelineFactory;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 24/11/12
 * Time: 20:16
 */
public class NettyLoginServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(LoginService.class).to(NettyLoginService.class).in(Singleton.class);

        bind(ChannelPipelineFactory.class).to(DefaultNettyChannelPipelineFactory.class).in(Singleton.class);

        bind(new TypeLiteral<NetworkHandlerManager<LoginClient>>(){})
                .to(new TypeLiteral<ReflectiveNetworkHandlerManager<LoginClient>>() {})
                .in(Singleton.class);
    }
}
