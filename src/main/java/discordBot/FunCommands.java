package discordBot;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class FunCommands implements MessageCreateListener {
//    int luckyno = 0;
    @Override
    public void onMessageCreate(MessageCreateEvent event){
        if(!event.getMessageAuthor().isRegularUser() && !event.getMessageAuthor().isBotOwner()){
            return;
        }
        if (event.getMessageContent().equalsIgnoreCase(Constants.prefix+"luckynumber")) {
            event.getChannel().sendMessage("Your lucky number is "+ luckynum() +"!");
        }
    }
    public int luckynum(){
        int luckyno = 0, min = 1, max = 100;
        for(int i = min; i <=max; i++) {
            luckyno = (int) (Math.random()*(max-min)) + min;
        }
        return luckyno;
    }
}
