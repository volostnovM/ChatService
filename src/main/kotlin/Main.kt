import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val time: LocalDateTime = LocalDateTime.now()
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    val formatted: String = time.format(formatter)

    val vasya = User(
        id = 1,
        firstName = "Vasya",
        lastName = "Borisov",
        emptyList(),
        emptyList()
    )
    val lena = User(
        id = 2,
        firstName = "Lena",
        lastName = "Ivanova",
        emptyList(),
        emptyList()
    )
    val jora = User(
        id = 3,
        firstName = "George",
        lastName = "Petrov",
        emptyList(),
        emptyList()
    )
    val leo = User(
        id = 4,
        firstName = "Leonid",
        lastName = "Kuznetsov",
        emptyList(),
        emptyList()
    )

    val message1 = Message(
        dateTime = formatted,
        text = "first",
        senderId = 1,
        recipientId = 2
    )
    val message2 = Message(
        dateTime = formatted,
        text = "second",
        senderId = 1,
        recipientId = 4
    )
    val message3 = Message(
        dateTime = formatted,
        text = "third",
        senderId = 1,
        recipientId = 3
    )
    val message4 = Message(
        dateTime = formatted,
        text = "fourth",
        senderId = 3,
        recipientId = 1
    )
    val message5 = Message(
        dateTime = formatted,
        text = "fifth",
        senderId = 2,
        recipientId = 1
    )
    val message6 = Message(
        dateTime = formatted,
        text = "sixth",
        senderId = 2,
        recipientId = 1
    )
    val message7 = Message(
        dateTime = formatted,
        text = "seventh",
        senderId = 2,
        recipientId = 1
    )
    val message8 = Message(
        dateTime = formatted,
        text = "eighth",
        senderId = 2,
        recipientId = 3
    )
    val message9 = Message(
        dateTime = formatted,
        text = "ninth",
        senderId = 2,
        recipientId = 1
    )
    val message10 = Message(
        dateTime = formatted,
        text = "tenth",
        senderId = 4,
        recipientId = 2
    )
    val message11 = Message(
        dateTime = formatted,
        text = "eleventh",
        senderId = 1,
        recipientId = 2
    )
    val updatedMessage = Message(
        id = 1,
        dateTime = formatted,
        text = "UPDATED!!!",
        senderId = 1,
        recipientId = 2
    )

    ChatService.addUserToData(vasya)
    ChatService.addUserToData(lena)
    ChatService.addUserToData(jora)
    ChatService.addUserToData(leo)

    ChatService.addMessage(message1)
    ChatService.addMessage(message2)
    ChatService.addMessage(message3)
    ChatService.addMessage(message4)
    ChatService.addMessage(message5)
    ChatService.addMessage(message6)
    ChatService.addMessage(message7)
    ChatService.addMessage(message8)
    ChatService.addMessage(message9)
    ChatService.addMessage(message10)
    ChatService.addMessage(message11)

    ChatService.editingMessage(updatedMessage)
    ChatService.getUnreadChats(1)
    ChatService.deleteMessage(8)
    ChatService.deleteChatById(listOf(3, 1))
    ChatService.getMessagesFromChat(chatId = listOf(1, 2), 5, 2)
}