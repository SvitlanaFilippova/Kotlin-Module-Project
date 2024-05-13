import java.util.Scanner
class Menu <E> where E:Elements {
    private var scanner = Scanner(System.`in`)

    fun checkCommand(list: MutableList<E>, type: String) { // Чтение пользовательского ввода и проверка его корректности
                while (true) {
            println("Введите цифру, соответствующую нужной команде:")
            showMenu(list, type) //
            if (!scanner.hasNextInt()) {
                error()
                scanner.nextLine()
            }
             else {
                val command = scanner.nextInt()
                if ((command < 0 || command > list.size + 1)) {
                    error()
                    scanner.nextLine()
                } else if (command == list.size + 1)  {
                    if (type == "Архив") println("Работа программы завершена. Отличного дня!")
                    if (type == "Заметка") println("Возвращаемся к просмотру меню архивов.")
                    return }
                 else whatToDo(command, list, type)
            }
        }
    }
        private fun showMenu(list: MutableList<E>, type: String) { // Вывод пунктов меню. В принципе, код универсальный.
            if (type == "Архив") println("0 Создать новый архив")
            if (type == "Заметка") println("0 Создать новую заметку")
               list.forEachIndexed { index, element -> println("${index + 1} ${element.name}") }
            println("${list.size + 1} Выход")

    }

    private fun whatToDo(
            command: Int,
            list: MutableList<E>,
            type: String
         //   create: (String) -> Elements,
         //   open: (String) -> Unit
    ) {
        when (command) {
            0 -> {
                if (type == "Архив") archiveScreen.createNewArchive()
                if (type == "Заметка"&&currentArchive!=null) notesScreen.createNote(currentArchive)
            }

            else -> list[(command-1)].open()

        }
    }
}