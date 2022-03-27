package discordBot;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import java.awt.*;

public class GeneralCommands implements MessageCreateListener {
    public static final EmbedBuilder welcomeEmbed = new EmbedBuilder().setTitle("Welcome to our server! We are very happy to gain a new cool member like you!")
            .setDescription("Make sure to read the rules and read channel descriptions before you start. It's a very crucial thing to do! " +
                    "\n\nif you have any queries regarding on this server, feel free to ask the moderator team!")
            .addField("I feel kind of lost, which channel should I click on?","Go to #welcome-and-info!")
            .addField("How can I access to the bot's commands?","By typing `"+Constants.prefix+"help`")
            .setColor(Color.CYAN);
    /* Help commands */
    public static final EmbedBuilder helpCommands = new EmbedBuilder().setTitle("Jolly Roger Bot Commands")
            .addField("General commands", "`"+Constants.prefix+"welcome "+Constants.prefix+"help "+Constants.prefix+"invite`")
            .addField("Fun commands", "`"+Constants.prefix+"ping "+Constants.prefix+"randomfact(SOON) "+Constants.prefix+"luckynumber`")
            .setColor(Color.ORANGE);

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (!event.getMessageAuthor().isRegularUser() && !event.getMessageAuthor().isBotOwner()){
            return;
        }
        if (event.getMessageContent().equalsIgnoreCase(Constants.prefix+"welcome")) {
            event.getChannel().sendMessage(welcomeEmbed);
        }else if (event.getMessageContent().equalsIgnoreCase(Constants.prefix+"help")) {
            event.getChannel().sendMessage(helpCommands);
        }else if(event.getMessageContent().equalsIgnoreCase(Constants.prefix+"invite")){
            event.getChannel().sendMessage("Invite the bot to your server: \nhttps://discord.com/oauth2/authorize?client_id=226004022635528192&scope=bot&permissions=0");
        }else if (event.getMessageContent().equalsIgnoreCase(Constants.prefix+"ping")) {
            // to mention a user, insert `<@ event.getMessageAuthor().getId() >` .
            event.getChannel().sendMessage("Okay, I will try to ping you. Hello, <@"
                    + event.getMessageAuthor().getId() + "> !");
        }
    }
}
