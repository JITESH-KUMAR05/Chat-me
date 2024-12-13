public class ChatController {
    private ChatUI chatUI;
    private MessageModel messageModel;

    public ChatController(ChatUI chatUI, MessageModel messageModel) {
        this.chatUI = chatUI;
        this.messageModel = messageModel;
        initialize();
    }

    private void initialize() {
        chatUI.setSendMessageListener(this::sendMessage);
        chatUI.setReceiveMessageListener(this::receiveMessage);
    }

    public void sendMessage(String content) {
        Message message = new Message("User", content, System.currentTimeMillis());
        messageModel.addMessage(message);
        chatUI.displayMessage(message);
    }

    public void receiveMessage(Message message) {
        chatUI.displayMessage(message);
    }
}