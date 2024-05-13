import java.util.Scanner
var archivesList: MutableList<Archive> = mutableListOf()
val archiveScreen = ArchiveScreen()
val notesScreen = NotesScreen()
val menuArchives = Menu<Archive>()
val menuNotes = Menu<Note>()
var currentArchive: Archive? = null
fun error() { println("\n" +
            "Некорректный ввод! Команда должна быть целым числом из списка ниже.")
}
fun main(args: Array<String>) {
    println("Привет! В этом приложении вы можете создавать архивы для заметок и сами заметки. И, конечно, просматривать их. Начнём!")

    menuArchives.checkCommand(archivesList, "Архив")



}


