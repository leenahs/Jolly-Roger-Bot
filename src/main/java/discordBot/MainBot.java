package discordBot;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;
import java.util.Optional;

public class MainBot {
    public static void main(String[] args) {
        DiscordApi api = new DiscordApiBuilder().setToken(Constants.token).login().join();
        FallbackLoggerConfiguration.setDebug(true);

        api.addListener(new GeneralCommands());
        api.addListener(new FunCommands());

        api.addServerMemberJoinListener(event -> {
            Optional<TextChannel> channel = api.getTextChannelById("686063822510882842");
            if (channel.isPresent()){
                channel.get().sendMessage("Welcome to the server, " + event.getUser().getMentionTag() + "! Please enjoy your stay!");
            }else{
                System.out.println("has not joined yet");
            }
        });

        System.out.println("Invite Jolly Roger bot in your server: " + api.createBotInvite());
    }
}