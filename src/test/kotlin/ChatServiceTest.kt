import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ChatServiceTest {

    @Before
    fun clearBeforeTest() {
        ChatService.clear()
    }

    @Test
    fun addUserToData() {
        // arrange
        val lena = User(
            id = 2,
            firstName = "Lena",
            lastName = "Ivanova",
            emptyList(),
            emptyList()
        )

        // act
        val result = ChatService.addUserToData(lena)

        // assert
        assertTrue(result)
    }


    @Test
    fun addMessage() {
        // arrange
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

        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        ChatService.addUserToData(vasya)
        ChatService.addUserToData(lena)
        val result = ChatService.addMessage(message1)

        //assert
        assertEquals(result, 1)
    }

    @Test
    fun addMessage_SecondChat() {
        // arrange
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

        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )
        val message3 = Message(
            dateTime = formatted,
            text = "third",
            senderId = 1,
            recipientId = 3
        )

        //act
        ChatService.addUserToData(vasya)
        ChatService.addUserToData(lena)
        ChatService.addUserToData(jora)
        ChatService.addMessage(message1)
        val result = ChatService.addMessage(message3)

        //assert
        assertEquals(result, 2)
    }

    @Test
    fun deleteMessage_True() {
        // arrange
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

        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        ChatService.addUserToData(vasya)
        ChatService.addUserToData(lena)
        ChatService.addMessage(message1)
        val result = ChatService.deleteMessage(1)

        //assert
        assertTrue(result)
    }

    @Test
    fun deleteMessage_False() {
        // arrange
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

        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        ChatService.addUserToData(vasya)
        ChatService.addUserToData(lena)
        ChatService.addMessage(message1)
        val result = ChatService.deleteMessage(5)

        //assert
        assertFalse(result)
    }

    @Test
    fun deleteChatById_True() {
        // arrange
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

        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        ChatService.addUserToData(vasya)
        ChatService.addUserToData(lena)
        ChatService.addMessage(message1)
        val chatKey = listOf(1, 2)
        val result = ChatService.deleteChatById(chatKey)

        //assert
        assertTrue(result)
    }

    @Test
    fun deleteChatById_False() {
        // arrange
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

        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        ChatService.addUserToData(vasya)
        ChatService.addUserToData(lena)
        ChatService.addMessage(message1)
        val chatKey = listOf(5, 2)
        val result = ChatService.deleteChatById(chatKey)

        //assert
        assertFalse(result)
    }

    @Test
    fun editingMessage_True() {
        // arrange
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

        val message1 = Message(
            dateTime = formatted,
            text = "first",
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

        // act
        ChatService.addUserToData(vasya)
        ChatService.addUserToData(lena)
        ChatService.addMessage(message1)
        val result = ChatService.editingMessage(updatedMessage)

        // assert
        assertTrue(result)
    }

    @Test
    fun editingMessage_False() {
        // arrange
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

        val message1 = Message(
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )
        val updatedMessage = Message(
            id = 5,
            dateTime = formatted,
            text = "UPDATED!!!",
            senderId = 1,
            recipientId = 2
        )

        // act
        ChatService.addUserToData(vasya)
        ChatService.addUserToData(lena)
        ChatService.addMessage(message1)
        val result = ChatService.editingMessage(updatedMessage)

        // assert
        assertFalse(result)
    }

    @Test
    fun getChatList() {
        // arrange
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

        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        ChatService.addUserToData(vasya)
        ChatService.addUserToData(lena)
        ChatService.addMessage(message1)
        val result = ChatService.getChatList()

        // assert
        assertEquals(result, mutableMapOf(Pair((1), mutableListOf(message1))))
    }

    @Test
    fun getMessagesFromChat() {
        // arrange
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

        val message1 = Message(
            id = 1,
            dateTime = formatted,
            text = "first",
            senderId = 1,
            recipientId = 2
        )

        //act
        ChatService.addUserToData(vasya)
        ChatService.addUserToData(lena)
        ChatService.addMessage(message1)
        val result = ChatService.getMessagesFromChat(listOf(1, 2), 1, 1)

        // assert
        assertEquals(result, listOf(message1))
    }

    @Test
    fun getUnreadChats() {
        // arrange
        val time: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val formatted: String = time.format(formatter)

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

        val message8 = Message(
            dateTime = formatted,
            text = "eighth",
            senderId = 2,
            recipientId = 3
        )

        // act
        ChatService.addUserToData(lena)
        ChatService.addUserToData(jora)
        ChatService.addMessage(message8)
        val result = ChatService.getUnreadChats(3)

        // assert
        assertTrue(result.size == 1)
    }
}