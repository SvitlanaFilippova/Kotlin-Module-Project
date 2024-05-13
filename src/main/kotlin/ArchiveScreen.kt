import java.util.Scanner

class ArchiveScreen {
    private var scanner = Scanner(System.`in`)
    fun createNewArchive() {
        while (true) {
            println("Введите название нового архива:")
            val name = scanner.nextLine()
            if (name != "") {
                val archive = Archive(name)
                archivesList.add(archive)
                println("Успешно создали архив ${archive.name}. Теперь можно зайти в него, чтобы добавить заметки")
                break
            } else {
                println("Название не может быть пустым!")
            }
        }
    }
    }



