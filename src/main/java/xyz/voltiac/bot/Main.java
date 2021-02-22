package xyz.voltiac.bot;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import discord4j.core.object.reaction.ReactionEmoji;
import xyz.voltiac.bot.*;

public class Main {
    static GatewayDiscordClient client = DiscordClientBuilder.create("ODA5NDg3MDUxNTY0OTA4NTc2.YCVzkA.TvEwiXMFGoVnej5hwBKSqBzJAsY")
            .build()
            .login()
            .block();
    public static void main(String[] args) {
        Classes classes = new Classes();
        classes.Classes(client);
        assert client != null;
        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe(event -> {
                    User self = event.getSelf();
                    System.out.printf(
                            "Logged in as %s#%s%n", self.getUsername(), self.getDiscriminator()
                   );
                    Message message = client.getMessageById(Snowflake.of(808838744609652784L), Snowflake.of(809278160704897034L)).block();
                    assert message != null;
                    message.addReaction(ReactionEmoji.unicode("\u2705")).block();
                });
        client.onDisconnect().block();
    }
}
