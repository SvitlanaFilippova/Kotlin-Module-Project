import java.util.Scanner

abstract class Elements(val name: String? ) {
   abstract fun open ()
}

class Archive(name: String? ): Elements(name = name ) {
    val notesList: MutableList<Note> = mutableListOf()
     override fun open() {
        notesScreen.notesScreen(this)
           }
}
    class Note(name: String?) : Elements(name = name) {
        var text: String = ""
         override fun open() {
           println("Вы просматриваете заметку $name. Вот какой текст в ней сохранён:")
           println("\"$text\" \n")

// Дополнительно решила сделать минимальную функциональность по работе с существующими заметками
             println("Вы можете удалить заметку или вернуться назад.\n " +
                     "Что будем делать?")
             println("    0 Удалить заметку\n    1 Вернуться назад")
             val scanner = Scanner(System.`in`)
             if (!scanner.hasNextInt()) {
                 error()
                 scanner.nextLine()
             } else {
                 val command = scanner.nextInt()
                 if ((command < 0 || command > 1)) {
                    error()
                     scanner.nextLine()
                 } else {
                     when (command) {
                             0 -> {
                                 println("Заметка ${this.name} удалена успешно")
                                 currentArchive?.notesList?.remove(this)
                                 return
                             }
                             1 -> return

                     }
                 }
             }
         }

    }

