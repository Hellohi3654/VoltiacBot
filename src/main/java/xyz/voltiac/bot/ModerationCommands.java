package xyz.voltiac.bot;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

import javax.swing.*;

public class ModerationCommands {
    void ModCommandListeners(GatewayDiscordClient client) {
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .subscribe(event -> {
                    Message Command = event.getMessage();
                    if ("!lockdown".equalsIgnoreCase(Command.getContent())) {
                        final String username = Command.getAuthor().get().getUsername();
                        final String avatar = Command.getAuthor().get().getAvatarUrl();
                        final MessageChannel channel = Command.getChannel().block();

                        System.out.println("Lockdown Start Command Executed By: " + username);
                    }
                    if ("!lockdown end".equalsIgnoreCase(Command.getContent())) {
                        final String username = Command.getAuthor().get().getUsername();
                        final String avatar = Command.getAuthor().get().getAvatarUrl();
                        final MessageChannel channel = Command.getChannel().block();

                        System.out.println("Lockdown End Command Executed By: " + username);
                    }
                });
    }
}
