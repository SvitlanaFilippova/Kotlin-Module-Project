import java.util.Scanner

class NotesScreen {
    fun notesScreen(archive: Archive) {
        currentArchive = archive
        println("Вы находитесь внутри архива ${archive.name}. Можете добавить в него новую заметку или просмотреть ранее добавленные.")
        menuNotes.checkCommand(archive.notesList, "Заметка")

    }

    fun createNote(archive: Archive?) {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("Введите название новой заметки:")
            val name = scanner.nextLine()
            if (name != "") {
                val note = Note(name)
                archive?.notesList?.add(note)
                while (true) {
                    println("Теперь введите текст заметки ${note.name}:")
                    val text = scanner.nextLine()
                    if (text != "") {
                        note.text = text
                        println("Заметка ${note.name} сохранена успешно!")
                        return
                    } else println("Текст заметки не может быть пустым!")
                }
            } else println("Название не может быть пустым!")

        }
    }
}
