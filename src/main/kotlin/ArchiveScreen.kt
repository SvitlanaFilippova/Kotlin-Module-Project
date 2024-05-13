import java.util.Scanner

class ArchiveScreen {
    var archivesList: MutableList<Archive> = mutableListOf()
    private var scanner = Scanner(System.`in`)
    fun showMenu(archives: MutableList<Archive>) { // Вывод пунктов меню
        println("0 Создать архив")
        for (archive in archives) {
            println("${archives.indexOf(archive) + 1} $archive") //кривой вывод, допилить!!!
        }
        println("${archivesList.size + 1} Выход")
    }

    fun checkCommand() { // Чтение пользовательского ввода и проверка его корректности
        while (true) {
            println("Введите цифру, соответствующую нужной команде или выбранному архиву:")
            showMenu(archivesList)
            // тут как-то надо создать экземпляр сканера
            if (!scanner.hasNextInt()) {
                println("" +
                        "Некорректный ввод! Команда должна быть целым числом из списка ниже.")
                scanner.nextLine()
            } else {
                var command = scanner.nextInt()
                if (command < 0 || command > archivesList.size + 1) {
                    println("" +
                            "Некорректный ввод! Команда должна быть целым числом из списка ниже.")
                }
                else whatToDo(command)
            }
        }
    }


            fun whatToDo(command: Int) {// выполнение определённых операций на выбор пункта меню.
            when (command) {
                0 -> createNewArchive()
                archivesList.size + 1 -> return  //выход из программы. Не работает!!!! :(
                else -> openArchive(archivesList[(command-1)]) // - зайти внутрь архива, номер которого выберет юзер
            }
        }

    fun createNewArchive() {
        println("Введите название нового архива:")
        var archive = Archive((Scanner(System.`in`).nextLine()))
        archivesList.add(archive)
        println("Архив ${archive.name} создан успешно! Теперь вы можете зайти в него и добавить туда заметки.")
    }
    }

fun openArchive(archive: Archive) {

}

